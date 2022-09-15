import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {Marquevehicule} from "../_models/marquevehicule";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MarqueServiceService {

  constructor(private http:HttpClient) { }
  public getMarque():Observable<Array<Marquevehicule>>{
    return this.http.get<Array<Marquevehicule>>(`${environment.hostApi}/affiche/marque`)
  }
  public getMarqueById(id:number):Observable<Marquevehicule>{
    return this.http.get<Marquevehicule>(`${environment.hostApi}/affiche/marque/`+id)
  }
}
