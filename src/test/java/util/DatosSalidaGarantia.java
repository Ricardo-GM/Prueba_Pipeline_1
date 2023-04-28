package util;

public class DatosSalidaGarantia {

    private final String tipoBusqueda;
    private final String numeroDocumento;
    private final String garantia;
    private final String motivo;

    private final int numeroFila;

    public DatosSalidaGarantia(String tipoBusqueda, String numeroDocumento, String garantia, String motivo, int numeroFila) {
        this.tipoBusqueda = tipoBusqueda;
        this.numeroDocumento = numeroDocumento;
        this.garantia = garantia;
        this.motivo = motivo;
        this.numeroFila = numeroFila;
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

    public int getNumeroFila() {
        return numeroFila;
    }


}
