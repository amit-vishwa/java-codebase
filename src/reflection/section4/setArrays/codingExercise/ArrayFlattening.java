package reflection.section4.setArrays.codingExercise;

import java.util.*;
import java.lang.reflect.*;

public class ArrayFlattening {

    public <T> T concat(Class<?> type, Object... arguments) {

        if (arguments.length == 0) {
            return null;
        }

        /**
         * Complete code here
         */
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < arguments.length; i++){
            if(arguments[i].getClass().isArray()){
                for(int j = 0; j < Array.getLength(arguments[i]); j++){
                    list.add(Array.get(arguments[i], j));
                }
            }else{
                list.add(arguments[i]);
            }
        }
        Object flattenedArray = Array.newInstance(type, list.size());
        for(int i = 0; i < list.size(); i++){
            Array.set(flattenedArray, i, list.get(i));
        }
        return (T) flattenedArray;
    }

}
