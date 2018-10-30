import { Component, OnInit } from '@angular/core';
import { Livro } from '../../model/livro';
import { LivroService } from '../../service/livro.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-biblioteca-list',
  templateUrl: './biblioteca-list.component.html',
  styleUrls: ['./biblioteca-list.component.css']
})
export class BibliotecaListComponent implements OnInit {

  livro: Livro;
  livros: Array<Livro>;

  constructor(private ls: LivroService, private router: Router) { }

  ngOnInit() {
    this.livro = new Livro();
    this.livros = new Array();
    this.buscarTodos();
  }

  buscarTodos(){
    this.ls.buscarTodos().subscribe(dados => this.livros = dados);
  }

  excluir(id: number){
    this.ls.remover(id).subscribe(() => this.buscarTodos());
  }

}
