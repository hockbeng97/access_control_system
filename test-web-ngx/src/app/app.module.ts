import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {routes} from "./app.routes"
import {AccessValidateService} from "./service/access-validate.service";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    RouterModule.forRoot(routes, { useHash: false, enableTracing :true }),
    BrowserModule,
    HttpClientModule,
  ],
  providers: [AccessValidateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
