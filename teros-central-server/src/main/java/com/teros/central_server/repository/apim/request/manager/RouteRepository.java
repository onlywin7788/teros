package com.teros.central_server.repository.apim.request.manager;

import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.entity.apim.request.manager.RouteUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    @Query(value =
            "SELECT\n" +
                    "CONCAT(API.API_NAME, '-', API.VERSION, '-', API_PATH.API_PATH_ID, '-', DATE_FORMAT(API.MODIFY_DTIME, '%Y%m%d%H%i%s%f')) AS ROUTE_ID\n" +
                    ",API_METHOD.METHOD_NAME AS METHOD\n" +
                    ",CONCAT('/', API.API_NAME, '/', API.VERSION, API_PATH.SOURCE_URI) AS SOURCE_URI\n" +
                    ",TARGET_URI\n" +
                    ",API.TARGET_URL\n" +
                    "FROM APIM_API API\n" +
                    ",APIM_API_PATH API_PATH\n" +
                    ",APIM_API_METHOD API_METHOD\n" +
                    "WHERE API.API_ID=API_PATH.API_ID\n" +
                    "AND API_PATH.API_METHOD_ID=API_METHOD.API_METHOD_ID"
            ,nativeQuery = true)
    List<RouteEntity> getRouteEntity();

    @Query(value =
            "SELECT CONCAT('API_ROUTE', '-', COUNT(*), '-', SUM(DATE_FORMAT(API_PATH.MODIFY_DTIME, '%Y%m%d%H%i%s'))) AS ROUTE_UID\n" +
                    "FROM APIM_API_PATH API_PATH"
            ,nativeQuery = true)
    List<RouteUIDEntity> getRouteUIDEntity();
}
