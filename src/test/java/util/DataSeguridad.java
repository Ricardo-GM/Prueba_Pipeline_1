package util;

public class DataSeguridad {

    private final String claseDocumental;
    private final String categoria;
    private final String grupo;

    public DataSeguridad(String claseDocumental, String categoria, String grupo) {
        this.claseDocumental = claseDocumental;
        this.categoria = categoria;
        this.grupo = grupo;
    }
    public String getClaseDocumental() {
        return claseDocumental;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getGrupo() {
        return grupo;
    }
}