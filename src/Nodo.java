public class Nodo {
    private int Id = 0;
    private int conexion = 0;
    private int[] tiempos = new int[3];

    public Nodo() {
    }

    public Nodo(int id, int conexion, int[] tiempos) {
        Id = id;
        this.conexion = conexion;
        this.tiempos = tiempos;
    }

    public int getConexion() {
        return conexion;
    }

    public void setConexion(int conexion) {
        this.conexion = conexion;
    }

    public int[] getTiempos() {
        return tiempos;
    }

    public void setTiempos(int[] tiempos) {
        this.tiempos = tiempos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

