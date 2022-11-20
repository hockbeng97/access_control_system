package com.test.web.api.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

// put to another class file
@Embeddable
public class AccessLinkKey implements Serializable {

    @Column(name="EMAIL")
    public String email;

    @Column(name="FEATURE_NAME")
    public String featureName;

    public AccessLinkKey() {

    }

    public AccessLinkKey(String email, String featureName){
        this.email = email;
        this.featureName = featureName;
    }
}
