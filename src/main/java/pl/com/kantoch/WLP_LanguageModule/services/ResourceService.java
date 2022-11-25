package pl.com.kantoch.WLP_LanguageModule.services;

import org.springframework.stereotype.Service;
import pl.com.kantoch.WLP_LanguageModule.entities.resource.Resource;
import pl.com.kantoch.WLP_LanguageModule.repositories.ResourceRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Collection<Resource> getAll() {
        return resourceRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Resource::getResourceType))
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public Resource save(Resource resource){
        return resourceRepository.save(resource);
    }
}
