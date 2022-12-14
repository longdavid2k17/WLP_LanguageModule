package pl.com.kantoch.WLP_LanguageModule.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pl.com.kantoch.WLP_LanguageModule.configurations.ModuleRegistrationService;

import java.util.Map;

@RestController
@RequestMapping("/api/configuration")
@CrossOrigin("*")
public class ConfigurationResource {
    private final ModuleRegistrationService moduleRegistrationService;

    public ConfigurationResource(ModuleRegistrationService moduleRegistrationService) {
        this.moduleRegistrationService = moduleRegistrationService;
    }

    @GetMapping
    @ApiOperation(value = "Get current module configuration")
    public Map<String, String> getCurrentConfiguration(){
        return moduleRegistrationService.getCurrentConfiguration();
    }

    @PutMapping
    @ApiOperation(value = "Force module registration")
    public void forceRegistration(){
        moduleRegistrationService.registerService();
    }
}
