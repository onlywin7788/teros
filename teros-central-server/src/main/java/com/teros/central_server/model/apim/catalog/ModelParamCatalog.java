package com.teros.central_server.model.apim.catalog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamCatalog {

    @ApiModelProperty(value = "catalogName", required = true)
    private String catalogName;

    @ApiModelProperty(value = "description", required = false)
    private String description;

}
