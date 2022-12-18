package pl.com.kantoch.WLP_LanguageModule.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.com.kantoch.JsonLoader;
import pl.com.kantoch.WLP_LanguageModule.entities.payloads.response.RabbitMQConfigurationDTO;

import java.io.File;

import static pl.com.kantoch.WLP_LanguageModule.tools.NameDictionary.AMQP_SERVICE_TYPE;
import static pl.com.kantoch.WLP_LanguageModule.tools.NameDictionary.RABBIT_MQ_CONFIGURATION_FILE_PATH;

@Service
public class RabbitMQConfigurationLoader implements AMQPConfigurationLoader{

    @Override
    public RabbitMQConfigurationDTO loadAMQPConfiguration(){
        File configurationFile = new File(RABBIT_MQ_CONFIGURATION_FILE_PATH);
        RabbitMQConfigurationDTO dto = null;
        if(configurationFile.exists()){
            try {
                String loadedJson = new JsonLoader().loadFile(RABBIT_MQ_CONFIGURATION_FILE_PATH);
                ObjectMapper mapper = new ObjectMapper();
                dto = mapper.readValue(loadedJson, RabbitMQConfigurationDTO.class);
                dto.setAmqpType(AMQP_SERVICE_TYPE);
            } catch (Exception e) {
                throw new RuntimeException("Error during loading AMQP configuration from file. Path: "+RABBIT_MQ_CONFIGURATION_FILE_PATH+" . Message: "+e.getMessage());
            }
        }
        return dto;
    }
}
