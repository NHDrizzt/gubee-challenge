import {Component, OnInit} from '@angular/core';
import {Market} from "../model/market";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Stack} from "../model/stack";
import {Product} from "../model/product";
import {ProductService} from "../services/product.service";
import {catchError, EMPTY, Observable, of} from "rxjs";
import { SelectionModel } from '@angular/cdk/collections';
import {MatTableDataSource} from "@angular/material/table";
import {MatCheckboxChange} from "@angular/material/checkbox";
import {HttpClient} from "@angular/common/http";

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
  dataMarket: Market[] = listMarket;
  displayedColumns: string[] = ['name'];
  columnsToDisplay: string[] = this.displayedColumns.slice();
  columns = [
    {
      columnDef: 'name',
      header: 'Name',
      cell: (element: Market) => `${element.name}`,
    },
  ];
  form: FormGroup;
  selection = new SelectionModel<Market>(true, []);

  displayProducts = ["id", "name", "description"]

  listProducts$: Observable<Product[]>
  listProd = []
  displayedSubmit = ["submit"];
  row: any;
  parentSelector: boolean = false;

  constructor(
    private fb: FormBuilder,
    private productService: ProductService,
    private http: HttpClient,
    ) {
    this.form = this.fb.group({
      checkArray: this.fb.array([]),
      markets: this.buildFrameworks()
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
    const values = this.dataMarket.map(v=> new FormControl(false));
    return this.fb.array(values);
  }

  ngOnInit(): void {
      this.onRefresh();
  }

  onRefresh() {
    this.listProducts$ = this.productService.list().pipe(
      catchError(error => {
        console.error(error);
        return EMPTY;
      })
    );
  }

  getMarketControls() {
    return this.form.get('markets') ? (<FormArray>this.form.get('markets'))['controls'] : null;
  }

  onSubmit() {
    console.log(this.form.value);

    let valueSubmit = Object.assign({}, this.form.value);

    valueSubmit = Object.assign(valueSubmit, {
      markets: valueSubmit.markets
        .map((v: any, i: any) => v ? this.dataMarket[i].name : null)
        .filter((v: any) => v !== null)
    });

    console.log(valueSubmit)

    if(this.form.valid){
      this.productService.getProducts(valueSubmit).subscribe(
        () =>{ console.log("success")
        })
    }

  }
}


