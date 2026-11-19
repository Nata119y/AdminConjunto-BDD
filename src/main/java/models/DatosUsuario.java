package models;

public class DatosUsuario {
    private final String nombre;
    private final String documento;
    private final String correo;
    private final String rol;

    public DatosUsuario(String nombre, String documento, String correo, String rol) {
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.rol = rol;
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getCorreo() { return correo; }
    public String getRol() { return rol; }
}