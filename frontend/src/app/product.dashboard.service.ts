import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product.interface';

const PRODUCT_API: string = 'http://localhost:8080/showProduct';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ProductDashboardService {

  constructor(private http: HttpClient) { }


  getPersons(): Observable<Product[]> {
    return this.http.get<Product[]>(PRODUCT_API);
  }

  showPerson(person: Product): Observable<Product> {
    return this.http.post<Product>(PRODUCT_API, person);
  }
}
