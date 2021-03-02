package com.restauranttogo.menuservice.tool;

import com.restauranttogo.menuservice.exception.IllegalNullParamException;
import com.restauranttogo.menuservice.exception.ObjectNotFoundException;

public class Validate {

    static public  void notNull (Object object,String message){
     if (null== object)
         throw new IllegalNullParamException(message);
    }

    static public  void notFound (Object object,String message){
        if (null== object)
            throw new ObjectNotFoundException(message);
    }

    static public  void isTrue (final boolean expression  , String message){
        if (!expression)
            throw new IllegalNullParamException(message);
    }
}
