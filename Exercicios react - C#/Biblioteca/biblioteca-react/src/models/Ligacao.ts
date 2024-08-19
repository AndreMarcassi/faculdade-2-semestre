import { Livro } from "./Livro";

export interface Ligacao {
    Id: string;
    LivrosId: string;
    Livro: Livro;
    LocacoesId: string;
    Locacao: any;
}