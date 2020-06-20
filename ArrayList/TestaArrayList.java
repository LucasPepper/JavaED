package ArrayList;

import java.util.ArrayList;

public class TestaArrayList {
    public static void main(String[] args) {

        // O Java já possui uma ED (ArrayList) implementada com todos os métodos que implementamos anteriormente
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("A");
        arrayList.add("C");

        System.out.println(arrayList);

        arrayList.add(1, "B");

        System.out.println(arrayList);

        boolean existe = arrayList.contains("A");

        if (existe) {
            System.out.println("Elemento existe no array");
        } else {
            System.out.println("Elemento não existe no array");

        }

        int pos = arrayList.indexOf("D");
        if (pos > -1) {
            System.out.println("Elemento existe no array" + pos);
        } else {
            System.out.println("Elemento não existe no array" + pos);
        }

        System.out.println(arrayList.get(1));

        arrayList.remove(0);
        arrayList.remove("B");

        System.out.println(arrayList);
        
        System.out.println(arrayList.size());

        arrayList.lastIndexOf("B");
    }
}