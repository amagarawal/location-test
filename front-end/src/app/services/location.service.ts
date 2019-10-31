import { Injectable } from '@angular/core';
import { HttpRestClientService } from './http-rest-client.service';
import { HttpResponse } from '@angular/common/http';
import { LocationDetails, SearchParams} from 'src/app/model/location';

@Injectable()
export class LocationService {

  constructor(
    private _dataService:HttpRestClientService
  ) {}


  getAllLocation() {
    console.log("Making a rest Call");
    
    return this._dataService.get("location");
  }

  searchlocation(params:SearchParams){
    return this._dataService.get("location/nearby", params);
  }

  deleteLocation(id:String){
    return this._dataService.delete("location/" + id);
  }

  updateLocation(loc:LocationDetails){
    return this._dataService.put("location/" + loc.id, loc);
  }

  addLocation(loc:LocationDetails){
    console.log(loc);
    return this._dataService.post("location", loc);
  }
}
