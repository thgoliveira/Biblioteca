import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Autor } from '../model/autor';

const URL = "http://localhost:8080/autor";

@Injectable({
  providedIn: 'root'
})

export class AutorService {

  constructor(private http: HttpClient) { }

  buscarAutores(): Observable<Autor[]>{
    return this.http.get<Autor[]>(URL);
  }
}
