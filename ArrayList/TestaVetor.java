package ArrayList;

public class TestaVetor {

    public static void main(String[] args) {
        
        Vetor vetor = new Vetor(3);

        try {
            vetor.adiciona("A");
            vetor.adiciona("B");
            vetor.adiciona("C");
            vetor.adiciona("E");
            vetor.adiciona("F");
            vetor.adiciona("G");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(vetor.tamanho());

        System.out.println(vetor);

        System.out.println(vetor.buscaPosicao(1));

        System.out.println(vetor.buscaElemento("C"));

        vetor.adiciona(3, "D");

        System.out.println(vetor);

        vetor.removerPosicao(1);

        System.out.println(vetor);

        vetor.removerElemento("C");

        System.out.println(vetor);

    }
    
}