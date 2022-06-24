import { Component, OnInit } from '@angular/core';
import {FormGroup, NgForm} from "@angular/forms";
import {Market} from "./model/market";
import {TemplateFormService} from "./template-form.service";
import {catchError, Observable, of} from "rxjs";
import {Product} from "./model/product";

const listOfAllMarkets: Market[] = [
  {id: 1, name: "Ecommerce", isSelected: false},
  {id: 2, name: "ERP", isSelected: false},
  {id: 3, name: "Loja Fisica", isSelected: false},
  {id: 4, name: "Telecom", isSelected: false},
  {id: 5, name: "Venda Direta", isSelected: false},
  {id: 6, name: "Mobile First", isSelected: false},
  {id: 7, name: "Digital Onboarding", isSelected: false},
  {id: 8, name: "Lojista que nao desejam possuir ecommerce", isSelected: false},
];

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.scss']
})
export class TemplateFormComponent implements OnInit {
  listProducts$: Observable<Product[]> | undefined

  listProduct: Product[] = []
  displayProducts = ["id", "name", "description"]
  public form: {
    marketSelected: Market[],
  }
  _listOfAllMarket: Market[] = listOfAllMarkets

  constructor(private templateService: TemplateFormService) {
    // @ts-ignore
   /* this.listProducts$ = templateService.listProducts().pipe(
      catchError( err => {return of({})})
    )*/

    this.form = {
      marketSelected: []
    }
  }

  ngOnInit(): void {

  }

  onSubmit(form: NgForm) : void {
    // @ts-ignore
    this.form.marketSelected = this._listOfAllMarket.filter(x=>x.isSelected).map(obj => ({"id":obj['id'], "name":obj['name']}))
    this.listProducts$ = this.templateService.postProducts(this.form.marketSelected)
    console.group( "Form Submission" );
    console.log( JSON.stringify( this.form, null, 4 ) );
    console.log( form );
    console.groupEnd();
  }

}
