import {Component, OnInit} from "@angular/core";
import {AccessValidateService} from "../service/access-validate.service";

@Component(
  {
    templateUrl: './access-validate.component.html'
  })


export class AccessValidateComponent implements OnInit
{

  form = {
    data: {
      food: <string> "",
      canAccess: <string> "",
      email: <string> "",
      featureName: <string> ""
    }
  }


  constructor(private foodHomeService : AccessValidateService) {
  }

  ngOnInit(){
    console.log('home init')
  }

  onClickCheckAccess() {
    let email = this.form.data.email
    let featureName = this.form.data.featureName

    this.foodHomeService.getCanAccessByEmailAndFeatureName(email, featureName).subscribe(res => {
      this.form.data.canAccess = res
    })
  }
}
