namespace Api.Models;

public class Categoria{

    public Categoria(){
        Id = Guid.NewGuid();
    }

    public Categoria(String nomeCategoria)
    {
        NomeCategoria = nomeCategoria;
        Id = Guid.NewGuid();
    }

    public Guid Id { get; set; }
    public String? NomeCategoria { get; set; }
    public ICollection<Livro> Livros{ get; } = new List<Livro>();

}