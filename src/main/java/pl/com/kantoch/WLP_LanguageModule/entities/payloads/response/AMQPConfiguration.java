package pl.com.kantoch.WLP_LanguageModule.entities.payloads.response;

public class AMQPConfiguration {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String amqpType;

    public AMQPConfiguration() {
    }

    public AMQPConfiguration(String host, Integer port, String username, String password,String amqpType) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.amqpType = amqpType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAmqpType() {
        return amqpType;
    }

    public void setAmqpType(String amqpType) {
        this.amqpType = amqpType;
    }
}
