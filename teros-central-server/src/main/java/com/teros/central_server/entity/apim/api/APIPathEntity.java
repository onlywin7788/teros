package com.teros.central_server.entity.apim.api;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "apim_api_path")
@Getter
@Setter
@NoArgsConstructor
public class APIPathEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiPathId;

    @Column(name ="api_id")
    private Long apiId;

    @Column(name ="api_method_id")
    private Long apiMethodId;

    @Column(length = 64)
    private String sourceUri;

    @Column(length = 64)
    private String targetUri;

    @Column(length = 1048576)
    private String description;

    @Builder
    public APIPathEntity(long apiId, long apiMethodId, String sourceUri, String targetUri, String description) {
        this.apiId = apiId;
        this.apiMethodId = apiMethodId;
        this.sourceUri = sourceUri;
        this.targetUri = targetUri;
        this.description = description;
    }

    public void update(long apiId, long apiMethodId, String sourceUri, String targetUri, String description) {
        this.apiId = apiId;
        this.apiMethodId = apiMethodId;
        this.sourceUri = sourceUri;
        this.targetUri = targetUri;
        this.description = description;
    }
}