package com.teros.central_server.repository.api;

import com.teros.central_server.entity.api.APIPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface APIPathRepository extends JpaRepository<APIPathEntity, Long> {
    @Query(value = "SELECT * FROM API_PATH WHERE API_ID=?1", nativeQuery = true)
    List<APIPathEntity> getAPIPathListByApiId(Long apiId);

    @Query(value = "DELETE FROM API_PATH WHERE API_ID=?1", nativeQuery = true)
    void deleteAPIPathListByApiId(long apiId);
}
