import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path : '',
    redirectTo : 'location',
    pathMatch : 'full'
  },
  {
    path : 'location',
    loadChildren: './location/location.module#LocationModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }