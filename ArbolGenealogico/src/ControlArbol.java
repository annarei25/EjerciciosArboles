import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ControlArbol {
    ArbolGeneral<Persona> arbolGenealogico;

    public ControlArbol(ArbolGeneral<Persona> arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }

    public void insertar(Node<Persona> padre, Node<Persona> hijo){
        arbolGenealogico.insertarNodo(padre,hijo);
    }

    public List<Persona> antepasados(Node<Persona> personaNode){
        List<Persona> antepasadosLista = new ArrayList<>();
        Node<Persona> encontrado = arbolGenealogico.buscarNodo(personaNode);
        if (encontrado != null){
            while (encontrado.getPadre() != null){
                Node<Persona> antepasado = encontrado.getPadre();
                if (antepasado==null){
                    System.out.println("No se encontraron antepasados");
                    break;
                }else {
                    antepasadosLista.add(antepasado.getDato());
                    encontrado = antepasado;
                }
            }
        }else {
            System.out.println("No se encontro el nodo");
            return null;
        }
        return antepasadosLista;
    }

    public void descendientes(Node<Persona> persona) {
        Node<Persona> encontrado = arbolGenealogico.buscarNodo(persona);

        if (encontrado == null) {
            System.out.println("No se encontro la persona");
            return;
        }

        if (encontrado.getListaHijos().isEmpty()) {
            System.out.println(encontrado.getDato().getNombre() + " no tiene descendientes.");
            return;
        }

        Queue<Node<Persona>> cola = new LinkedList<>();

        cola.addAll(encontrado.getListaHijos());

        int numeroGeneracion = 1;
        System.out.println("Listado de descendientes de: " + encontrado.getDato().getNombre());

        while (!cola.isEmpty()) {
            int cantEnCola = cola.size();

            String etiquetaGen;
            switch (numeroGeneracion) {
                case 1: etiquetaGen = "Hijos"; break;
                case 2: etiquetaGen = "Nietos"; break;
                case 3: etiquetaGen = "Bisnietos"; break;
                case 4: etiquetaGen = "Tataranietos"; break;
                default: etiquetaGen = "Generación " + numeroGeneracion;
            }

            System.out.println("\n" + etiquetaGen);

            for (int i = 0; i < cantEnCola; i++) {
                Node<Persona> actual = cola.poll();
                System.out.println("- " + actual.getDato().getNombre());

                if (actual.tieneHijos()) {
                    cola.addAll(actual.getListaHijos());
                }
            }
            numeroGeneracion++;
        }
    }

    public void eliminarRamaFamiliar(Node<Persona> personEliminar) {
        Node<Persona> encontrado = arbolGenealogico.buscarNodo(personEliminar);

        if (encontrado == null) {
            System.out.println("La persona no existe");
            return;
        }
        if (!encontrado.tieneHijos()) {
            System.out.println(encontrado.getDato().getNombre() + " no tiene descendientes, se eliminara solo a " +
                    "el/ella");
        } else {
            System.out.println("Eliminando a " + encontrado.getDato().getNombre() + " y a todos sus descendientes...");
        }

        Node<Persona> padre = encontrado.getPadre();

        if (padre == null) {
            System.out.println("Se está eliminando la raíz. El árbol genealógico quedará completamente vacío.");
            arbolGenealogico.setRaiz(null);
        } else {
            padre.getListaHijos().remove(encontrado);
            System.out.println("La rama de " + encontrado.getDato().getNombre() + " ha sido eliminada con éxito.");
        }
    }

    public int calcularAltura(Node<Persona> actual) {
        if (actual == null) {
            return 0;
        }
        if (!actual.tieneHijos()) {
            return 1;
        }

        int alturaMaximaHijos = 0;

        for (Node<Persona> hijo : actual.getListaHijos()) {
            int alturaHijo = calcularAltura(hijo);

            if (alturaHijo > alturaMaximaHijos) {
                alturaMaximaHijos = alturaHijo;
            }
        }
        return 1 + alturaMaximaHijos;
    }

    public void recorridoPorGeneraciones() {
        Node<Persona> raiz = arbolGenealogico.getRaiz();
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<Node<Persona>> cola = new LinkedList<>();
        cola.add(raiz);

        int nivel = 1;
        System.out.println("Recorrido por Generaciones");

        while (!cola.isEmpty()) {
            int nodosEnNivel = cola.size();
            System.out.print("Generación " + nivel + ": \n");

            for (int i = 0; i < nodosEnNivel; i++) {
                Node<Persona> actual = cola.poll();
                System.out.print(actual.getDato().getNombre() + " \n");

                cola.addAll(actual.getListaHijos());
            }

            System.out.println();
            nivel++;
        }
    }
}
