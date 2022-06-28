import { Component, OnInit } from '@angular/core';
import {FormGroup, NgForm} from "@angular/forms";
import {Market} from "./model/market";
import {TemplateFormService} from "./template-form.service";
import {catchError, Observable, of} from "rxjs";
import {Product} from "./model/product";
import {Stack} from "./model/stack";

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

const listOfAllStacks: Stack[] = [
  {id: 1, name: "Java 10", isSelected: false},
  {id: 2, name: "Kotlin", isSelected: false},
  {id: 3, name: "Kafka", isSelected: false},
  {id: 4, name: "Event Stream", isSelected: false},
  {id: 5, name: "Redis", isSelected: false},
  {id: 6, name: "Big Data Analytics", isSelected: false},
  {id: 7, name: "NodeJS", isSelected: false},
  {id: 8, name: "MongoDB", isSelected: false},
  {id: 9, name: "Hadoop", isSelected: false},
  {id: 10, name: "Cassandra", isSelected: false},
  {id: 11, name: "Pig", isSelected: false}
]

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
    stackSelected: Stack[]
  }
  _listOfAllMarkets: Market[] = listOfAllMarkets
  _listOfAllStacks: Stack[] = listOfAllStacks
  constructor(private templateService: TemplateFormService) {

    this.form = {
      marketSelected: [],
      stackSelected: []
    }
  }

  ngOnInit(): void {

  }

  onSubmit(form: NgForm) : void {
    // @ts-ignore
    this.form.marketSelected = this._listOfAllMarkets.filter(x=>x.isSelected).map(obj => ({"id":obj['id'], "name":obj['name']}))
    // @ts-ignore
    this.form.stackSelected = this._listOfAllStacks.filter(x=>x.isSelected).map(obj => ({"id":obj['id'], "name":obj['name']}))
    this.listProducts$ = this.templateService.postProducts(this.form.marketSelected, this.form.stackSelected)
    console.group( "Form Submission" );
    console.log( JSON.stringify( this.form, null, 4 ) );
    console.log( form );
    console.groupEnd();
  }

}
