import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListComponent } from './list/list.component';
import { LocationRoutingModule } from './location-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LocationService } from '../services/location.service';
import { HttpRestClientService } from '../services/http-rest-client.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AngularFontAwesomeModule } from 'angular-font-awesome';


@NgModule({
  declarations: [ListComponent],
  imports: [
    CommonModule,
    LocationRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AngularFontAwesomeModule
  ],
  providers : [LocationService,
    HttpRestClientService]
})
export class LocationModule { }
