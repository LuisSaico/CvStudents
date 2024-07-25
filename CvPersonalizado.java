
package Clases;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CvPersonalizado {
    
    // Atributos de la clase
    private String idDatosPersonales;
    private String idExperienciaLaboral;
    private String idInformacionContacto;
    
    // Constructor de la clase
    public CvPersonalizado(String _idDatosPersonales, String _idExperienciaLaboral,
            String _idInformacionContacto) {
        
        // Validamos que los campos no esten vacios
         if (_idDatosPersonales == null || _idDatosPersonales.trim().isEmpty() || 
                _idExperienciaLaboral == null || _idExperienciaLaboral.trim().isEmpty() || 
                _idInformacionContacto == null || _idInformacionContacto.trim().isEmpty()){
            throw new IllegalArgumentException("Ningun campo debe de estar vacio");
        }
         
         idDatosPersonales = _idDatosPersonales;
         idExperienciaLaboral = _idExperienciaLaboral;
         idInformacionContacto = _idInformacionContacto;    
    }
    
    // Get para Datos Personales
    public String getIdDatosPersonales(){
        return idDatosPersonales;
    }
    
    // Get para Experiencia Laboral
    public String getIdExperienciaLaboral(){
        return idExperienciaLaboral;
    }
    
    // Get para Informacion Contacto
    public String getIdInformacionContacto(){
        return idInformacionContacto;
    }
    
    // Metodo para leer los ID de los archivos
    public String leerDatos(String archivo, String id) throws IOException{
        
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea = reader.readLine()) != null){
                
                if(linea.startsWith("ID: " + id)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(linea).append("\n");
                    while((linea = reader.readLine()) != null && !linea.equals("--------------------")){
                        sb.append(linea).append("\n");
                    }
                    
                    return sb.toString();
                }
            }
        }
        
        return "";
    }
    
    // Metodo para obtener el nombre y personalizarlo en el archivo
    public String obtenerNombre() throws IOException{
        
        String datosPersonales = leerDatos("datosPersonales.txt", idDatosPersonales);
        String[] lineas = datosPersonales.split("\n");
        for (String linea : lineas){
            if(linea.startsWith("Nombre: ")){
                return linea.substring("Nombre: ".length()).trim();
            }
        }
        
        return "Sin Nombre";
    }
    
    // Metodo para generar el archivo independiente
    public void generarCv() throws IOException{
        
        String datosPersonales = leerDatos("datosPersonales.txt", idDatosPersonales);
        String experienciaLaboral = leerDatos("experienciaLaboral.txt", idExperienciaLaboral);
        String informacionContacto = leerDatos("informacionContacto.txt", idInformacionContacto);
        
        String nombreCompleto = obtenerNombre();
        String nombreArchivo = nombreCompleto.replace("\\s+", "_");
        try(FileWriter writer = new FileWriter(nombreArchivo +".txt")){
            writer.write("Curriculum Vitae");
            writer.write("--------------------\n");
            writer.write("Datos Personales");
            writer.write(datosPersonales);
            writer.write("--------------------\n");
            writer.write("Experiencia Laboral");
            writer.write(experienciaLaboral);
            writer.write("--------------------\n");
            writer.write("Informacion Contacto");
            writer.write(informacionContacto);
            writer.write("--------------------\n");
                      
        }
    }
}