package models;

public class DatosInmueble {
    private final String torre;
    private final String apartamento;
    private final String area;
    private final String cedulaPropietario;

    public DatosInmueble(String torre, String apartamento, String area, String cedulaPropietario) {
        this.torre = torre;
        this.apartamento = apartamento;
        this.area = area;
        this.cedulaPropietario = cedulaPropietario;
    }

    public String getTorre() { return torre; }
    public String getApartamento() { return apartamento; }
    public String getArea() { return area; }
    public String getCedulaPropietario() { return cedulaPropietario; }

    // Identificador unico, por ejemplo T2-202
    public String getIdentificador() { return "T" + torre + "-" + apartamento; }
}