package reflection.section7.annotationCreation;

import reflection.section7.annotationCreation.annotation.InitializerClass;
import reflection.section7.annotationCreation.annotation.InitializerMethod;

@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void startAutoSavingThreads(){
        System.out.println("Start automatic data saving to disk");
    }

}
