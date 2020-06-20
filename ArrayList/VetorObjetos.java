package ArrayList;

// import java.util.Arrays;

public class VetorObjetos {

    private Object[] elementos;
    private int tamanho;

    // Construtor
    public VetorObjetos(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    /* Esse método percorre o array, procurando pelo último elemento, ou seja, o
    // primeiro elemento que não está preenchido (NULL).
    // O problema é que isto não é eficiente. Imaginar um array de centenas de
    // elementos...
    
    public void adiciona(String elemento){ 
        for (int i = 0; i < this.elementos.length; i++){ 
            if (this.elementos[i] == null) {
                this.elementos[i] = elemento;
                break; 
            } 
        }
    

    // a variável 'tamanho' guarda o último elemento do array, evitando o problema
    // anterior
    // Deve-se tomar cuidado com os limites do array
    
    public void adiciona(String elemento) throws Exception {
    
    if (this.tamanho < this.elementos.length) { 
        this.elementos[this.tamanho] = elemento;
        this.tamanho++; 
    } else { 
        throw new exception("Vetor já está cheio, não é possível adicionar mais elementos");
    
    }
    
    }
    */

    public boolean adiciona(Object elemento) throws Exception {

        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // Adicionar um elemento a determinada posição, realocando o array se necessário. Pensar nos casos em que alvo = 0, alvo = metade, alvo = last
    public void adiciona(int posicao, Object elemento) {

        this.aumentaCapacidade();

        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        // mover todos os elementos
        for (int i = this.tamanho-1; i >= posicao; i--) {
            this.elementos[i+1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    public void removerElemento(Object elemento) {

        int posicao = buscaElemento(elemento);

        if(posicao != -1) {
            for (int i = buscaElemento(elemento); i < this.tamanho-1; i++) {
                this.elementos[i] = this.elementos[i+1];
            }
        
            this.tamanho--;
        }
        else {
            System.out.println("Elemento '" + elemento + "' não encontrado!");
        }
    }
    

    public void removerPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        for (int i = posicao; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;

    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // Retorna o valor na posição determinada
    public Object buscaPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        return this.elementos[posicao];
    }

    // Verifica se o elemento existe no array
    public int buscaElemento(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    // Armazena a posição do último elemento não-nulo no array
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }

}
