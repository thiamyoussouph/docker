import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';

// PrimeNg imports
import { MenuModule } from 'primeng/menu';
import { ButtonModule } from 'primeng/button';
import { RippleModule } from 'primeng/ripple';
import {BreadcrumbModule} from 'primeng/breadcrumb';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import { VehiculesComponent } from './views/vehicules/vehicules.component';
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {DialogModule} from "primeng/dialog";
import {TableModule} from "primeng/table";
import {ToolbarModule} from "primeng/toolbar";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    BreadcrumbComponent,
    VehiculesComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MenuModule,
    ButtonModule,
    RippleModule,
    BreadcrumbModule,
    ConfirmDialogModule,
    DialogModule,
    TableModule,
    ToolbarModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
