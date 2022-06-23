import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TemplateFormComponent} from "./template-form/template-form.component";
import {ReactiveFormsModule} from "@angular/forms";
import {ReactiveFormComponent} from "./reactive-form/reactive-form.component";

const routes: Routes = [
  { path:'templateForm', component: TemplateFormComponent},
  { path:'reactiveForm', component: ReactiveFormComponent},
  { path:'', pathMatch: 'full', redirectTo: 'templateForm'}

  /*  {
    path: 'listProducts',
    loadChildren: () => import('./product/product.module').then(m=>m.ProductModule)
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
