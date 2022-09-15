import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehiculesComponent } from './views/vehicules/vehicules.component';

const routes: Routes = [
  {
    path: 'vehicules',
    component: VehiculesComponent,
    data: {
      breadcrumb: 'Vehicules',
    },
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
