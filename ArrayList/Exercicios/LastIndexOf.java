package ArrayList.Exercicios;

import java.util.ArrayList;

import ArrayList.Lista;

public class LastIndexOf {
    public static void main(String[] args) {
        
        ArrayList<String> arrayList = new ArrayList<String>(5);

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        Lista<String> lista = new Lista<String>(5);

        try {
            lista.adiciona("A");
            lista.adiciona("B");
            lista.adiciona("C");
            lista.adiciona("A");            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Implementado pelo Java
        System.out.println(arrayList.lastIndexOf("A"));

        // Implementado por nós
        System.out.println(lista.ultimoIndice("A"));
    }
}