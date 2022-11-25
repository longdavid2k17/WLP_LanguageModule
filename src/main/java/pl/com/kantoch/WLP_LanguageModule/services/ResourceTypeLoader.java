package pl.com.kantoch.WLP_LanguageModule.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Service;
import pl.com.kantoch.WLP_LanguageModule.entities.resource.EResource;
import pl.com.kantoch.WLP_LanguageModule.entities.resource.Resource;
import pl.com.kantoch.files.FileOperationService;
import pl.com.kantoch.files.FileOperationServiceImplementation;
;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static pl.com.kantoch.WLP_LanguageModule.tools.NameDictionary.RESOURCE_TYPES_CONFIGURATION_FILE_PATH;


@Service
public class ResourceTypeLoader {
    private final Logger LOGGER = LoggerFactory.getLogger(ResourceTypeLoader.class);

    private final FileOperationService fileOperationService;
    private Collection<Resource> resourceList;
    private final ResourceService resourceService;

    public ResourceTypeLoader(ResourceService resourceService) {
        this.fileOperationService = new FileOperationServiceImplementation();
        this.resourceService = resourceService;
    }

    @EventListener(ApplicationStartup.class)
    public void loadDefaultResourceTypes() throws IOException {
        LOGGER.warn("Started resource type loader");
        File typesFile = new File(RESOURCE_TYPES_CONFIGURATION_FILE_PATH);
        if(!typesFile.exists()){
            LOGGER.error("Cannot load resource type, there is not such file in configuration directory");
            boolean creationResult = typesFile.createNewFile();
            if(creationResult){
                writeDefaultValues(typesFile);
            } else LOGGER.error("Could not create default resource type configuration");
        } else checkFileContent(typesFile);
    }

    @Transactional
    private void checkFileContent(File typesFile) throws IOException {
        resourceList = resourceService.getAll();
        if(resourceList.size()==0)
            provideDefaultValues();
        CSVParser csvContent = fileOperationService.readCSVFile(typesFile, CSVFormat.DEFAULT);
        for (Iterator<CSVRecord> it = csvContent.stream().iterator(); it.hasNext(); ) {
            CSVRecord record = it.next();
            if(resourceList.stream()
                    .noneMatch(e->e.getResourceType().name().equals(record.get(0)))){
                LOGGER.warn("Adding type '{}'",record.get(0));
                ///check if enum has correct value for new template name,
                //if not then enum EResource must be updated
                resourceService.save(new Resource(EResource.valueOf(record.get(0))));
            }
        }
    }

    private void writeDefaultValues(File typesFile) throws IOException {
        resourceList = resourceService.getAll();
        if(resourceList.size()==0)
            provideDefaultValues();
        List<List<String>> values = new ArrayList<>();
        for(Resource resource: resourceList){
            values.add(List.of(resource.getResourceType().name()));
        }
        fileOperationService.writeCSVFile(typesFile,values);
    }

    @Transactional
    private void provideDefaultValues() {
        for(EResource resource : EResource.values()){
            resourceService.save(new Resource(resource));
        }
        resourceList = resourceService.getAll();
    }
}
