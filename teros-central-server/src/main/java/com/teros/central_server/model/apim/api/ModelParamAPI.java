package com.teros.central_server.model.apim.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAPI {

    @ApiModelProperty(value = "apiName", required = true)
    private String apiName;

    @ApiModelProperty(value = "version", required = true)
    private String version;

    @ApiModelProperty(value = "targetUrl", required = true)
    private String targetUrl;

    @ApiModelProperty(value = "description", required = false)
    private String description;
}
