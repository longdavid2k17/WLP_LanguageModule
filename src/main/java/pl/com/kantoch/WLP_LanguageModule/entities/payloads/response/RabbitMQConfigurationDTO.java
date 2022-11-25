package pl.com.kantoch.WLP_LanguageModule.entities.payloads.response;

public class RabbitMQConfigurationDTO {
    private String host;
    private Integer port;
    private String username;
    private String password;

    public RabbitMQConfigurationDTO() {
    }

    public RabbitMQConfigurationDTO(String host, Integer port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
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
}
