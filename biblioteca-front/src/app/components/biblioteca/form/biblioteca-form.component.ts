import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AutorService } from '../../service/autor.service';
import { CategoriaService } from '../../service/categoria.service';
import { LivroService } from '../../service/livro.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Livro } from '../../model/livro';
import { Autor } from '../../model/autor';
import { Categoria } from '../../model/categoria';

@Component({
  selector: 'app-biblioteca-form',
  templateUrl: './biblioteca-form.component.html',
  styleUrls: ['./biblioteca-form.component.css']
})
export class BibliotecaFormComponent implements OnInit {

  formulario: FormGroup;
  livro: Livro;
  autores: Array<Autor>;
  categorias: Array<Categoria>;
  idAlterar: number;


  constructor(
    private formBuilder: FormBuilder,
    private as: AutorService,
    private cs: CategoriaService,
    private ls: LivroService,
    private router: Router,
    private route: ActivatedRoute
  ) { }



  ngOnInit() {
    this.livro = new Livro();
    this.autores = new Array();
    this.categorias = new Array();
    this.configurarForm();
    this.buscarAutores();
    this.buscarCategorias();
    this.idAlterar = +this.route.snapshot.paramMap.get('id');
    if(this.idAlterar){
      this.buscarPorID();
    }
  }

  configurarForm(){
    this.formulario = this.formBuilder.group({
      id: [null],
      titulo: [null],
      publicacao: [null],
      autorDTO: this.formBuilder.group({
        id: [null],
      }),
      categoriaDTO: this.formBuilder.group({
        id: [null],
      })
    });
  }

  salvar(){
    this.ls.inserir(this.formulario.value).subscribe(() => this.router.navigate(["/livro"]))
  }

  buscarAutores(){
    this.as.buscarAutores().subscribe(dados => this.autores = dados);
  }

  buscarCategorias(){
    this.cs.buscarCategorias().subscribe(dados => this.categorias = dados);
  }

  buscarPorID(){
    this.ls.buscarPorID(this.idAlterar).subscribe(resp => {this.formulario.patchValue(resp), console.log(resp)});

  }

}
