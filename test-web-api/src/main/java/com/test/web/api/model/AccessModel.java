package com.test.web.api.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AccessModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long accessId;
    private String email;
    private String featureName;
    private Boolean canAccess;

}

