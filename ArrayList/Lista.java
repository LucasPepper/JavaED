package ArrayList;

import java.lang.reflect.Array;

// import java.util.Arrays;

public class Lista<T> {

    private T[] elementos;
    private int tamanho;

    // Construtor para tipo Genérico de um array. É feita a instância de um objeto com um cast superior para T[]
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public Lista(int capacidade, Class<T> tipoClasse) {
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
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

    public boolean adiciona(T elemento) throws Exception {

        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // Adicionar um elemento a determinada posição, realocando o array se necessário. Pensar nos casos em que alvo = 0, alvo = metade, alvo = last
    public void adiciona(int posicao, T elemento) {

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

    public void removerElemento(T elemento) {

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
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // Retorna o elemento na posição determinada
    public T buscaPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        return this.elementos[posicao];
    }

    // Verifica se o elemento existe no array
    public int buscaElemento(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

	public boolean contem(T elemento){
		
		/*int pos = busca(elemento);
		if (pos > -1){
			return true;
		}
		
		return false;*/
		
		return buscaElemento(elemento) > -1; //>=0
	}

    public void limpar() {
        // Opção 1
        // this.elementos = (T[]) new Object[this.elementos.length];

        // Opção 2
        // this.tamanho = 0;

        // Opção 3
        for (int i = 0; i < this.tamanho; i++) {
            this.elementos[i] = null;
        }
        this.tamanho = 0;
        
    }

    // Como a ideia é encontrar a última ocorrência de um elemento, é melhor começar percorrendo do último índice
    public int ultimoIndice(T elemento) {
        
        for (int i = this.tamanho-1; i >= 0; i--) {
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
