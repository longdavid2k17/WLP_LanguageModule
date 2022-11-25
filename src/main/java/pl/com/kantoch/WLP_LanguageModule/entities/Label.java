package pl.com.kantoch.WLP_LanguageModule.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "label")
public class Label implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "parent_element_name")
    private String parentElementName;

    @Column(name = "parent_element_type")
    private String parentElementType;

    @Column(name = "priority")
    private Long priority;

    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name="view_id", nullable=false,foreignKey = @ForeignKey(name = "fk_view_id"))
    private View view;

    public Label() {
    }

    public Label(Long id, String label, String parentElementName, String parentElementType, Long priority, String language, View view) {
        this.id = id;
        this.label = label;
        this.parentElementName = parentElementName;
        this.parentElementType = parentElementType;
        this.priority = priority;
        this.language = language;
        this.view = view;
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

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
