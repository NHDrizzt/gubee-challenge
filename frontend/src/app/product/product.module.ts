import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ProductComponent } from './product/product.component';
import {MatTableModule} from "@angular/material/table";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatCardModule} from "@angular/material/card";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatButtonToggleModule} from "@angular/material/button-toggle";


@NgModule({
  declarations: [
    ProductComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    MatTableModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    FormsModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatButtonToggleModule
  ]
})
export class ProductModule { }
