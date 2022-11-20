import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { routes } from './access.routes';
import {AccessValidateComponent} from "./access-validate.component";
import {AccessModifyComponent} from "./access-modify.component";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatSliderModule} from "@angular/material/slider";
import {AccessHomeComponent} from "./access-home.component";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    MatSliderModule,
    MatSlideToggleModule
  ],
  declarations: [ AccessValidateComponent, AccessModifyComponent, AccessHomeComponent ]
})
export class AccessModule {
  public static routes = routes;
}
