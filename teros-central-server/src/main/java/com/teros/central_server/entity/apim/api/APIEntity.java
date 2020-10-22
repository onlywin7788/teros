package com.teros.central_server.entity.apim.api;

import com.teros.central_server.entity.apim.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "apim_api")
@Getter
@Setter
@NoArgsConstructor
public class APIEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiId;

    @Column(length = 64)
    private String apiName;

    @Column(length = 32)
    private String version;

    @Column(length = 2048)
    private String targetUrl;

    @Column(length = 1048576)
    private String description;

    @Builder
    public APIEntity(String apiName, String version, String targetUrl, String description) {

        this.apiName = apiName;
        this.version = version;
        this.targetUrl = targetUrl;
        this.description = description;
    }

    public void update(String apiName, String version, String targetUrl, String description) {

        this.apiName = apiName;
        this.version = version;
        this.targetUrl = targetUrl;
        this.description = description;
    }

}