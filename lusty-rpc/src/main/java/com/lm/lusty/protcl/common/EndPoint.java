package com.lm.lusty.protcl.common;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class EndPoint {

    private String protcl;

    private String host;

    private Map<String,String> param;


}
