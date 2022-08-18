package clases;

public class Empleado {
    //Atributos 
    private int id;
    private String nombre;
    private String apellido;
    private int horasExtra;
    private boolean auxilioTransporte;
    private int salario;
    private int bonoDic;
    
    //Constructores

    public Empleado(String nombre, String apellido, int horasExtra, boolean auxilioTransporte, int salario, int bonoDic) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasExtra = horasExtra;
        this.auxilioTransporte = auxilioTransporte;
        this.salario = salario;
        this.bonoDic = bonoDic;
    }
    

    public Empleado() {
    }
    
    
    //set y get
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public boolean isAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(boolean auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getBonoDic() {
        return bonoDic;
    }

    public void setBonoDic(int bonoDic) {
        this.bonoDic = bonoDic;
    }

    
    
    //metodo logica del negocio

    
    

    

    
}
