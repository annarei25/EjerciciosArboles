import java.util.List;
import java.util.ArrayList;

public class Node<E> {
    E dato;
    Node<E> padre;
    List<Node<E>> listaHijos;

    public Node(E dato) {
        this.dato = dato;
        this.padre=null;
        this.listaHijos=new ArrayList<>();
    }

    public void agregarHijo(Node<E> hijo){
        listaHijos.add(hijo);

    }

    public Node<E> getPadre() {
        return padre;
    }

    public void setPadre(Node<E> padre) {
        this.padre = padre;
    }

    public boolean tieneHijos(){
        return !listaHijos.isEmpty();
    }

    public int cantHijos(){
        return listaHijos.size();
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public List<Node<E>> getListaHijos() {
        return listaHijos;
    }

    public void setListaHijos(List<Node<E>> listaHijos) {
        this.listaHijos = listaHijos;
    }
}
