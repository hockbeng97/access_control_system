package com.test.web.core.dao;


import com.test.web.api.entity.AccessBean;
import com.test.web.api.entity.AccessLinkKey;
import com.test.web.core.dao.custom.AccessDaoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessDao extends JpaRepository<AccessBean, AccessLinkKey>, AccessDaoCustom {

}
