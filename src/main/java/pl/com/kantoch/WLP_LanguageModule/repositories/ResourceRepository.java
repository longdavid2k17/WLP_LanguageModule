package pl.com.kantoch.WLP_LanguageModule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.kantoch.WLP_LanguageModule.entities.resource.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
