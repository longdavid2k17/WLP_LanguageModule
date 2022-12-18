package pl.com.kantoch.WLP_LanguageModule.amqp;

import pl.com.kantoch.WLP_LanguageModule.entities.payloads.response.AMQPConfiguration;

public interface AMQPConfigurationLoader {
    AMQPConfiguration loadAMQPConfiguration();
}
