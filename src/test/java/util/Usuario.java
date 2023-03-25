package util;

public class Usuario {

    private final String tipoUsuario;
    private final String username;
    private final String password;

    public Usuario(String tipoUsuario, String username, String password) {
        this.tipoUsuario = tipoUsuario;
        this.username = username;
        this.password = password;
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
