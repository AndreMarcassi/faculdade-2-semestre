using System.ComponentModel.DataAnnotations;

namespace Api.Models;

public class LoginRequest{
    
        [Required(ErrorMessage = "O Cpf é obrigatório.")]
        public string? Cpf { get; set; }

        [Required(ErrorMessage = "A Senha é obrigatória.")]
        public string? Senha { get; set; }
}