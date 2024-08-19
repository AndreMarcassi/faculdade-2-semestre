/*

19. Faça um algoritmo que receba o raio e a altura de um cilindro e retorne o seu 
volume calculado de acordo com a seguinte fórmula: volume = 3.14 * raio * altura; 
Exemplo: raio = 10, altura = 15. Volume = 4710

*/


public class Exercicio19 {
    public static void Executar(){

        double Raio = Prompt.lerDecimal("Digite o raio do cilindro: ");
        double Altura = Prompt.lerDecimal("Digite a Altura do cilindro: ");

        double Volume = ((Raio* Raio) * 3.14)*Altura;

        Prompt.imprimir("O volume total do cilindro é " + Volume);
        
    }
}