package com.test.web.core.mvc;

import com.test.web.api.model.AddAccessModel;
import com.test.web.api.model.CheckAccessModel;
import com.test.web.api.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/rest/feature/")
public class AccessController {

    private final AccessService accessService;

    @Autowired
    AccessController(AccessService accessService) {
        this.accessService = accessService;
    }


    @GetMapping(value= "get-can-access-by-email-and-feature-name")
    public CheckAccessModel getCanAccessByEmailAndFeature(String email, String featureName){
        try {
            CheckAccessModel canAccess = accessService.getCanAccessByEmailAndFeatureName(email, featureName);
            return canAccess;
        } catch (Exception ex) {
            return null;
        }
    }

    @PostMapping( "add-access")
    public HttpStatus addAccess(@RequestBody AddAccessModel userAccessModel){
        try {
            accessService.addAccess(userAccessModel);
            return HttpStatus.OK;
        } catch (Exception ex) {
            return HttpStatus.NOT_MODIFIED;
        }
    }

    @PostMapping( "update-access")
    public HttpStatus updateAccess(@RequestBody AddAccessModel userAccessModel){
        try {
            accessService.updateAccess(userAccessModel);
            return HttpStatus.OK;
        } catch (Exception ex) {
            return HttpStatus.NOT_MODIFIED;
        }
    }

    @PostMapping( "add-or-update-access")
    public HttpStatus addOrUpdateAccess(@RequestBody AddAccessModel userAccessModel){
        try {
            accessService.addOrUpdateAccess(userAccessModel);
            return HttpStatus.OK;
        } catch (Exception ex) {
            return HttpStatus.NOT_MODIFIED;
        }
    }

}
