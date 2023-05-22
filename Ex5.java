public class Ex5 {
    public class ListaDuplaCabeca {
        public class ListaEncadeadaCircular {
            Celula primeira;
            Celula ultima;
            Celula cabeca;
            int totalElementos = 0;
        
            boolean posicaoOcupada(int posicao){
                return((posicao >= 0) && (posicao < this.totalElementos - 1));
            }
        
            Celula pegaCelula(int posicao){
                if(!this.posicaoOcupada(posicao)){
                    throw new IllegalArgumentException("POSICAO NAO EXISTE");
                }else{
                    Celula atual = this.primeira;
                    for(int i = 0; i < posicao; i++){
                        atual = atual.getProxima();
                    }
                    return atual; 
                }
            }
        
            Object pega(int posicao){
                return(this.pegaCelula(posicao).getElemento());
            }
        
            void adicionaComeco(Object elemento){
                if(this.totalElementos == 0){
                    Celula nova = new Celula(elemento);
                    this.primeira = nova;
                    this.ultima = primeira; 
                }else{
                    Celula nova = new Celula(this.primeira, elemento);
                    this.primeira.setAnterior(nova);
                    this.primeira = nova;
                    this.ultima.setProxima(cabeca);
                    this.primeira.setAnterior(cabeca);
                    this.cabeca.setAnterior(ultima);
                    this.cabeca.setProxima(primeira);
                }
                this.totalElementos++; 
            }
        
            void adicionaFim(Object elemento){
                if(this.totalElementos == 0){
                    this.adicionaComeco(elemento);
                }else{
                    Celula penultima = this.ultima;
                    Celula ultima = new Celula(elemento);
                    penultima.setProxima(ultima);
                    this.ultima = ultima;
                    this.ultima.setProxima(cabeca);
                    this.primeira.setAnterior(cabeca);
                    this.cabeca.setAnterior(ultima);
                    this.cabeca.setProxima(primeira);
                    this.totalElementos++;
                }
            }
        
            void adiciona(Object elemento){
                if(this.totalElementos == 0){
                    this.adicionaComeco(elemento);
                }else{
                    Celula nova = new Celula(elemento);
                    this.ultima.setProxima(nova);
                    nova.setAnterior(this.ultima);
                    nova.setProxima(cabeca);
                    this.primeira.setAnterior(cabeca);
                    this.cabeca.setAnterior(nova);
                    this.cabeca.setProxima(primeira);
    
                    this.ultima = nova;
                    this.totalElementos++;
                }
            }
        
            void adiciona(int posicao, Object elemento){
                if(posicao == 0){
                    this.adicionaComeco(elemento);
                }else if(posicao == this.totalElementos){
                    this.adiciona(elemento);
                }else{
                    Celula anterior = this.pegaCelula(posicao--);
                    Celula proxima = anterior.getProxima();
                    Celula nova = new Celula(anterior.getProxima(), elemento);
                    nova.setAnterior(anterior);
                    anterior.setProxima(nova);
                    if(!(proxima == null)){
                        proxima.setAnterior(nova);
                    }
                    this.totalElementos++;
                }
            } 
        
            void removeInicio(){
                if(!this.posicaoOcupada(0)){
                    throw new IllegalArgumentException("POSICAO NAO EXISTE");
                }else{
                    this.primeira = this.primeira.getProxima();
                    this.cabeca.setProxima(primeira);
                    this.totalElementos--;
                }
            }
        
            void removeFim(){
                if(!this.posicaoOcupada(totalElementos--)){
                    throw new IllegalArgumentException("POSICAO NAO EXISTE");
                }else if(this.totalElementos == 1){
                    this.removeInicio();
                }else{
                    Celula penultima = this.ultima.getAnterior();
                    this.ultima = penultima;
                    this.ultima.setProxima(cabeca);
                    this.totalElementos--;
                }
            }
        
            void remove(int posicao){
                if(!this.posicaoOcupada(posicao)){
                    throw new IllegalArgumentException("POSICAO JA VAZIA");
                }else if(posicao == 0){
                    this.removeInicio();
                }else if(posicao == this.totalElementos -1){
                    this.removeFim();
                }else{
                    Celula anterior = this.pegaCelula(posicao--);
                    Celula atual = anterior.getProxima();
                    Celula proxima = atual.getProxima();
                    anterior.setProxima(proxima);
                    proxima.setAnterior(anterior);
                    this.totalElementos--;
                }
            }
        
            boolean contem(Object elemento){
                Celula atual = this.primeira;
        
                for(int i = 0; i < this.tamanho(); i++){
                    if(atual.getElemento().equals(elemento)){
                        return true;
                    }
                    atual = atual.getProxima();
                }
                return false;
            }
        
            int tamanho(){
                return this.totalElementos;
            }
        
            void esvaziarLista(){
                this.primeira = null;
                this.ultima = null;
                this.totalElementos = 0;
            }
        
            String Imprimir(){
                if(this.totalElementos == 0){
                    return("[]");
                }else{
                    StringBuilder builder = new StringBuilder("[");
                    Celula atual = this.primeira;
                    for(int i=0; i < this.totalElementos -1; i++){
                        builder.append(atual.getElemento());
                        builder.append(", ");
                        atual = atual.getProxima();
                    }
                    builder.append(atual.getElemento());
                    builder.append("]");
                    return(builder.toString());
                } 
            }
        }
        
    }

}
