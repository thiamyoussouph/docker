
import {Typesvoiture} from "./Typesvoiture";
import {Marquevehicule} from "./marquevehicule";

export interface ModeleVehicule{
  id:number,
  libellet:string
  marque:Marquevehicule;
  typesVehicules:Typesvoiture;
}
