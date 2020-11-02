package com.teros.central_server.repository.apim.request.manager;

import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.entity.apim.request.manager.RouteUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteUIDRepository extends JpaRepository<RouteUIDEntity, Long> {

    @Query(value =
            "SELECT CONCAT('API_ROUTE', '-', COUNT(*), '-', SUM(DATE_FORMAT(API_PATH.MODIFY_DTIME, '%Y%m%d%H%i%s'))) AS ROUTE_UID\n" +
                    "FROM APIM_API_PATH API_PATH"
            ,nativeQuery = true)
    RouteUIDEntity getRouteUIDEntity();
}
