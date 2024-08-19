/*

20. Elabore um algoritmo que calcule a quantidade de litros de combustível gasta em 
uma viagem, utilizando um automóvel que faz 12km por litro e considerando que são 
fornecidos o tempo em hora e a velocidade média da viagem.

*/

import java.text.DecimalFormat;

public class Exercicio20 {
    public static void Executar(){

    double Tempo = Prompt.lerDecimal("Digite o total de tempo em horas: ");

    double Vmedia = Prompt.lerDecimal("Digite a velocidade media da viagem: ");
        
    double Gasto = (Vmedia*Tempo)/12;

    DecimalFormat df = new DecimalFormat("#.##");
    String mediaFormatada = df.format(Gasto);

    Prompt.imprimir("A media do aluno é " + mediaFormatada);

    }
}