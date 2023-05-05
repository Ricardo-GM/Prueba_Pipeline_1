package util;

public enum LoginUser {

    VALID_USER("tomsmith", "SuperSecretPassword!"),
    VALIDD_USER("mcano@intercorp.com.pe", "Interbank##2023"),
    INVALID_USER("foobar", "foobar");

    public final String username;
    public final String password;

    LoginUser(String username, String password){
        this.password = password;
        this.username = username;
    }
}
