import { Vehicule } from '../_models/vehicule';
import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";


@Injectable({ providedIn: 'root' })
export class VehiculeService {


  constructor(private http:HttpClient){}

  // TODO: Implement getting all vehicules from the REST API service
  getVehicules(): Observable<any> {
    return this.http.get<Vehicule>(`${environment.hostApi}/affiche`)
  }
  public savevehicules(vehicules:Vehicule):Observable<Vehicule>{
    return this.http.post<Vehicule>(`${environment.hostApi}/ajout`,vehicules)

  }
  public deletevehicule(id:number){
    return this.http.delete(`${environment.hostApi}/suprimer/`+id)

  }
  editevehicule(id: number):Observable<Vehicule> {
    return this.http.get<Vehicule>(`${environment.hostApi}/editer/`+id)
  }
  update(id: number, vehicule:Vehicule){
    return this.http.put(`${environment.hostApi}/updateVehicule/`+id,vehicule)
  }
  vehiculeenmarche(){
    return this.http.get(`${environment.hostApi}/enmarche`)
  }
  vehiculpasEnmarche(){
    return this.http.get(`${environment.hostApi}/enmarchefals`)
  }
  vehiculeenpanne(){
    return this.http.get(`${environment.hostApi}/enpanne`)
  }
  vehiculepasenpanne(){
    return this.http.get(`${environment.hostApi}/enpanne`)
  }
}
