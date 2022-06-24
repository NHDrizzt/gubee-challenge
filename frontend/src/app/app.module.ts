import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {HttpClientModule} from "@angular/common/http";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { TemplateFormComponent } from './template-form/template-form.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {TemplateFormModule} from "./template-form/template-form.module";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatTableModule} from "@angular/material/table";

@NgModule({
  declarations: [
    AppComponent,
    TemplateFormComponent,
    HeaderComponent,
    FooterComponent,
    ReactiveFormComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatToolbarModule,
        HttpClientModule,
        MatProgressSpinnerModule,
        ReactiveFormsModule,
        MatSidenavModule,
        MatListModule,
        TooltipModule,
        MatCheckboxModule,
        FormsModule,
        TemplateFormModule,
        MatFormFieldModule,
        MatTableModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
