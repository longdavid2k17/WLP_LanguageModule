package pl.com.kantoch.WLP_LanguageModule.rest;

import org.springframework.web.bind.annotation.*;
import pl.com.kantoch.WLP_LanguageModule.entities.View;
import pl.com.kantoch.WLP_LanguageModule.services.ViewService;
import java.util.Collection;

@RestController
@RequestMapping("/api/view")
@CrossOrigin("*")
public class ViewResource {

    private final ViewService viewService;

    public ViewResource(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping
    public Collection<View> getAll() {
        return viewService.getAll();
    }

    @GetMapping("/{applicationName}")
    public Collection<View> getAllForApplication(String applicationName) {
        return viewService.getAllForApplication(applicationName);
    }

    @PostMapping
    public View save(View view){
        return viewService.save(view);
    }
}
