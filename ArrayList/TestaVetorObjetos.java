package ArrayList;

public class TestaVetorObjetos {
    public static void main(String[] args) {
        
        VetorObjetos vetor = new VetorObjetos(3);

        Contato c1 = new Contato("Contato 1", "1234-4321", "contato1@email.com");
        Contato c2 = new Contato("Contato 2", "2222-4321", "contato2@email.com");
        Contato c3 = new Contato("Contato 3", "3333-4321", "contato3@email.com");

        Contato c4 = new Contato("Contato 3", "3333-4321", "contato3@email.com");


        try {

            vetor.adiciona(c1);
            vetor.adiciona(c2);
            vetor.adiciona(c3);

            // Seja um vetor uma ED que armazena valores de um mesmo tipo. Mesmo o Java aceitando adicionar objetos e inteiros em um mesmo vetor,
            // isto não está certo. Para isto, deve-se utilizar os Generics (Java 5)
            vetor.adiciona(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Tamanho = " + vetor.tamanho());

        // Mesmo o c4 não estando no vetor, ele contém exatamente os mesmos dados do c3, logo o .equals() retorna True para eles
        System.out.println(vetor.buscaElemento(c4));

        System.out.println(vetor);
    }
}