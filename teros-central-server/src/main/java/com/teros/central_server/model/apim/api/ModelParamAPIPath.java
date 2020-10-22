package com.teros.central_server.model.apim.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAPIPath {

    @ApiModelProperty(value = "apiId", required = true)
    private long apiId;

    @ApiModelProperty(value = "apiMethodId", required = true)
    private Long apiMethodId;

    @ApiModelProperty(value = "sourceUri", required = true)
    private String sourceUri;

    @ApiModelProperty(value = "targetUri", required = true)
    private String targetUri;

    @ApiModelProperty(value = "description", required = false)
    private String description;


}
