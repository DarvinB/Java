package retocallcenter;

import clases.*;
import java.util.ArrayList;
import modelo.modelEmpleado;

public class PruebaRetoCallCenter {

    public static void main(String[] args) {
        CallCenter liquidacion = new CallCenter();
        
        ArrayList<Double> nominas = new ArrayList<>();
        ArrayList<Empleado> listEmpleado = new ArrayList<>();
        ArrayList<Double> prestaciones = new ArrayList<>();
        
        //Instancias de empleados
        
        Empleado empleado0 = new Empleado();
        listEmpleado.add(empleado0);
        
        Empleado empleado1 = new Empleado("Carmen", "Ortega", 40000, true, 1500000, 500000);
        listEmpleado.add(empleado1);
        
        Empleado empleado2 = new Empleado("Pablo", "Mendez", 25000, true, 1200000, 500000);
        listEmpleado.add(empleado2);
        
        Empleado empleado3 = new Empleado("Laura", "Perez", 50000, false, 2000000, 500000);
        listEmpleado.add(empleado3);
        
        // Consulta de Empleados por Id desde la base de datos
        modelEmpleado empleado4 = new modelEmpleado();
        if(empleado4.consultaEmpleado("1") != null){
            listEmpleado.add(empleado4.consultaEmpleado("1"));
        }                        
        
        System.out.println("Liquidacion de Nominas: ");
        nominas = liquidacion.liquidarNominaEmp(listEmpleado);
        
        for (int i = 0; i < nominas.size(); i++) {
            System.out.println("Nombre: " + listEmpleado.get(i).getNombre() + " " + listEmpleado.get(i).getApellido() + " Total a pagar: " + Math.round(nominas.get(i)));
            
        }
        System.out.println("Prestaciones Sociales");
        prestaciones = liquidacion.liquidarPrestacionesEmp(listEmpleado);
        
        for (int i = 0; i < prestaciones.size(); i++) {
            System.out.format("\nNombre: " + listEmpleado.get(i).getNombre() + " " + listEmpleado.get(i).getApellido() + " Total a pagar: %.2f", prestaciones.get(i));
            
        } 
    } 
}
