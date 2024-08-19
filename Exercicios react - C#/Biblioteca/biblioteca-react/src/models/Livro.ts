export interface Livro{
    id: string;
    editora?: string;
    titulo: string;
    autor?: string;
    quantidade?: number;
    capa: string;
    capaFile: File;
    categoriaId: string;
}