public class GestionTorneo {
    ArbolBinario<Torneo> arbolBinario;

    public GestionTorneo(ArbolBinario<Torneo> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

        // 2. Simulación de Partidos
        public void simularTorneo() {
            recorrerYSimular(arbolBinario.getRaiz());
            System.out.println("\n🏆 ¡El Campeón del torneo es: " + arbolBinario.raiz.getDato().ganador + " ! 🏆");
        }

        private void recorrerYSimular(Node<Torneo> nodo) {
            if (nodo == null) return;

            recorrerYSimular(nodo.getIzquierdo());
            recorrerYSimular(nodo.getDerecho());
            simularRonda(nodo);
        }

        private void simularRonda(Node<Torneo> nodo) {
            Torneo torneo = nodo.getDato();

            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                torneo.setEquipo1(nodo.getIzquierdo().getDato().getGanador());
                torneo.setEquipo2(nodo.getDerecho().getDato().getGanador());
            }

            if (Math.random() < 0.5) {
                torneo.setGanador(torneo.getEquipo1());
            } else {
                torneo.setGanador(torneo.getEquipo2());
            }
        }

        public void mostrarBracket() {
            System.out.println("\n--- Bracket del Torneo ---");
            mostrarNodo(arbolBinario.raiz, "");
        }

        private void mostrarNodo(Node<Torneo> nodo, String prefijo) {
            if (nodo == null) return;

            Torneo t = nodo.getDato();
            System.out.println(prefijo + t.ronda + ": " + t.equipo1 + " vs " + t.equipo2 + " -> Ganador: " + t.ganador);

            mostrarNodo(nodo.getIzquierdo(), prefijo + "    ");
            mostrarNodo(nodo.getDerecho(), prefijo + "    ");
        }
    }

