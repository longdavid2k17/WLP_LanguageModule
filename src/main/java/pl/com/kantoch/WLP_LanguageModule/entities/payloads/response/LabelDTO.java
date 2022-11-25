package pl.com.kantoch.WLP_LanguageModule.entities.payloads.response;

import pl.com.kantoch.WLP_LanguageModule.entities.Label;

public class LabelDTO {
    private Long id;
    private String label;
    private String parentElementName;
    private String parentElementType;
    private Long priority;
    private String language;

    public LabelDTO(Label label) {
        this.id = label.getId();
        this.label = label.getLabel();
        this.parentElementName = label.getParentElementName();
        this.parentElementType = label.getParentElementType();
        this.priority = label.getPriority();
        this.language = label.getLanguage();
    }

    public LabelDTO(Long id, String label, String parentElementName, String parentElementType, Long priority, String language) {
        this.id = id;
        this.label = label;
        this.parentElementName = parentElementName;
        this.parentElementType = parentElementType;
        this.priority = priority;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParentElementName() {
        return parentElementName;
    }

    public void setParentElementName(String parentElementName) {
        this.parentElementName = parentElementName;
    }

    public String getParentElementType() {
        return parentElementType;
    }

    public void setParentElementType(String parentElementType) {
        this.parentElementType = parentElementType;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
