import { Component, OnInit } from '@angular/core';
import { Vehicule } from 'src/app/_models/vehicule';
import { VehiculeService } from 'src/app/_services/vehiculeService';
import {ConfirmationService, MessageService} from "primeng/api";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Marquevehicule} from "../../_models/marquevehicule";
import {ModeleVehicule} from "../../_models/modeleVehicule";
import {Typesvoiture} from "../../_models/Typesvoiture";
import {ActivatedRoute, Router} from "@angular/router";
import {MarqueServiceService} from "../../_services/marque-service.service";
import {ModeleService} from "../../_services/modele.service";
import {TypesvehiculeServiceService} from "../../_services/typesvehicule-service.service";

@Component({
  selector: 'app-vehicules',
  templateUrl: './vehicules.component.html',
  styleUrls: ['./vehicules.component.css'],
  providers: [MessageService, ConfirmationService]
})
export class VehiculesComponent implements OnInit {
  errorMessage!:string;
  vehicules:Vehicule[]
  selectedvehicule: Vehicule;
  vehicule:Vehicule
  productDialog: boolean;
  recupermarque!:Array<Marquevehicule>;
  modeles!:Array<ModeleVehicule>
  recupermodele!:Array<ModeleVehicule>
  formulaires!: FormGroup
  recuperrertypes!:Array<Typesvoiture>

  recup:any;
  loading: boolean;

  constructor(private messageService: MessageService, private confirmationService: ConfirmationService,private service: VehiculeService,private router:Router,private marqueServiceService:MarqueServiceService, private form:FormBuilder,private  Vehiculeservice:VehiculeService,private modeleService :ModeleService,private  route:ActivatedRoute, private typesvehiculeService:TypesvehiculeServiceService) { }

  ngOnInit(): void {
    this.getModele()
    this.getMarqueForme()
    this.loadtypes()
    this.formulaires= this.form.group({
      matricule :this.form.control(null,[Validators.required,Validators.minLength(6)]),
      nombrePlace :this.form.control(null,[Validators.required,Validators.minLength(6)]),
      modele :this.form.control(null,[Validators.required]),
      status :this.form.control(null,[Validators.required]),
      dateAchat:this.form.control(null,[Validators.required]),
      dateSOrtie:this.form.control(null,[Validators.required]),
      dateMisEnMarche:this.form.control(null,[Validators.required]),
      etats:this.form.control(null,[Validators.required]),
      marque:this.form.control(null,[Validators.required]),
      typesvehicule:this.form.control(null,[Validators.required]),
      numerochassie:this.form.control(null,[Validators.required]),
      typesCarburant:this.form.control(null,[Validators.required]),
    })
    this.loading = true;
    this.getallvehicules()

  }


  getallvehicules(){
    this.service.getVehicules().subscribe({ next:(data)=>{
        this.vehicules=data;
        this.loading = false;

      }
    })
  }
  delecteVehicules(id:number) {
    this.confirmationService.confirm({
      message: 'vous etes sur de vouloir suprrimer ?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.service.deletevehicule(id).subscribe(data=>{
          this.getallvehicules()
        })
        this.messageService.add({severity:'success', summary: 'Successful', detail: 'accident suprimer', life: 3000});

      }

    });
    this.getallvehicules()
  }
  editeVehicules(id:number) {

    this.service.editevehicule(id).subscribe({
      next:(data)=>{
        this.vehicule=data
        this.productDialog = true;
      }
    })
  }
  updateEnployer(id:number){
    this.router.navigate(["updateEployer",id])
  }

  public getModele(){
    this.modeleService.getModele().subscribe({
      next:(data)=>{
        this.recupermodele=data;
        console.log(this.recupermarque)
      }
    })
  }
  public getMarqueForme(){
    this.marqueServiceService.getMarque().subscribe({
      next:(data)=>{
        this.recupermarque=data;
        console.log(this.recupermarque)
      }
    })
  }

  public loadModele() {
    let id:number = this.formulaires.value.marque
    this.marqueServiceService.getMarqueById(id).subscribe({
      next:(data)=>{
        this.modeles=data.modeles
      }
    })
  }
  loadtypes(){
    this.typesvehiculeService.getTypeheicule().subscribe({
      next:(data)=>{
        this.recuperrertypes=data
      }
    })
  }
  openNew() {
    this.vehicule =new Vehicule();
    this.productDialog = true;


  }

  savevehicule(id:number) {
    if (this.vehicule.id) {
      this.service.update(this.vehicule.id,this.formulaires.value).subscribe(data=>{
        data => {
          this.formulaires.setValue(data)

        }
        this.messageService.add({severity:'success', summary: 'Successful', detail: 'accident modifier', life: 3000});
        this.productDialog = false;
        this.getallvehicules()
      })
    }else {
      this.service.savevehicules(this.formulaires.value).subscribe({
        next:data=>{
          this.messageService.add({severity:'success', summary: 'Successful', detail: 'accident enregistrer', life: 3000});

        }

      })

    }
    this.formulaires.reset()
    this.productDialog = false;
    this.getallvehicules()

  }

}
