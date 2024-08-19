package br.edu.up;

import br.edu.up.models.Ponto;
import br.edu.up.utils.Prompt;


/*

Cenário 2: Crie uma classe que represente um Ponto no espaço bidimensional. Na classe 
    Programa efetue as operações listadas abaixo. Para realização dos cálculos de elevação ao 
    quadrado utilizar Math.pow(valor, 2) e para extração da raiz quadrada utilizar Math.sqrt(valor).
    (Não precisa usar Model-View-Controller MVC) 
 
        1. Crie um objeto ponto1 usando o primeiro construtor; 
        2. Crie um objeto ponto2 na posição (2,5); 
        3. Calcule a distância do ponto1 ao ponto2; 
        4. Calcule a distância do ponto2 às coordenadas (7,2); 
        5. Altere o valor de x para 10 no ponto1; 
        6. Altere o valor de y para 3 no ponto1; 

*/

public class Program {

    public static void main(String[] args) {

        double distancia;

        Ponto ponto1 = new Ponto();
        Ponto ponto2 = new Ponto(2, 5);

        distancia = ponto1.calcularDistancia(ponto2);

        Prompt.separador();
        Prompt.imprimir("ponto1 (" + ponto1.getX() + ", " + ponto1.getY() + ")");
        Prompt.imprimir("ponto2 (" + ponto2.getX() + ", " + ponto2.getY() + ")");
        Prompt.separador();

        Prompt.imprimir("A distancia entre o ponto1 (0,0) e o ponto2 (2,5) é de " + distancia);
        distancia = ponto2.calcularDistancia(7, 2);
        Prompt.imprimir("A distancia entre o ponto2 (2,5) e às coordenadas (7,2) é de " + distancia);

        Prompt.separador();
        ponto1.setX(10);
        ponto1.setY(3);
        Prompt.imprimir("a nova posição do ponto1 é (" + ponto1.getX() + ", " + ponto1.getY() + ")");
        Prompt.separador();

    }
}