package com.test.web.core.service.impl;

import com.test.web.api.entity.AccessBean;
import com.test.web.api.entity.AccessLinkKey;
import com.test.web.api.model.AddAccessModel;
import com.test.web.api.model.CheckAccessModel;
import com.test.web.api.service.AccessService;
import com.test.web.core.dao.AccessDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccessServiceImpl implements AccessService {

    private final AccessDao accessDao;

    public AccessServiceImpl(AccessDao accessDao) {
        this.accessDao = accessDao;
    }

    @Override
    public AccessBean getAccessByEmailAndFeatureName(String email, String featureName) {

        String lowerCaseEmail = email.toLowerCase();
        String loweCaseFeatureName = featureName.toLowerCase();

        AccessBean access = accessDao.getByEmailAndFeatureName(lowerCaseEmail, loweCaseFeatureName);
        return access;
    }

    @Override
    @Transactional
    public CheckAccessModel getCanAccessByEmailAndFeatureName(String email, String featureName) {

        String lowerCaseEmail = email.toLowerCase();
        String loweCaseFeatureName = featureName.toLowerCase();

        AccessBean userAccess = getAccessByEmailAndFeatureName(lowerCaseEmail, loweCaseFeatureName);
        CheckAccessModel checkAccessModel = new CheckAccessModel();
        checkAccessModel.setCanAccess(userAccess.getCanAccess());

        return checkAccessModel;
    }

    @Override
    @Transactional
    public void addAccess(AddAccessModel userAccessModel) {
        String lowerCaseEmail = userAccessModel.getEmail().toLowerCase();
        String loweCaseFeatureName = userAccessModel.getFeatureName().toLowerCase();
        Boolean canAccess = userAccessModel.getEnable();

        AccessBean accessBean = new AccessBean();
        accessBean.setCanAccess(canAccess);
        accessBean.setAccessLinkKey(new AccessLinkKey(lowerCaseEmail, loweCaseFeatureName));

        accessDao.addAccess(accessBean);
    }

    @Override
    @Transactional
    public void updateAccess(AddAccessModel userAccessModel) {

        String lowerCaseEmail = userAccessModel.getEmail().toLowerCase();
        String lowerCaseFeatureName = userAccessModel.getFeatureName().toLowerCase();
        Boolean canAccess = userAccessModel.getEnable();

        AccessBean userAccess = getAccessByEmailAndFeatureName(lowerCaseEmail, lowerCaseFeatureName);
        if(userAccess == null || canAccess == null) throw new NullPointerException();

        AccessBean accessBean = new AccessBean();
        accessBean.setCanAccess(canAccess);
        accessBean.setAccessLinkKey(new AccessLinkKey(lowerCaseEmail, lowerCaseFeatureName));
        accessDao.updateAccess(accessBean);
    }

    @Override
    @Transactional
    public void addOrUpdateAccess(AddAccessModel userAccessModel) {
        String email = userAccessModel.getEmail();
        String featureName = userAccessModel.getFeatureName();
        Boolean canAccess = userAccessModel.getEnable();

        AccessBean accessBean = new AccessBean();
        accessBean.setCanAccess(canAccess);
        accessBean.setAccessLinkKey(new AccessLinkKey(email.toLowerCase(), featureName.toLowerCase()));
        accessDao.save(accessBean);
    }
}
