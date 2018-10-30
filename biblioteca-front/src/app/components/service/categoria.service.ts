import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../model/categoria';

const URL = "http://localhost:8080/categoria";

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  buscarCategorias(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>(URL);
  }
}
