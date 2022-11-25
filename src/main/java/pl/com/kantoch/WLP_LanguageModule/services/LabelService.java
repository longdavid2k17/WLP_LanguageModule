package pl.com.kantoch.WLP_LanguageModule.services;

import org.springframework.stereotype.Service;
import pl.com.kantoch.WLP_LanguageModule.entities.Label;
import pl.com.kantoch.WLP_LanguageModule.repositories.LabelRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Collection<Label> getAll() {
        Collection<Label> labelCollection = labelRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Label::getPriority))
                .collect(Collectors.toUnmodifiableList());
        return labelCollection;
    }

    public Collection<Label> getForView(Long viewId) {
        return getAll()
                .stream()
                .filter(e->e.getView().getId().equals(viewId))
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public Label save(Label label){
        return labelRepository.save(label);
    }
}
