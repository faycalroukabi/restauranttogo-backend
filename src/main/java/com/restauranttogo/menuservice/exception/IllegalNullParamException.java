package com.restauranttogo.menuservice.exception;

public class IllegalNullParamException extends RuntimeException {

    public IllegalNullParamException (String msg){
        super(msg);
    }

    public IllegalNullParamException (String msg , Throwable cause){
        super(msg, cause);
    }
}
