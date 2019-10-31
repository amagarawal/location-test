import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Route, Routes } from '@angular/router';
import { ListComponent } from './list/list.component';


const routes: Routes =[
  {
    path : '',
    component : ListComponent
  }
]
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes)
  ],
  exports : [RouterModule]
})
export class LocationRoutingModule { }
