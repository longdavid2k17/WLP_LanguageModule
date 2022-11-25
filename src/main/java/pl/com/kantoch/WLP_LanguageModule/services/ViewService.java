package pl.com.kantoch.WLP_LanguageModule.services;

import org.springframework.stereotype.Service;
import pl.com.kantoch.WLP_LanguageModule.entities.View;
import pl.com.kantoch.WLP_LanguageModule.repositories.ViewRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ViewService {
    private final ViewRepository viewRepository;

    public ViewService(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    public Collection<View> getAll() {
        return viewRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(View::getName))
                .collect(Collectors.toUnmodifiableList());
    }

    public Collection<View> getAllForApplication(String applicationName) {
        return getAll()
                .stream()
                .filter(e->e.getApplicationName().equals(applicationName))
                .sorted(Comparator.comparing(View::getName))
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public View save(View view){
        return viewRepository.save(view);
    }
}
