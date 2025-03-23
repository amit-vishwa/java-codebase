package reflection.section7.annotationCreation.config;

import reflection.section7.annotationCreation.annotation.InitializerClass;
import reflection.section7.annotationCreation.annotation.InitializerMethod;

@InitializerClass
public class ConfigLoader {

    @InitializerMethod
    public void loadAllConfigs(){
        System.out.println("Loading all configuration files");
    }

}
