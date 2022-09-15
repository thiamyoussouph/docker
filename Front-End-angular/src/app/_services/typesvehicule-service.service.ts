import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Typesvoiture} from "../_models/Typesvoiture";
import {environment} from "../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class TypesvehiculeServiceService {

  constructor(private http:HttpClient) { }
  public getTypeheicule():Observable<Array<Typesvoiture>>{
    return this.http.get<Array<Typesvoiture>>(`${environment.hostApi}/affiche/typesvehicule`)
  }
}
