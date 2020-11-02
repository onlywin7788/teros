package com.teros.central_server.entity.apim.request.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RouteUIDEntity implements Serializable {

    @Id
    @Column(name ="route_uid")
    private String routeUid;

}