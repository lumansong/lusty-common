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

    private Map<String,String> param;


}
