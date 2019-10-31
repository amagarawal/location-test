import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { map, retry, catchError } from 'rxjs/operators';
import { SearchParams } from '../model/location';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpRestClientService {


  private host = environment.baseUrl;

  constructor(
    private router:Router,
    private http: HttpClient,
  ) {}

  get(url:String, data?:any){

    let restUrl = this.getEndpoint(url);
    console.log(restUrl);
    return this.http.get(restUrl,{params: data}) .pipe(
      retry(2),
      catchError(this.handleError));

  }

  post(url:String, data:any){

    console.log(data);
    return this.http.post(this.getEndpoint(url), data).pipe(
      catchError(this.handleError)
      );

  }

  put(url:String, data:any){
    return this.http.put(this.getEndpoint(url), data).pipe(
      catchError(this.handleError)
      );
  }

  delete(url:String){
    
    return this.http.delete(this.getEndpoint(url)).pipe(
      catchError(this.handleError)
      );
  }

  patch(){}

  private getEndpoint(url):string
  {
    return this.host + "/" + url;
  }

  handleError(error: HttpErrorResponse)
  {
    console.log(error);
    return throwError(Error);
  }
}
