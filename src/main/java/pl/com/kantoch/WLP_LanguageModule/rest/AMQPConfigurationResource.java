package pl.com.kantoch.WLP_LanguageModule.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.kantoch.WLP_LanguageModule.amqp.AMQPConfigurationLoader;
import pl.com.kantoch.WLP_LanguageModule.entities.payloads.response.AMQPConfiguration;

@RestController
@RequestMapping("/api/configuration/amqp")
@CrossOrigin("*")
public class AMQPConfigurationResource {
    private final AMQPConfigurationLoader configurationLoader;

    public AMQPConfigurationResource(AMQPConfigurationLoader configurationLoader) {
        this.configurationLoader = configurationLoader;
    }

    @GetMapping
    public AMQPConfiguration getConfiguration(){
        return configurationLoader.loadAMQPConfiguration();
    }
}
