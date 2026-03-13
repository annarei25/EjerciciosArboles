import java.util.List;

public class Main {
    public static void main(String[] args) {

        //raiz
        Node<Persona> persona1 = new Node<>(new Persona("Juan", 12,12,1943, 'M'));

        //hijos de juan
        Node<Persona> persona2 = new Node<>(new Persona("Pepe", 23,2,1967,'M'));

        Node<Persona> persona3 = new Node<>(new Persona("Ana", 3,4,1970,'F'));

        //hijos de pepe

        Node<Persona> persona4 = new Node<>(new Persona("Sandra", 5,5,1990,'F'));

        Node<Persona> persona5 = new Node<>(new Persona("Kike", 12,7,1993,'M'));

        //hijos de Ana

        Node<Persona> persona6 = new Node<>(new Persona("Maria", 13,6,1995,'F'));

        Node<Persona> persona7 = new Node<>(new Persona("Jose", 15,7,1997,'M'));

        Node<Persona> persona8 = new Node<>(new Persona("Sofia", 5,5,1999,'F'));

        //hijo de kike

        Node<Persona> persona9 = new Node<>(new Persona("Ernesto", 10,10,2010,'M'));

        //hija de maria

        Node<Persona> persona10 = new Node<>(new Persona("Julia", 8,5,2015,'F'));


        ArbolGeneral<Persona> miArbol = new ArbolGeneral<>(persona1);

        ControlArbol controlArbol=new ControlArbol(miArbol);

        // Insertar hijos de Juan
        controlArbol.insertar(persona1,persona2);
        controlArbol.insertar(persona1, persona3);

        // Insertar hijos de Pepe
        controlArbol.insertar(persona2, persona4);
        controlArbol.insertar(persona2, persona5);

        // Insertar hijos de Ana
        controlArbol.insertar(persona3, persona6);
        controlArbol.insertar(persona3, persona7);
        controlArbol.insertar(persona3, persona8);

        // Insertar hijo de Kike
        controlArbol.insertar(persona5, persona9);

        // Insertar hija de Maria
        controlArbol.insertar(persona6, persona10);

        List<Persona> antepasados = controlArbol.antepasados(persona10);

        int cont=0;

        if (antepasados!=null){
            System.out.println("Linea de antepasados de " + persona10.getDato().getNombre());
            for (Persona persona:antepasados){
                System.out.println(cont+1 + "- " + persona.getNombre());
                cont++;
            }
        }

        System.out.println();
        controlArbol.descendientes(persona1);

        //controlArbol.eliminarRamaFamiliar(persona2);

        //miArbol.recorridoBFS();

        System.out.println();
        controlArbol.recorridoPorGeneraciones();

        int altura = controlArbol.calcularAltura(persona1);
        System.out.println("La altura es " + altura);

    }
}
