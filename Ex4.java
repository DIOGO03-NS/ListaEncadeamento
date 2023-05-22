public class Ex4 {
    Celula primeira;
    Celula ultima;
    int totalElementos = 0;

    //a. contar o número de elementos numa lista circular;
    int tamanho(){
        int tamanho = 0;
        Celula elemento = this.primeira;
        while(true){
            if(elemento.equals(this.ultima)){
                break;
            }else{
                tamanho++;
            }
        }
        return tamanho;
    }

    //b. inserir um elemento à esquerda da cabeça da lista;
    void adicionaComeco(Object elemento){
        if(this.totalElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = primeira; 
        }else{
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
            this.ultima.setProxima(primeira);
        }
        this.totalElementos++; 
    }

    //c. concatenar duas listas circulares;
    public ListaEncadeadaCircular concatenar(ListaEncadeadaCircular lista1, ListaEncadeadaCircular lista2){
        for(int i = 0; i < lista2.tamanho(); i++){
            lista1.adiciona(lista2.pega(i));
        }
        return lista1;
    }

    //d. intercalar duas listas ordenadas; 


    //e. fazer uma cópia da lista;
    public ListaEncadeadaCircular copiar(ListaEncadeadaCircular lista){
        ListaEncadeadaCircular aux = new ListaEncadeadaCircular();
        for(int i = 0; i < this.tamanho(); i++){
            aux.adiciona(i, lista.pegaCelula(i));
        }
        return aux;
    }
}