package modelo;

import clases.Empleado;
import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;

public class modelEmpleado extends DbData {
    
    public Empleado consultaEmpleado(String id){
        Empleado emp = null;
        
        try (Connection connection = DriverManager.getConnection(getUrl(), getUser(), getPassword())){
            String query = "SELECT * FROM `tb_empleado` WHERE id = ?"; // Consulta preparada
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet resul = stmt.executeQuery();
            while (resul.next()) {                    
                int empId = resul.getInt(1);
                String nombre = resul.getString(2);
                String apellido = resul.getString(3);
                int vlrHoraExtra = resul.getInt(4);
                String auxTransp = resul.getString(5);
                int salario = resul.getInt(6);  
                int bonoDic = resul.getInt(7);
                
                System.out.println("ID empleado: " + empId +
                                    "\nNombre empleado: " + nombre +
                                    "\nApellido empleado: " + apellido +
                                    "\nHoras extras: " + vlrHoraExtra +
                                    "\nAuxilio de Transporte: " + auxTransp +
                                    "\nSalario: " + salario +
                                    "\nBono de diciembre: " + bonoDic);
                System.out.println("");
                
                //mostrarDatos(empId, nombre, vlrHoraExtra, auxTransp, salario, bonoDic);
                
                switch (auxTransp) {
                    case "TRUE" -> emp = new Empleado(nombre, apellido, vlrHoraExtra, true, salario, bonoDic);
                    case "FALSE" -> emp = new Empleado(nombre, apellido, vlrHoraExtra, false, salario, bonoDic);
                    default -> throw new AssertionError();
                }
            }                                  
            
            return emp;   
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return emp;
    }
    
    public boolean crearEmpleado(String nombre, String apellido, int vlrHoraExtra, boolean auxTransp, int salario){
        
        try(Connection connection = DriverManager.getConnection(getUrl(), getUser(), getPassword())) {
            
            String aux_transp;
            
            if(auxTransp){
                aux_transp = "TRUE";
            }else{
                aux_transp = "FALSE";
            }
            String query = "INSERT INTO `tb_empleado`(`nombre`, `apellido`, `horas_extra`, `aux_transp`, `salario`) "
                         + "VALUES (?,?,?,?,?)";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setInt(3, vlrHoraExtra);
            stmt.setString(4, aux_transp);
            stmt.setInt(5, salario);
            
            stmt.executeUpdate();
            stmt.close();
             
            return true;
        } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
        }  
        return false;
    }
}
