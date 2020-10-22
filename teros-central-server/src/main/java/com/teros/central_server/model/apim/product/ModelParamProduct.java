package com.teros.central_server.model.apim.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamProduct {

    @ApiModelProperty(value = "productName", required = true)
    private String productName;

    @ApiModelProperty(value = "catalogId", required = true)
    private Long catalogId;

    @ApiModelProperty(value = "description", required = false)
    private String description;

}
