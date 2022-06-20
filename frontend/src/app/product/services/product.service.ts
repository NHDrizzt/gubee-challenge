import {Injectable, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient, HttpParams} from "@angular/common/http";
import {catchError, delay, first, Observable, of, tap} from "rxjs";
import {ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ProductService  implements OnInit {
  private readonly API = 'showProduct/list'

  constructor(private httpClient: HttpClient) {

  }

  ngOnInit(): void {
    }



  list() {
    return this.httpClient.get<Product[]>(this.API)
      .pipe(
        first(),
        delay(2000),
        tap(product => console.log(product))
      );
  }


  getProducts(valueSubmit: any): Observable<any> {
    return this.httpClient.get(this.API)
      .pipe(
        first(),
        tap(product => console.log(product)),
        catchError(e => {
          console.log(e)
          return of([])
        }
      ))
  }
}
