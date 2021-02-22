package com.lm.lusty.protcl.common;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class HttpEndPoint {

    private String protcl;

    private String host;

    private String methodName;

    private Map<String,Object> param;


    public String getUrl(){
        StringBuilder sb=new StringBuilder();
        sb.append(this.protcl).append("//:").append(this.host).append("/").append(this.methodName);
        String param = buildParam();
        if(param!=null){
            sb.append(param);
        }
        return sb.toString();
    }

    private String buildParam(){
        if(this.param==null){
            return null;
        }
        StringBuilder sb=new StringBuilder("?");
        this.param.forEach((k,v)->{
            sb.append(k).append("=").append(v).append("&");
        });
        String res=sb.toString();
        return res.substring(0,res.length()-1);
    }

}
