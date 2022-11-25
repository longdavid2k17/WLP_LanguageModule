package pl.com.kantoch.WLP_LanguageModule.entities.payloads.request;

public class ViewTranslationRequest {
    String viewName;
    String applicationName;
    String language;

    public ViewTranslationRequest(String viewName, String applicationName, String language) {
        this.viewName = viewName;
        this.applicationName = applicationName;
        this.language = language;
    }

    public ViewTranslationRequest() {
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
