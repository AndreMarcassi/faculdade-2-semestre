package br.edu.up;

import br.edu.up.View.Tela;

/*

    Cenário 8: Agenda de contatos (classe Contato abstrata) 
    
        Para a execução do software será necessário criar a classe Programa e utilizar o padrão Model-View
        Controller (MVC) para organizar a arquitetura do software. A classe Contato é abstrata (não permite a 
        geração de objetos). Os valores passados aos objetos criados pelas classes Pessoal e Comercial devem 
        ser lidos do teclado. 
        
        De acordo com as classes implementadas, implemente uma agenda de contatos com um menu onde é permitido: 
            1. Incluir um contato pessoal 
            2. Incluir um contato comercial 
            3. Excluir um contato pelo código  
            4. Consultar um contato pelo código 
            5. Listar todos os contatos 
            6. Sair do programa 

*/

public class Program {

    public static void main(String[] args) {
        
        Tela tela = new Tela();

        tela.menu();

    }
    
}