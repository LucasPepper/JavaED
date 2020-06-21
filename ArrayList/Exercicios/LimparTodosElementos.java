package ArrayList.Exercicios;

import java.util.ArrayList;

import ArrayList.Lista;

// Similar ao método clear() de ArrayList
public class LimparTodosElementos {
    public static void main(String[] args) {

        // Testando o clear() do ArrayList
        ArrayList<String> arrayList = new ArrayList<String>(5);

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        arrayList.clear();

        System.out.println(arrayList);

        Lista<String> lista = new Lista<String>(5);

        try {
            lista.adiciona("A");
            lista.adiciona("B");
            lista.adiciona("C");
            lista.adiciona("A");            
        } catch (Exception e) {
            e.printStackTrace();
        }

        lista.limpar();
        System.out.println(lista); 
        
    }
}