package pl.com.kantoch.WLP_LanguageModule.entities;

import org.hibernate.annotations.CreationTimestamp;
import pl.com.kantoch.WLP_LanguageModule.entities.resource.Resource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource_templates")
public class ResourceTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language")
    private String language;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "absolute_file_path")
    private String absoluteFilePath;

    @CreationTimestamp
    @Column(name = "upload_date")
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name="resource_id", nullable=false,foreignKey = @ForeignKey(name = "fk_resource_id"))
    private Resource resource;

    public ResourceTemplate() {
    }

    public ResourceTemplate(Long id, String language, String filePath, String absoluteFilePath, Date uploadDate, Resource resource) {
        this.id = id;
        this.language = language;
        this.filePath = filePath;
        this.absoluteFilePath = absoluteFilePath;
        this.uploadDate = uploadDate;
        this.resource = resource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAbsoluteFilePath() {
        return absoluteFilePath;
    }

    public void setAbsoluteFilePath(String absoluteFilePath) {
        this.absoluteFilePath = absoluteFilePath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
