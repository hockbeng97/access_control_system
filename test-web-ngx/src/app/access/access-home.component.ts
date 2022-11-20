import {Component, OnInit} from "@angular/core";
import {AccessValidateService} from "../service/access-validate.service";
import {AddAccessModel} from "../model/add-access.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component(
  {
    templateUrl: './access-home.component.html',
    styleUrls: ['./access.component.scss']
  })


export class AccessHomeComponent implements OnInit
{

  form = {
    data: {
      email: <string> "",
      featureName: <string> "",
      enable: <boolean> false,
    },
    ui: {
      status: <string> "",
      accessModel: <AddAccessModel><unknown>null
    }
  }


  constructor(private accessValidateService : AccessValidateService, private router : Router) {

  }

  ngOnInit(){
    console.log('home init')
  }

  onClickAddAccess() {
    this.accessValidateService.addAccess(this.form.data).subscribe(res => {
      this.form.ui.status = res
      alert(this.form.ui.status)
    })
  }
}
