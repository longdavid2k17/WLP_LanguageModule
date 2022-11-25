package pl.com.kantoch.WLP_LanguageModule.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.kantoch.WLP_LanguageModule.entities.Label;
import pl.com.kantoch.WLP_LanguageModule.services.LabelService;

import java.util.Collection;

@RestController
@RequestMapping("/api/label")
public class LabelResource {

    private final LabelService labelService;

    public LabelResource(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping
    public Collection<Label> getAll() {
        return labelService.getAll();
    }

    @GetMapping("/{viewId}")
    public Collection<Label> getForView(Long viewId) {
        return labelService.getForView(viewId);
    }

    @PostMapping
    public Label save(Label label){
        return labelService.save(label);
    }
}