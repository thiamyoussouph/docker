import { ModeleVehicule } from "./modeleVehicule";

export class Vehicule {
  id:number;
  matricule:string;
  nombrePlace:number;
  dateSOrtie:Date;
  dateMisEnMarche:Date;
  dateAchat:Date;
  typesCarburant:string;
  numerochassie:string;
  status:string;
  etats:string;
  modele: ModeleVehicule;

}
