import {Component, OnInit} from '@angular/core';
import {Market} from "../model/market";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Stack} from "../model/stack";
import {Product} from "../model/product";
import {ProductService} from "../services/product.service";
import {catchError, Observable, of} from "rxjs";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  formulario: FormGroup | undefined;
  listMarkets: Market[] = [
    {id: 1, name: "Ecommerce", isSelected: false},
    {id: 2, name: "ERP", isSelected: false},
    {id: 3, name: "Loja Fisica", isSelected: false},
    {id: 4, name: "Telecom", isSelected: false},
    {id: 5, name: "Venda Direta", isSelected: false},
    {id: 6, name: "Mobile First", isSelected: false},
    {id: 7, name: "Digital Onboarding", isSelected: false},
    {id: 8, name: "Lojista que nao desejam possuir ecommerce", isSelected: false},
  ];
  listStacks: Stack[] = [
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
  displayedColumns = ["id", "name"];
  displayProducts = ["id", "name", "description"]

  listProducts$: Observable<Product[]>


  constructor(productService: ProductService) {
    this.listProducts$ = productService.list()
      .pipe(
        catchError(e => {
          console.log(e)
          return of([])
        })
      )
  }

  ngOnInit(): void {
    console.log(this.listProducts$)
  }
}
