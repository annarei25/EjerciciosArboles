public class Node<E> {
    private E dato;
    private Node<E> izquierdo;
    private Node<E> derecho;
    private Node<E> padre;

    public Node(E dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        this.padre=null;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Node<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Node<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Node<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(Node<E> derecho) {
        this.derecho = derecho;
    }

    public Node<E> getPadre() {
        return padre;
    }

    public void setPadre(Node<E> padre) {
        this.padre = padre;
    }
}

