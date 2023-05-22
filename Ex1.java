public class Ex1 {
    public ListaDupla concatenar(ListaDupla l1, ListaDupla l2){
        for(int i = 0; i < l2.tamanho(); i++){
            l1.adiciona(l2.pega(i));
        }
        return l1;
    }

    public ListaDupla[] separa(ListaDupla lista, int posicao){
        ListaDupla lista2 = new ListaDupla();
        for(int i= 0; i < posicao; i++){
            lista2.adiciona(lista.pega(0));
            lista.removeInicio();
        }
        ListaDupla[] listas = new ListaDupla[1];
        listas[0] = lista;
        listas[1] = lista2;
        return listas;
    }

    
}
