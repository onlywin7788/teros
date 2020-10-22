package com.teros.central_server.model.apim.plan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamPlan {

    @ApiModelProperty(value = "planName", required = true)
    private String planName;

    @ApiModelProperty(value = "productId", required = true)
    private Long productId;

    @ApiModelProperty(value = "description", required = false)
    private String description;

}
