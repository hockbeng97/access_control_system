package com.test.web.core.dao.custom;


import com.test.web.api.entity.AccessBean;
import com.test.web.api.model.AccessModel;

import java.util.Optional;

public interface AccessDaoCustom {

    AccessBean getByEmailAndFeatureName(String email, String featureName);
    void addAccess(AccessBean userAccessModel);
    void updateAccess(AccessBean userAccessModel);
}
