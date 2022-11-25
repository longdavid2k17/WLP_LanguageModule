package pl.com.kantoch.WLP_LanguageModule.amqp;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.com.kantoch.WLP_LanguageModule.entities.Label;
import pl.com.kantoch.WLP_LanguageModule.entities.View;
import pl.com.kantoch.WLP_LanguageModule.entities.payloads.request.ViewTranslationRequest;
import pl.com.kantoch.WLP_LanguageModule.entities.payloads.response.LabelDTO;
import pl.com.kantoch.WLP_LanguageModule.entities.payloads.response.RabbitMQConfigurationDTO;
import pl.com.kantoch.WLP_LanguageModule.services.LabelService;
import pl.com.kantoch.WLP_LanguageModule.services.ViewService;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RabbitMQTranslationProvider implements TranslationProvider {

    private final RabbitTemplate rabbitTemplate;
    private final LabelService labelService;
    private final ViewService viewService;
    private final RabbitMQConfigurationLoader rabbitMQConfigurationLoader;
    private CachingConnectionFactory factory;
    private final Gson gson;

    public RabbitMQTranslationProvider(LabelService labelService,
                                       ViewService viewService,
                                       RabbitMQConfigurationLoader rabbitMQConfigurationLoader) {
        this.labelService = labelService;
        this.viewService = viewService;
        this.rabbitMQConfigurationLoader = rabbitMQConfigurationLoader;
        this.gson = new Gson();

        initRabbitConfiguration();
        this.rabbitTemplate = new RabbitTemplate(factory);
    }

    private void initRabbitConfiguration() {
        RabbitMQConfigurationDTO configuration = rabbitMQConfigurationLoader.loadAMQPConfiguration();
        CachingConnectionFactory factory = new CachingConnectionFactory(configuration.getHost());
        factory.setPort(configuration.getPort());
        factory.setUsername(configuration.getUsername());
        factory.setPassword(configuration.getPassword());
        this.factory = factory;
    }

    @Override
    @RabbitListener(queues = "translation-requests")
    public void getTranslations(String json) {
        ViewTranslationRequest request = gson.fromJson(json,ViewTranslationRequest.class);
        if(request!=null){
            Optional<View> optionalView = viewService.getAllForApplication(request.getApplicationName())
                    .stream()
                    .filter(e->e.getName().equals(request.getViewName()))
                    .findFirst();
            if(optionalView.isEmpty()) throw new IllegalStateException("No such view is declared");
            Collection<Label> labels = labelService.getForView(optionalView.get().getId())
                    .stream()
                    .filter(e->e.getLanguage().equals(request.getLanguage()))
                    .collect(Collectors.toUnmodifiableList());
            Collection<LabelDTO> labelDTOs = labels
                    .stream()
                    .map(LabelDTO::new)
                    .collect(Collectors.toUnmodifiableList());
            String finalJson = gson.toJson(labelDTOs);
            rabbitTemplate.convertAndSend("translation-responses", finalJson);
        }
    }
}
