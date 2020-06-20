package ArrayList;

// ED mais simples que existe. Armazena uma sequência de valores de mesmo tipo.
public class RevisaoVetoresArrays {
    public static void main(String[] args) {
        double [] temperaturas = new double [365];
        
        temperaturas [0] = 33.3;
        temperaturas [1] = 31.2;
        
        // Acessando os valores de um Array:
            for (int i=0; i < temperaturas.length; i++){
                System.out.println("Temperatura do dia " + (i+1) + " é: " + temperaturas[i]);
            }
        /* Enhanced For
            for (double temp : temperaturas){
                System.out.println(temp);
            }
        */
    }        
}

