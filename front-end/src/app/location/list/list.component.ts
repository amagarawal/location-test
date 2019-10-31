import { Component, OnInit } from '@angular/core';
import { LocationService } from 'src/app/services/location.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { HttpResponse } from '@angular/common/http';
import { SearchParams, LocationDetails } from 'src/app/model/location';
import { ToastrService } from 'ngx-toastr';
declare var jQuery:any;

@Component({
  selector: 'loc-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  search: SearchParams = new SearchParams();
  locationDetails: LocationDetails = new LocationDetails();

  locations: LocationDetails[] = [];
  geolocationEnabled: Boolean = true;
  isSearch: Boolean = false;
  isEdit = false;



  constructor(
    private locationService: LocationService,
    private toastr: ToastrService 
  ) { }

  ngOnInit() {

    this.loadAllLocations();
  }


  loadAllLocations() {
    this.locationService.getAllLocation().subscribe(
      (data: LocationDetails[]) => {
        console.log(data);
        this.locations = data;
        console.log(this.locations);
      },
      (error) => {
        this.toastr.error("Ohh ! " + error.message);
    });
      console.log(this.locations);
  }


  searchLocation() {

    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        console.log(position);
        this.search.latitude = position.coords.latitude;
        this.search.longitude = position.coords.longitude;

        this.locationService.searchlocation(this.search).subscribe(
          (data:any) => {
            this.locations = data;
          },
          (error) => {
            this.toastr.error("Ohh ! " + error.message);
        }
        );
      });
    } else {
      alert("Geolocation is not supported by this browser.");
      this.geolocationEnabled = false;
      this.search.latitude = 0.00;
      this.search.longitude = 0.00;
      this.loadAllLocations();
    }
    this.isSearch = true;
  }

  reset() {
    this.isSearch = false;
    this.search = new SearchParams();
    this.loadAllLocations();
  }

  getCurrentLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        console.log(position);
        this.search.latitude = position.coords.latitude;
        this.search.longitude = position.coords.longitude;
      });
    } else {
      this.toastr.error("GeoLocation is not Enabled, Search Results might be affected.");
      this.geolocationEnabled = false;
      this.search.latitude = 0.00;
      this.search.longitude = 0.00;
    }
  }

  resetModal() {
    this.locationDetails = new LocationDetails();
  }


  add() {
    this.locationService.addLocation(this.locationDetails).subscribe(
      (data:any) =>{
        this.toastr.success("Location Successfully Added");
        this.loadAllLocations();
      },
      (error) => {
        this.toastr.error("Ohh ! " + error.message);
    }
    );
    jQuery("#exampleModalCenter").modal("hide");
  }

  editMode(loc:LocationDetails)
  {
    this.locationDetails = loc;
    this.isEdit = true;


  }
  update() {
    this.locationService.updateLocation(this.locationDetails).subscribe(
      (data:any) =>{
        this.toastr.success("Location Successfully Updated");
        this.loadAllLocations();
        this.locationDetails = new LocationDetails();  
      },
      (error) => {
        this.toastr.error("Ohh ! " + error.message);
    }
    );
    jQuery("#exampleModalCenter").modal("hide");
    this.isEdit = false;
  }

  delete(id: String) {
    this.locationService.deleteLocation(id).subscribe(
      (data: any) => {
        this.toastr.success("Location Successfully Deleted");
        this.loadAllLocations();
      },
      (error) => {
        this.toastr.error("Ohh ! " + error.message);
    }
    )

  }

}
