import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  _filterList: filter[] | undefined;

  ngOnInit() {
    this.getFilters();
  }

  getFilters()
  {
    this._filterList= [
      {id:1, name:"Ecommerce", isSelected:false},
      {id:1, name:"ERP", isSelected:false},
      {id:1, name:"Loja Fisica", isSelected:false},
      {id:1, name:"Telecom", isSelected:false},
      {id:1, name:"Venda Direta", isSelected:false},
      {id:1, name:"Mobile First", isSelected:false},
      {id:1, name:"Digital Onboarding", isSelected:false},
      {id:1, name:"Lojista que nao desejam possuir ecommerce", isSelected:false},
    ]
  }

onchange(){
  console.log(this._filterList);
}


}

class filter {
  id: number | undefined;
  name: string | undefined;
  isSelected: boolean | undefined;
}
