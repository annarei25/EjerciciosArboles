import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArbolGeneral<E>{
    Node<E> raiz;

    public ArbolGeneral(Node<E> raiz) {
        this.raiz = raiz;
    }

    public Node<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Node<E> raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty(){
        return raiz==null;
    }


    public void insertarNodo(Node<E> nodoPadre, Node<E> nodoHijo){
        Node<E> nodoEncontrar = buscarNodo(nodoPadre);
        if (nodoPadre !=null){
            nodoPadre.getListaHijos().add(nodoHijo);
            nodoHijo.setPadre(nodoPadre);
        }else {
            System.out.println("No existe el nodo");
        }
    }

    public void modificarNodo(Node<E> nodoModificar, Node<E> nuevo){
        Node<E> nodoEncontrar = buscarNodo(nodoModificar);
        if (nodoEncontrar == null) {
            System.out.println("No existe el nodo");
        }else {
            nodoEncontrar.setDato(nuevo.dato);
        }
    }

    public void eliminarNodo(Node<E> nodoPadre, Node<E> nodoEliminar){
        Node<E> nodoEncontrar = buscarNodo(nodoPadre);
        if (nodoEncontrar == null) {
            System.out.println("No existe el nodo");
        }else {
            nodoEncontrar.getListaHijos().remove(nodoEliminar);
        }
    }

    public Node<E> buscarNodo(Node<E> nodo){
        return buscarRecursivo(raiz, nodo);
    }

    public Node<E> buscarRecursivo(Node<E> actual, Node<E> nodoBuscar) {
        if (actual == null) return null;
        if (actual.getDato().equals(nodoBuscar.getDato())) return actual;

        for (Node<E> hijo: actual.getListaHijos()){
            Node<E> encontrado = buscarRecursivo(hijo, nodoBuscar);
            if (encontrado != null){
                return encontrado;
            }
        }
        return null;

    }

    public ArbolGeneral<E> obtenerSubarbol(Node<E> raizSubarbol) {
        Node<E> nuevaRaiz = buscarNodo(raizSubarbol);

        if (nuevaRaiz != null) {
            ArbolGeneral<E> subarbol = new ArbolGeneral<>(raizSubarbol);
            subarbol.raiz = nuevaRaiz;
            System.out.println("Subárbol con raíz '" + raizSubarbol.getDato() + "' obtenido exitosamente.");
            return subarbol;
        } else {
            System.out.println("No se pudo obtener el subárbol. No se encontró el nodo '" + raizSubarbol.getDato() + "'.");
            return null;
        }
    }

    public void recorridoBFS() {
        if (raiz == null) return;

        Queue<Node<E>> cola = new LinkedList<>();
        cola.add(raiz);

        System.out.print("Recorrido BFS: ");
        while (!cola.isEmpty()) {
            Node<E> nodoActual = cola.poll();
            System.out.print(nodoActual.getDato() + " -> ");

            cola.addAll(nodoActual.getListaHijos());
        }
    }

    public void recorridoDFS() {
        if (raiz == null) return;

        Stack<Node<E>> pila = new Stack<>();
        pila.push(raiz);

        System.out.print("Recorrido DFS : ");
        while (!pila.isEmpty()) {
            Node<E> nodoActual = pila.pop();
            System.out.print(nodoActual.getDato().toString() + " -> ");

            List<Node<E>> hijos = nodoActual.getListaHijos();

            for (int i = hijos.size() - 1; i >= 0; i--) {
                pila.push(hijos.get(i));
            }
        }
    }

}
