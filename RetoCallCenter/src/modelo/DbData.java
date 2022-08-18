package modelo;

public class DbData {
    // Atributos
    private String driver = "com.mysql.jdbc.Driver"; // cadena de conexión entre el aplicativo para configurar el servicio
    private String user = "root"; // usuario de la base de datos
    private String password = ""; // contraseña del usuario
    private String url = "jdbc:mysql://localhost:3306/sistema_nomina"; // referencia con cuál base da datos se va aconectar
    
    // Get
    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
    
    
}
