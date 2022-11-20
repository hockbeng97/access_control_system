import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./access/access.module').then(x => x.AccessModule)
  },
  {
    path: 'validate',
    loadChildren: () => import('./access/access.module').then(x => x.AccessModule)
  },
  {
    path: 'modify',
    loadChildren: () => import('./access/access.module').then(x => x.AccessModule)
  }

];

export class AppRoutes { }
