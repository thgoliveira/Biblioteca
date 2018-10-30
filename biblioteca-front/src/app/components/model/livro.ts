import { Autor } from "./autor";
import { Categoria } from "./categoria";

export class Livro{
    id: number;
    titulo: string;
    publicacao: string;
    autor: Autor;
    categoria: Categoria;
    idAutor: number;
    idCategoria: number;
}