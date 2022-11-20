import {Component, OnInit} from "@angular/core";
import {AccessValidateService} from "../service/access-validate.service";
import {AddAccessModel} from "../model/add-access.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component(
  {
    templateUrl: './access-modify.component.html',
    styleUrls: ['./access.component.scss']
  })


export class AccessModifyComponent implements OnInit
{

  form = {
    data: {
      email: <string> "",
      featureName: <string> "",
      enable: <boolean> false,
    },
    ui: {
      status: <string> "",
      accessModel: <AddAccessModel><unknown>null,
      page: <string | null> "",
      operation: <string> ""
    }
  }


  constructor(private accessValidateService : AccessValidateService, private router : Router, private route : ActivatedRoute) {


  }

  ngOnInit(){
    this.route.paramMap.subscribe( params =>
      this.form.ui.page =  params.get('operation')
    )
    if (this.form.ui.page == 'add') this.form.ui.operation = 'Add'
    else if(this.form.ui.page == 'update') this.form.ui.operation = 'Update'
  }

  onClickBack() {
    this.router.navigate([''])
  }

  onClickAddAccess() {
    if(this.form.ui.page == 'add') {
     this.accessValidateService.addAccess(this.form.data).subscribe(res => {
        this.form.ui.status = res
       this.completeAddOrUpdateAccess(this.form.ui.status)
      })
    } else if (this.form.ui.page == 'update') {
      this.accessValidateService.updateAccess(this.form.data).subscribe(res => {
        this.form.ui.status = res
        this.completeAddOrUpdateAccess(this.form.ui.status)
      })
    }
  }

  completeAddOrUpdateAccess(status: string) {
    alert(this.form.ui.status)
  }

}
