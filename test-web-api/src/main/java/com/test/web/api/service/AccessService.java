package com.test.web.api.service;

import com.test.web.api.entity.AccessBean;
import com.test.web.api.model.AddAccessModel;
import com.test.web.api.model.CheckAccessModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface AccessService {

    AccessBean getAccessByEmailAndFeatureName(String email, String featureName);
    CheckAccessModel getCanAccessByEmailAndFeatureName(String email, String featureName);
    void addAccess(AddAccessModel userAccess);
    void updateAccess(AddAccessModel userAccess);
    void addOrUpdateAccess(AddAccessModel testBean);
}
