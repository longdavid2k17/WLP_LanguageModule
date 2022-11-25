package pl.com.kantoch.WLP_LanguageModule.entities.resource;

import javax.persistence.*;

@Entity
@Table(name = "resource_types")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EResource resourceType;

    public Resource() {
    }

    public Resource(EResource resourceType) {
        this.resourceType = resourceType;
    }

    public Resource(Long id, EResource resourceType) {
        this.id = id;
        this.resourceType = resourceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EResource getResourceType() {
        return resourceType;
    }

    public void setResourceType(EResource resourceType) {
        this.resourceType = resourceType;
    }
}
