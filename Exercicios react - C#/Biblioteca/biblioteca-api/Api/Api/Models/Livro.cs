using System.ComponentModel.DataAnnotations;
using System.Reflection.Metadata;

namespace Api.Models;

public class Livro{

    public Livro(){
        Id = Guid.NewGuid();
    }

    public Livro(String titulo, String editora, String autor, int quantidade, string capaFilePath){
        Titulo = titulo;
        Editora = editora;
        Autor = autor;
        Quantidade = quantidade;
        CapaFilePath = capaFilePath;
        Id = Guid.NewGuid();
    }

    public Guid Id { get; set; }

    [Required(ErrorMessage = "A Editora é obrigatório.")]
    public String? Editora { get; set; }

    [Required(ErrorMessage = "O Titulo é obrigatório.")]
    public String? Titulo { get; set; }

    [Required(ErrorMessage = "O Autor é obrigatório.")]
    public String? Autor { get; set; }

    [Required(ErrorMessage = "A Quantidade é obrigatória.")]
    public int Quantidade { get; set; }
    public string? CapaFilePath { get; set; }
    public Guid CategoriaId { get; set; }
    public Categoria Categoria { get; set; }  = null!;
    public ICollection<Ligacao> Ligacoes{ get; set; } = new List<Ligacao>();

}