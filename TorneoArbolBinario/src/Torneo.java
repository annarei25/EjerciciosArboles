public class Torneo {
    String equipo1;
    String equipo2;
    String ganador;
    String ronda;

    public Torneo(String ronda, String equipo1, String equipo2 ) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ronda = ronda;
        this.ganador=null;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "equipo1='" + equipo1 + '\'' +
                ", equipo2='" + equipo2 + '\'' +
                ", ganador='" + ganador + '\'' +
                ", ronda='" + ronda + '\'' +
                '}';
    }
}
