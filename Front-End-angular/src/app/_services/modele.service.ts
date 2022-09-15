import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ModeleVehicule} from "../_models/modeleVehicule";
import {environment} from "../../environments/environment";



@Injectable({
  providedIn: 'root'
})
export class ModeleService {

  constructor(private http:HttpClient) { }
  public getModele():Observable<Array<ModeleVehicule>>{
    return this.http.get<Array<ModeleVehicule>>(`${environment.hostApi}/affiche/modele`)
  }

}
