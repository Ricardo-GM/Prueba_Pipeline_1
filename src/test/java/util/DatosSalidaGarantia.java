package util;

public class DatosSalidaGarantia {

    private final String tipoBusqueda;
    private final String numeroDocumento;
    private final String garantia;
    private final String motivo;

    public DatosSalidaGarantia(String tipoBusqueda, String numeroDocumento, String garantia, String motivo) {
        this.tipoBusqueda = tipoBusqueda;
        this.numeroDocumento = numeroDocumento;
        this.garantia = garantia;
        this.motivo = motivo;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getGarantia() {
        return garantia;
    }

    public String getMotivo() {
        return motivo;
    }
}
