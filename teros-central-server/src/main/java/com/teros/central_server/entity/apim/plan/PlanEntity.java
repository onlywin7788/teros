package com.teros.central_server.entity.apim.plan;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "apim_plan")
@Getter
@Setter
@NoArgsConstructor
public class PlanEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(name ="product_id")
    private Long productId;

    @Column(length = 64)
    private String planName;

    @Column(length = 1048576)
    private String description;

    @Builder
    public PlanEntity(String planName, Long productId, String description) {
        this.planName = planName;
        this.productId = productId;
        this.description = description;
    }

    public void update(String planName, Long productId, String description) {
        this.planName = planName;
        this.productId = productId;
        this.description = description;
    }

}