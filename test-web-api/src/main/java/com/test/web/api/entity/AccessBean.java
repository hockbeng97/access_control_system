package com.test.web.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name="ACCESS")
public class AccessBean implements Serializable {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ACCESS_ID")
//    public Long accessId;


    @EmbeddedId
    private AccessLinkKey accessLinkKey;

    @Column(name="CAN_ACCESS")
    public Boolean canAccess;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof AccessBean)) return false;
        AccessBean that = (AccessBean)obj;
        return this.accessLinkKey.email.equals(that.accessLinkKey.email) && this.accessLinkKey.featureName.equals(that.accessLinkKey.featureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessLinkKey.email, accessLinkKey.featureName);
    }
}
