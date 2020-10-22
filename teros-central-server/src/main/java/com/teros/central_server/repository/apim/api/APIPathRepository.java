package com.teros.central_server.repository.apim.api;

import com.teros.central_server.entity.apim.api.APIPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface APIPathRepository extends JpaRepository<APIPathEntity, Long> {
    @Query(value = "SELECT * FROM APIM_API_PATH WHERE API_ID=?1", nativeQuery = true)
    List<APIPathEntity> getAPIPathListByApiId(Long apiId);

    @Query(value = "DELETE FROM APIM_API_PATH WHERE API_ID=?1", nativeQuery = true)
    void deleteAPIPathListByApiId(long apiId);
}
