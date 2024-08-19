/*

15. Tendo como dados de entrada dois pontos quaisquer no plano, P1(x1, y1) e P2(x2, 
y2), calcule e retorne a distância entre eles. A fórmula que efetua tal cálculo é: d = raiz 
(((x2 - x1)2) + ((y2 - y1)2)). Exemplo: p1(0, 5), p2(10, 20). Distancia: 18,03

*/

public class Exercicio15 {
    public static void Executar(){
        
    int X1 = Prompt.lerInteiro("Digite O X do primeiro ponto: ");
    int Y1 = Prompt.lerInteiro("Digite O Y do primeiro ponto: ");

    int X2 = Prompt.lerInteiro("Digite O X do segundo ponto: ");
    int Y2 = Prompt.lerInteiro("Digite O Y do segundo ponto: ");

    double D = Math.sqrt(((X2-X1)*(X2-X1))+((Y2-Y1)*(Y2-Y1)));

    Prompt.imprimir("A distancia entre os dois pontos é: " + D);

    }
}