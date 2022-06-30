import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Market} from "./model/market";
import {delay, first, Observable, tap} from "rxjs";
import {Product} from "./model/product";
import {Stack} from "./model/stack";
import {FilterProduct} from "./model/filterProduct";



@Injectable({
  providedIn: 'root'
})
export class TemplateFormService {
  private readonly API = 'showProduct/listTest'
  private readonly APIGet = 'showProduct/getAll'
  constructor(private httpClient: HttpClient) {

  }

  postProducts(marketSelected: Market[], stackSelected: Stack[]): Observable<Product[]>{
    let data = new FilterProduct(marketSelected, stackSelected);
    return this.httpClient.post<Product[]>(this.API,
      data,
      {headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')})
        .pipe(
          delay(400),
          tap(dado => console.log(dado)))
  }

  listMarkets(): Observable<Market[]> {
    return this.httpClient.get<Market[]>(this.API)
      .pipe(
      tap(product => console.log(product))
    );
  }

}
