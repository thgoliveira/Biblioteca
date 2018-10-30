import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BibliotecaRoutingModule } from './biblioteca-routing.module';
import { BibliotecaFormComponent } from './form/biblioteca-form.component';
import { BibliotecaListComponent } from './list/biblioteca-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    BibliotecaRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [BibliotecaFormComponent, BibliotecaListComponent]
})
export class BibliotecaModule { }
