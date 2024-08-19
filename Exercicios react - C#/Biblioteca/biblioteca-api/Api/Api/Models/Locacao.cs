using System.ComponentModel.DataAnnotations;

namespace Api.Models;

public class Locacao{

    public Locacao(){
        Id = Guid.NewGuid();
        DataEmprestimo = DateTime.Now;
        DataDevolucaoEsperada = DataEmprestimo.AddDays(15);
    }


    public Guid Id { get; set; }
    public DateTime DataEmprestimo { get; set; }
    public DateTime DataDevolucaoEsperada { get; set; }

    public Guid UsuarioId { get; set; }
    public Usuario Usuario { get; set; }
    public ICollection<Ligacao> Ligacoes{ get; set; } = new List<Ligacao>();

    public decimal CalcularMulta(){
        decimal multaPorDiaAtrasado = 1.0m;
        if (DateTime.Now <= DataDevolucaoEsperada){
            return 0;
        } else{
            TimeSpan atraso = DateTime.Now - DataDevolucaoEsperada;
            int diasAtraso = (int)Math.Ceiling(atraso.TotalDays);
            decimal multaTotal = diasAtraso * multaPorDiaAtrasado;
            return multaTotal;
        }
    }
    public int ClacularDia(){
        TimeSpan atraso = DateTime.Now - DataDevolucaoEsperada;
        int diasAtraso = (int)Math.Ceiling(atraso.TotalDays);
        return diasAtraso;
    }
    
}