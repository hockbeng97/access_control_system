package com.test.web.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAccessModel {
        private String email;
        private String featureName;
        private Boolean enable;
}
