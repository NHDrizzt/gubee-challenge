import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly API = '/assets/test.json'

  constructor(private httpClient: HttpClient) {

  }

  list() {
    return this.httpClient.get<Product[]>(this.API);
  }
}
