public class Main {
    public static void main(String[] args) {

        Node<Torneo> qf1 = new Node<>(new Torneo("QF1", "EquipoA", "EquipoB"));
        Node<Torneo> qf2 = new Node<>(new Torneo("QF2", "EquipoC", "EquipoD"));
        Node<Torneo> qf3 = new Node<>(new Torneo("QF3", "EquipoE", "EquipoF"));
        Node<Torneo> qf4 = new Node<>(new Torneo("QF4", "EquipoG", "EquipoH"));

        Node<Torneo> semi1 = new Node<>(new Torneo("Semi1", null, null));
        semi1.setIzquierdo(qf1);
        semi1.setDerecho(qf2);

        Node<Torneo> semi2 = new Node<>(new Torneo("Semi2", null, null));
        semi2.setIzquierdo(qf3);
        semi2.setDerecho(qf4);

        Node<Torneo> finalMatch = new Node<>(new Torneo("Final", null, null));
        finalMatch.setIzquierdo(semi1);
        finalMatch.setDerecho(semi2);

        ArbolBinario<Torneo> arbolBinario = new ArbolBinario<>(finalMatch);

        GestionTorneo gestion = new GestionTorneo(arbolBinario);

        gestion.simularTorneo();

        gestion.mostrarBracket();
    }
}