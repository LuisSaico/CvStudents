
package Clases;

// Importando librerias
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class InformacionContacto{
    
    // Atributos adicionales
    private String id;
    private String telefono;
    private String direccionCorreo;
    private String pais;
    private String ciudad;
    private String codigoPostal;
    
    // Constructor de la clase
    public InformacionContacto(String _id, String _telefono, String _direccionCorreo, String _pais, String _ciudad,
            String _codigoPostal) {
        
        // Validamos que los campos no esten vacios
         if (_id == null || _id.trim().isEmpty() || 
                _telefono == null || _telefono.trim().isEmpty() || 
                _direccionCorreo == null || _direccionCorreo.trim().isEmpty() ||
                _pais == null || _pais.trim().isEmpty() || 
                _ciudad == null || _ciudad.trim().isEmpty() ||
                _codigoPostal == null || _codigoPostal.trim().isEmpty()){
            throw new IllegalArgumentException("Ningun campo debe de estar vacio");
        }
         
        id = _id;
        telefono = _telefono;
        direccionCorreo = _direccionCorreo;
        pais = _pais;
        ciudad = _ciudad;
        codigoPostal = _codigoPostal;
        
    }
    
    // Get de Id
    public String getId(){
        return id;
    }
    
    // Get de Telefono
    public String getTelefono(){
        return telefono;
    }
    
    // Get de Direccion Correo
    public String getDireccionCorreo(){
        return direccionCorreo;
    }
    
    //Get de pais
    public String getPais(){
        return pais;
    }
    
    // Get de Ciudad
    public String getCiudad(){
        return ciudad;
    }
    
    // Get de Codigo Postal
    public String getCodigoPostal(){
        return codigoPostal;
    }
    
    // Metodo para escribir en archivo
    public void escribirArchivoContacto(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("informacionContacto.txt", true))){
           
            // Escribiendo en el archivo
            writer.write("ID: "+id+"\n");
            writer.write("Telefono: "+telefono+"\n");
            writer.write("Direccion correo: "+direccionCorreo+"\n");
            writer.write("Pais: "+pais+"\n");
            writer.write("Ciudad: "+ciudad+"\n");
            writer.write("Codigo Postal: "+codigoPostal+"\n");
            writer.write("--------------------"+"\n");
            
        } catch(IOException mensaje){
            System.err.println("Error al guardar la informacion"+mensaje.getMessage());
        }
    }
    
       
}
