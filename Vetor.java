public class Vetor {
    
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    // Esse método percorre o array, procurando pelo último elemento, ou seja, o primeiro elemento que não está preenchido (NULL).
    // O problema é que isto não é eficiente. Imaginar um array de centenas de elementos...
    /* public void adiciona(String elemento){
        for (int i = 0; i < this.elementos.length; i++){
            if (this.elementos[i] == null){
                this.elementos[i] = elemento;
                break;
            }
        }
    */
    
    // a variável 'tamanho' guarda o último elemento do array, evitando o problema anterior
    // Deve-se tomar cuidado com os limites do array
    /* public void adiciona(String elemento) throws Exception { 

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos");

        }

    }
    */
    public boolean adiciona(String elemento) throws Exception { 

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        } 
        return false;
    }

}
