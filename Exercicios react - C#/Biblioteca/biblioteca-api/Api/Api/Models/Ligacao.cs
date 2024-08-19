namespace Api.Models;

public class Ligacao{

    public Guid Id { get; set;}
    public Guid LivrosId { get; set; }
    public Livro? Livro{ get; set; } = null!;
    public Guid LocacoesId { get; set; }
    public Locacao? Locacao{ get; set; } = null!;
    
}