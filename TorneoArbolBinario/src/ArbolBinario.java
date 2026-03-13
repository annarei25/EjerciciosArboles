public class ArbolBinario<E> {
    Node<E> raiz;

    public ArbolBinario(Node<E> raiz) {
        this.raiz = raiz;
    }

    public void insertarNodo(Node<E> padre, Node<E> nuevo, boolean esIzquierdo) {
        Node<E> encontrado = buscar(padre);
        if (padre != null) {
            if (esIzquierdo) {
                padre.setIzquierdo(nuevo);
            } else {
                padre.setDerecho(nuevo);
            }
        }
    }

    public void modificarNodo(Node<E> nodoModificar, Node<E> nuevo){
        Node<E> encontrado = buscar(nodoModificar);
        if (encontrado != null) {
            encontrado.setDato(nuevo.getDato());
        }else{
            System.out.println("Nodo no encontrado");
            }
        }
    

    public void eliminar(Node<E> padre, boolean eliminarIzquierdo) {
        Node<E> encontrado = buscar(padre);
        if (encontrado != null) {
            if (eliminarIzquierdo) encontrado.setIzquierdo(null);
            else encontrado.setDerecho(null);
        }
    }

    public ArbolBinario<E> obtenerSubarbol(Node<E> raiz) {
        Node<E> nuevaRaiz = buscar(raiz);
        if (nuevaRaiz != null) {
            ArbolBinario<E> nuevoArbol = new ArbolBinario<>(nuevaRaiz);
            nuevoArbol.raiz = nuevaRaiz;
            return nuevoArbol;
        }
        return null;
    }

    public void preorden(Node<E> nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getDato() + " ");
        preorden(nodo.getIzquierdo());
        preorden(nodo.getDerecho());
    }

    public void inorden(Node<E> nodo) {
        if (nodo == null) return;
        inorden(nodo.getIzquierdo());
        System.out.print(nodo.getDato() + " ");
        inorden(nodo.getDerecho());
    }

    public void postorden(Node<E> nodo) {
        if (nodo == null) return;
        postorden(nodo.getIzquierdo());
        postorden(nodo.getDerecho());
        System.out.print(nodo.getDato() + " ");
    }

    public Node<E> buscar(Node<E> nodo) {
        return buscarRecursivo(raiz, nodo);
    }

    private Node<E> buscarRecursivo(Node<E> actual,Node<E> buscar) {
        if (actual == null) return null;
        if (actual.getDato().equals(buscar.getDato())) return actual;

        Node<E> encontrado = buscarRecursivo(actual.getIzquierdo(), buscar);
        if (encontrado != null) return encontrado;
        return buscarRecursivo(actual.getDerecho(), buscar);
    }

    public Node<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Node<E> raiz) {
        this.raiz = raiz;
    }
}
