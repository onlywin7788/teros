package com.teros.central_server.entity.apim.request.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RouteEntity implements Serializable {

    @Id
    @Column(name ="route_id")
    private String routeId;

    @Column(name ="method")
    private String method;

    @Column(name ="source_uri")
    private String sourceUri;

    @Column(name ="target_uri")
    private String targetUri;

    @Column(name ="target_url")
    private String targetUrl;
}