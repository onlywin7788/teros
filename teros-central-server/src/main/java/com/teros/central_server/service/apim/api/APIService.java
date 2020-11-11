package com.teros.central_server.service.apim.api;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.apim.api.APIEntity;
import com.teros.central_server.model.apim.api.ModelParamAPI;
import com.teros.central_server.repository.apim.api.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class APIService {

    @Autowired
    private APIRepository apiRepository;

    public APIEntity getAPI(Long apiId) {
        return apiRepository.findById(apiId).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<APIEntity> getAPIList() {
        return apiRepository.findAll();
    }

    @Transactional
    public APIEntity saveAPI(ModelParamAPI modelParamAPI) {
        APIEntity api = APIEntity.builder()
                .apiName(modelParamAPI.getApiName())
                .version(modelParamAPI.getVersion())
                .targetUrl(modelParamAPI.getTargetUrl())
                .description(modelParamAPI.getDescription())
                .build();

        Long lastID = apiRepository.save(api).getApiId();
        return getAPI(lastID);
    }

    @Transactional
    public Long updateAPI(long apiId, ModelParamAPI modelParamAPI) {

        APIEntity api = getAPI(apiId);
        api.update(modelParamAPI.getApiName(), modelParamAPI.getVersion()
                , modelParamAPI.getTargetUrl(), modelParamAPI.getDescription());
        return apiId;
    }

    @Transactional
    public boolean deleteAPI(long apiId) {
        APIEntity api = getAPI(apiId);
        if (api == null)
            return false;
        apiRepository.delete(api);
        return true;
    }

    public long getCount() {
        return apiRepository.count();
    }
}