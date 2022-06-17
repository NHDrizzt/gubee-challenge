import {Component, OnInit} from '@angular/core';
import {Market} from "../model/market";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Stack} from "../model/stack";
import {Product} from "../model/product";
import {ProductService} from "../services/product.service";
import {catchError, Observable, of} from "rxjs";
import { SelectionModel } from '@angular/cdk/collections';
import {MatTableDataSource} from "@angular/material/table";
import {MatCheckboxChange} from "@angular/material/checkbox";

const listMarket: Market[] = [
  {id: 1, name: "Ecommerce", isSelected: false},
  {id: 2, name: "ERP", isSelected: false},
  {id: 3, name: "Loja Fisica", isSelected: false},
  {id: 4, name: "Telecom", isSelected: false},
  {id: 5, name: "Venda Direta", isSelected: false},
  {id: 6, name: "Mobile First", isSelected: false},
  {id: 7, name: "Digital Onboarding", isSelected: false},
  {id: 8, name: "Lojista que nao desejam possuir ecommerce", isSelected: false},
];

const listStack: Stack[] = [
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
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  dataSourceMarket = new MatTableDataSource<Market>(listMarket);
  dataSourceStack = new MatTableDataSource<Stack>(listStack);
  frameworks = [
    {id: 1, name: "Ecommerce", isSelected: false},
    {id: 2, name: "ERP", isSelected: false},
    {id: 3, name: "Loja Fisica", isSelected: false},
    {id: 4, name: "Telecom", isSelected: false},
    {id: 5, name: "Venda Direta", isSelected: false},
    {id: 6, name: "Mobile First", isSelected: false},
    {id: 7, name: "Digital Onboarding", isSelected: false},
    {id: 8, name: "Lojista que nao desejam possuir ecommerce", isSelected: false},
  ];

  form: FormGroup;
  selection = new SelectionModel<Market>(true, []);


  displayedColumns = ["id", "name"];
  displayProducts = ["id", "name", "description"]

  listProducts$: Observable<Product[]>
  displayedSubmit = ["submit"];
  row: any;
  parentSelector: boolean = false;

  constructor(private fb: FormBuilder, private productService: ProductService) {
    this.form = this.fb.group({
      checkArray: this.fb.array([]),
      frameworks: this.buildFrameworks()
    })

    this.listProducts$ = productService.list()
      .pipe(
        catchError(e => {
          console.log(e)
          return of([])
        })
      )
  }

  buildFrameworks(){
    const values = this.frameworks.map(v=> new FormControl(false));
    return this.fb.array(values);
  }

  ngOnInit(): void {
    console.log(this.listProducts$)
  }

  onCheckboxChange(e: any) {
    const checkArray: FormArray = this.form.get('checkArray') as FormArray;
    if (e.checked) {
      checkArray.push(new FormControl(e.value));
    } else {
      let i = 0;
      checkArray.controls.forEach((item: any) => {
        if (item.value == e.value) {
          checkArray.removeAt(i);
          return
        }
        i++
      });
    }
  }
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSourceMarket.data.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSourceMarket.data.forEach(row => this.selection.select(row));
  }
  submitForm() {

  }

  onChangeEvent($event: MatCheckboxChange) {
    const id = $event.source.value
    const isChecked = $event.source.checked
    this.dataSourceMarket.data.map((d) => {
      if(d.id.toString() == id){
        d.isSelected = isChecked;
        return d
      }
      // @ts-ignore
      if(id == -1){

      }
      return d
    })
    console.log(this.dataSourceMarket)
  }
}


