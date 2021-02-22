package com.lm.lusty.util;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MethodParamConverter {

    public static Map<String,Object> change(Method method,Object[] args){
        Parameter[] parameters = method.getParameters();
        if(parameters==null||parameters.length==0){
            return null;
        }
        Map<String,Object> paramMap=new HashMap<>();
        int index=0;
        for(Parameter parameter:parameters){
            paramMap.put(parameter.getName(),args[index]);
        //    Type parameterizedType = parameter.getParameterizedType();
            index++;
        }
        return paramMap;
    }

}
