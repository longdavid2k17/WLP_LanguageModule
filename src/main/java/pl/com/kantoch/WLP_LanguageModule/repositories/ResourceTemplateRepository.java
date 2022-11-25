package pl.com.kantoch.WLP_LanguageModule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.kantoch.WLP_LanguageModule.entities.ResourceTemplate;

@Repository
public interface ResourceTemplateRepository extends JpaRepository<ResourceTemplate,Long> {
}
