import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Livro } from '../model/livro';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

const URL = "http://localhost:8080/biblioteca";

@Injectable({
  providedIn: 'root'
})
export class LivroService {


  constructor(private http: HttpClient) { }

  buscarTodos(): Observable<Livro[]>{
    return this.http.get<Livro[]>(URL);
  }

  inserir(formulario: FormGroup){
    return this.http.post<void>(URL, formulario);
  }

  remover(id: number){
    return this.http.delete<void>(URL + "/" + id);
  }

  buscarPorID(idAlterar: number): Observable<Livro>{
    return this.http.get<Livro>(URL + "/" + idAlterar)
  }

  alterar(formulario: FormGroup): Observable<void>{
    return this.http.post<void>(URL, formulario);
  }


}
