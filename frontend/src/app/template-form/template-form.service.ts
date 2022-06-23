import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Market} from "./model/market";

@Injectable({
  providedIn: 'root'
})
export class TemplateFormService {
  private readonly API = 'showProduct/listTest'
  constructor(private httpClient: HttpClient) {

  }

  postProducts(valueSubmit: Market[]){
    this.httpClient.post(this.API, valueSubmit, {headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')}).subscribe(dados => console.log(dados))
  }
}
