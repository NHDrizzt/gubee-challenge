import { Component, OnInit } from '@angular/core';
import {ProductDashboardService} from "./product.dashboard.service";
import {Product} from "./product.interface";
import {Market} from "./market.interface";
import {Stack} from "./stack.interface";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {

  product: Product | undefined;
  products: Product[] | undefined;

  _market: Market | undefined;
  _marketList: Market[]=[
    {id:1, name:"Ecommerce", isSelected:false},
    {id:2, name:"ERP", isSelected:false},
    {id:3, name:"Loja Fisica", isSelected:false},
    {id:4, name:"Telecom", isSelected:false},
    {id:5, name:"Venda Direta", isSelected:false},
    {id:6, name:"Mobile First", isSelected:false},
    {id:7, name:"Digital Onboarding", isSelected:false},
    {id:8, name:"Lojista que nao desejam possuir ecommerce", isSelected:false},
  ];

  _stack: Stack | undefined;
  _stackList: Stack[]=[
    {id:1, name:"Java 10", isSelected:false},
    {id:2, name:"Kotlin", isSelected:false},
    {id:3, name:"Kafka", isSelected:false},
    {id:4, name:"Event Stream", isSelected:false},
    {id:5, name:"Redis", isSelected:false},
    {id:6, name:"Big Data Analytics", isSelected:false},
    {id:7, name:"NodeJS", isSelected:false},
    {id:8, name:"MongoDB", isSelected:false},
    {id:9, name:"Hadoop", isSelected:false},
    {id:10, name:"Cassandra", isSelected:false},
    {id:11, name:"Pig", isSelected:false}
  ];

  checkedIDs: number[]=[];
  selectedItemsListMarket: Market[]=[];
  selectedItemsListStack: Stack[]=[];

  _productHolderStack: Stack | undefined;
  _productHolderStacks: Stack[] | undefined;

  uniqueKey: number=0;


  ngOnInit() {
    this.fetchSelectedItems()
    this.fetchCheckedIDs()
  }

  onchange(){
    this.fetchSelectedItems()
  }

  fetchSelectedItems() {
    this.selectedItemsListMarket = this._marketList.filter((value, index) => {
      return value.isSelected;
    });
    this.selectedItemsListStack = this._stackList.filter((value, index) => {
      return value.isSelected;
    })
  }
  fetchCheckedIDs() {
    this.checkedIDs = []
    this._marketList.forEach((value, index) => {
      if (value.isSelected) {
        this.checkedIDs.push(value.id);
      }
    });

    this.checkedIDs = []
    this._stackList.forEach((value, index) => {
      if (value.isSelected) {
        this.checkedIDs.push(value.id);
      }
    });
  }

  onsubmit(){

  }

}

