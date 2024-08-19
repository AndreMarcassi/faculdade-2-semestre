using System.ComponentModel.DataAnnotations;

namespace Api.Models;

public class Usuario{

    public Usuario(){
        Id = Guid.NewGuid();
    }

    public Usuario(String nome, String cpf, String telefone, String email, String endereco, String senha)
    {
        Nome = nome;
        Cpf = cpf;
        Telefone = telefone;
        Email = email;
        Endereco = endereco;
        Senha = senha;
        Id = Guid.NewGuid();
    }

    public Guid Id { get; set; }

    [Required(ErrorMessage = "O nome é obrigatório.")]
    public String? Nome { get; set; }


    [Required(ErrorMessage = "O Cpf é obrigatório.")]
    public String? Cpf { get; set; }
    public String? Senha { get; set; }


    [Required(ErrorMessage = "O Telefone é obrigatório.")]
    public String? Telefone { get; set; }

    [Required(ErrorMessage = "O e-mail é obrigatório.")]
    [EmailAddress(ErrorMessage = "O e-mail deve ser válido.")]
    public String? Email { get; set; }    
    public String? Endereco { get; set; }
    public List<Locacao> Locacoes { get; set; }

}