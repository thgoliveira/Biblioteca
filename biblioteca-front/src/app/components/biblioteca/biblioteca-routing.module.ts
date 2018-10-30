import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BibliotecaListComponent } from './list/biblioteca-list.component';
import { BibliotecaFormComponent } from './form/biblioteca-form.component';

const routes: Routes = 
[
  { path: '', component: BibliotecaListComponent},
  { path: 'cadastrar', component: BibliotecaFormComponent  },
  { path: 'alterar/:id', component: BibliotecaFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BibliotecaRoutingModule { }
