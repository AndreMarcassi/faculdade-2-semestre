import { Livro } from "./Livro";

export interface Locacao {
    id: string;
    dataEmprestimo: string;
    dataDevolucaoEsperada: string;

    livros: Livro[];

}
