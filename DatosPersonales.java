
package Clases;

// Importando librerias
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class DatosPersonales {
    
    // Atributos de la clase
    private String id;
    private String cedula;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String fechaNacimiento;
    private String nacionalidad;
    private String estadoCivil;
    private String objetivoProfesional;
    
    // Constructor de la clase
    public DatosPersonales(String _id, String _cedula, String _nombre,
            String _direccion, String _correoElectronico, String _fechaNacimiento,
            String _nacionalidad, String _estadoCivil, String _objetivoProfesional){
        
        // Validamos que los campos no esten vacios
        if (_id == null || _id.trim().isEmpty() || 
                _cedula == null || _cedula.trim().isEmpty() || 
                _nombre == null || _nombre.trim().isEmpty() ||
                _direccion == null || _direccion.trim().isEmpty() || 
                _correoElectronico == null || _correoElectronico.trim().isEmpty() ||
                _fechaNacimiento == null || _fechaNacimiento.trim().isEmpty() || 
                _nacionalidad == null || _nacionalidad.trim().isEmpty() || 
                _estadoCivil == null || _estadoCivil.trim().isEmpty() || 
                _objetivoProfesional == null || _objetivoProfesional.trim().isEmpty()){
            throw new IllegalArgumentException("Ningun campo debe de estar vacio");
        }
        
        
        id = _id;
        cedula = _cedula;
        nombre = _nombre;
        direccion = _direccion;
        correoElectronico = _correoElectronico;
        fechaNacimiento = _fechaNacimiento;
        nacionalidad = _nacionalidad;
        estadoCivil = _estadoCivil;
        objetivoProfesional = _objetivoProfesional;
    }
    
    // Get de id
    public String getId(){
        return id;
    }
    
    // Get de cedula
    public String getCedula(){
        return cedula;
    }
    
    // Get de nombre
    public String getNombre(){
        return nombre;
    }
    
    // Get de direccion
    public String getDireccion(){
        return direccion;
    }
    
    // Get de Correo electronico
    public String getCorreoElectronico(){
        return correoElectronico;
    }
    
    // Get fecha de nacimiento
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    // Get de nacionalidad
    public String getNacionalidad(){
        return nacionalidad;
    }
    
    // Get de estado civil
    public String getEstadoCivil(){
        return estadoCivil;
    }
    
    // Get de objetivo profesional
    public String getObjetivoProfesional(){
        return objetivoProfesional;
    }
    
    // Metodo que escribira en el archivo
    public void escribirArchivoDatos(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("datosPersonales.txt", true))){
            
            // Escribiendo en el archivo
            writer.write("ID: "+id+"\n");
            writer.write("Cedula: "+cedula+"\n");
            writer.write("Nombre: "+nombre+"\n");
            writer.write("Direccion: "+direccion+"\n");
            writer.write("Correo electronico: "+correoElectronico+"\n");
            writer.write("Fecha de Nacimiento: "+fechaNacimiento+"\n");
            writer.write("Nacionalidad: "+nacionalidad+"\n");
            writer.write("Estado Civil: "+estadoCivil+"\n");
            writer.write("Objetivo profesional: "+objetivoProfesional+"\n");
            writer.write("--------------------"+"\n");
            
        } catch(IOException mensaje){
            System.err.println("Error al guardar la informacion"+mensaje.getMessage());
        }
    }
    
}
