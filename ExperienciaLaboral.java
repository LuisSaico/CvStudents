
package Clases;

// Importando librerias
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExperienciaLaboral{
    
    // Atributos adicionales de la clase
    private String id;
    private String nombreEmpresa;
    private String puesto;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    // Constructor de la clase
    public ExperienciaLaboral(String _id, String _nombreEmpresa, String _puesto,
            String _fechaInicio, String _fechaFin, String _descripcion) {
        
        
        // Validamos que los campos no esten vacios
         if (_id == null || _id.trim().isEmpty() || 
                _nombreEmpresa == null || _nombreEmpresa.trim().isEmpty() || 
                _puesto == null || _puesto.trim().isEmpty() ||
                _fechaInicio == null || _fechaInicio.trim().isEmpty() || 
                _fechaFin == null || _fechaFin.trim().isEmpty() ||
                _descripcion == null || _descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("Ningun campo debe de estar vacio");
        }
        id = _id;
        nombreEmpresa = _nombreEmpresa;
        puesto = _puesto;
        fechaInicio = _fechaInicio;
        fechaFin = _fechaFin;
        descripcion = _descripcion;  
    }
    
    // Get de Id
    public String getId(){
        return id;
    }
    
    // Get de Nombre Empresa
    public String getNombreEmpresa(){
        return nombreEmpresa;
    }
    
    // Get de Puesto
    public String getPuesto(){
        return puesto;
    }
    
    // Get de Fecha de inicio
    public String getFechaInicio(){
        return fechaInicio;
    }
    
    // Get de Fecha de fin
    public String getFechaFin(){
        return fechaFin;
    }
    
    // Get de Descripcion
    public String getDescripcion(){
        return descripcion;
    }
    
    // Metodo que escribira en el archivo
    public void escribirArchivoExperiencia(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("experienciaLaboral.txt", true))){
            
            // Escribiendo en el archivo
            writer.write("ID: "+id+"\n");
            writer.write("Nombre Empresa: "+nombreEmpresa+"\n");
            writer.write("Puesto: "+puesto+"\n");
            writer.write("Fecha inicio: "+fechaInicio+"\n");
            writer.write("Fecha fin: "+fechaFin+"\n");
            writer.write("Descripcion: "+descripcion+"\n");
            writer.write("--------------------"+"\n");
            
        } catch(IOException mensaje){
            System.err.println("Error al guardar la informacion"+mensaje.getMessage());
        }
    }
    
    
}
