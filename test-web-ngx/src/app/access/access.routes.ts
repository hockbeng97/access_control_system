import { Routes } from '@angular/router';

import { AccessValidateComponent } from './access-validate.component';
import {AccessModifyComponent} from "./access-modify.component";
import {AccessHomeComponent} from "./access-home.component";

export const routes:Routes = [
  {
    path: '',
    component: AccessHomeComponent,
    children: [
      { path: '', component: AccessHomeComponent },
    ]
  },
  {
    path: 'access-validate',
    component: AccessValidateComponent,
    children: [
      { path: '', component: AccessValidateComponent },
    ]
  },
  {
    path: 'access-modify/:operation',
    component: AccessModifyComponent,
    children: [
      { path: '', component: AccessModifyComponent },
    ]
  },
];
