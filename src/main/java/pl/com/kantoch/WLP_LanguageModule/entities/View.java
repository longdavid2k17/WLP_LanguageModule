package pl.com.kantoch.WLP_LanguageModule.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class View implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "application_name")
    private String applicationName;

    @JsonIgnore
    @OneToMany(mappedBy="view",fetch = FetchType.EAGER)
    private Set<Label> labelSet;


    public View() {
    }

    public View(Long id, String name, String applicationName, Set<Label> labelSet) {
        this.id = id;
        this.name = name;
        this.applicationName = applicationName;
        this.labelSet = labelSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Set<Label> getLabelSet() {
        return labelSet;
    }

    public void setLabelSet(Set<Label> labelSet) {
        this.labelSet = labelSet;
    }
}
