package reflection.section7.annotationCreation.http;

import reflection.section7.annotationCreation.annotation.InitializerClass;
import reflection.section7.annotationCreation.annotation.InitializerMethod;

@InitializerClass
public class ServiceRegistry {

    @InitializerMethod
    public void registerService(){
        System.out.println("Service successfully registered!");
    }

}
