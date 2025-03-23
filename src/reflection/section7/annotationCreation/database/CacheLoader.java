package reflection.section7.annotationCreation.database;

import reflection.section7.annotationCreation.annotation.InitializerClass;
import reflection.section7.annotationCreation.annotation.InitializerMethod;

@InitializerClass
public class CacheLoader {

    @InitializerMethod
    public void loadCache(){
        System.out.println("Loading data from cache");
    }

    public void reloadCache(){
        System.out.println("Reload cache");
    }

}
