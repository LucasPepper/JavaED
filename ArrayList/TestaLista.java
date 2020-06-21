package ArrayList;

public class TestaLista {
    public static void main(String[] args) {
        Lista<Contato> vetor = new Lista<Contato>(1);

        Contato contato42 = new Contato("", "", "");

        // vetor.adiciona("Elemento");
        try {
            vetor.adiciona(contato42);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}