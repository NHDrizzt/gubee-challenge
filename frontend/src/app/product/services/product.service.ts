import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {delay, first, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly API = '/assets/test.json'

  constructor(private httpClient: HttpClient) {

  }

  list() {
    return this.httpClient.get<Product[]>(this.API)
      .pipe(
        first(),
        delay(3000),
        tap(product => console.log(product))
      );
  }
}
