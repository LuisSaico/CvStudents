/*
Nombre del Estudiante: Luis Moreno Castillo
Cedula del estudiante: 118130513
Nombre de la profesora: Jenny Chavarria
Grupo: 2

Referencias:
https://www.udb.edu.sv/udb_files/recursos_guias/informatica-ingenieria/java-avanzado/2019/i/guia-5.pdf
https://www.youtube.com/watch?v=Fc4uFeMXBS8
https://www.youtube.com/watch?v=DAU0rDqcArs
*/
package Clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    
    public static void main(String[] args){
        
        // Lista de los datos
        List<String> datosPersonales = new ArrayList<>();
        List<String> experienciaLaboral = new ArrayList<>();
        List<String> informacionContacto = new ArrayList<>();
        
        // Cargando datos personales de las entidades
        datosPersonales.add("1 118134 Luis LosGuido luisezequiel@gmail"
                + "02/05/2001 costarricense soltero desarollador");
        
        datosPersonales.add("2 1184566 Jamileth Desamparados Jamileth@gmail"
                + "26/11/1980 nicaraguense casada salonera");
        
        datosPersonales.add("3 11848902 Aaron Limon Aaron@gmail"
                + "26/03/1990 colombiano soltero desarrollador web");
        
        // Cargando experiencia laboral de las entidades
        experienciaLaboral.add("1 Patitos programador 12/09/19 15/06/24 programar una base");
        experienciaLaboral.add("2 Patitos cocinera 12/10/12 15/07/16 cocinar productos");
        experienciaLaboral.add("3 Patitos front 12/10/20 15/07/24 desarrollar paginas");
        
        // Cargando Informacion contacto de las entidades
        informacionContacto.add("1 67890 luisezequiel@gmail Costa Rica SanJose 10122");
        informacionContacto.add("2 898900 jamileth@gmail Nicaragua Managua 89450");
        informacionContacto.add("3 789065 Aaron@gmail Colombia Medellin 967845");
        
        // Guardar la Datos personales de las entidades
        DatosPersonales datosPersonalesObj = new DatosPersonales("1", "118134", 
                "Luis", "Los Guido,San Jose", "luisezequiel@gmail.com", 
                "02/05/2001", "costarricense", "soltero", "desarollador");
        
        DatosPersonales datosPersonalesObj2 = new DatosPersonales("2", "1184566", 
                "Jamileth", "Desamparados", "Jamileth@gmail.com", 
                "26/11/1980", "nicaraguense", "casada", "salonera");
        
        DatosPersonales datosPersonalesObj3 = new DatosPersonales("3", "11848902", 
                "Aaron", "limon", "Aaron@gmail.com", 
                "26/03/1990", "colombiano", "soltero", "desarollador web");
        
        // Guardar Experiencia laboral de las entidades
        ExperienciaLaboral experienciaLaboralObj = new ExperienciaLaboral("1", 
                "Patitos", "programador", "12/10/12", "15/06/24", "programar una base");
        
        ExperienciaLaboral experienciaLaboralObj2 = new ExperienciaLaboral("2", 
                "Patitos", "cocinera", "12/09/19", "15/07/16", "cocinar productos");
        
        ExperienciaLaboral experienciaLaboralObj3 = new ExperienciaLaboral("3", 
                "Patitos", "front", "12/10/20", "15/07/24", "desarrollar paginas");
        
        // Guardar Informacion de Contacto
        InformacionContacto informacionContactoObj = new InformacionContacto("1"
                , "67890", "luisezequiel@gmail.com", "Costa Rica", "San Jose", "10122");
        
        InformacionContacto informacionContactoObj2 = new InformacionContacto("2"
                , "898900", "jamileth@gmail", "Nicaragua", "Managua", "89450");
        
         InformacionContacto informacionContactoObj3 = new InformacionContacto("3"
                , "789065", "Aaron@gmail.com", "Colombia", "Medellin", "967845");
        
        // Escribiendo los datos en los archivos
        datosPersonalesObj.escribirArchivoDatos();
        datosPersonalesObj2.escribirArchivoDatos();
        datosPersonalesObj3.escribirArchivoDatos();
        
        experienciaLaboralObj.escribirArchivoExperiencia();
        experienciaLaboralObj2.escribirArchivoExperiencia();
        experienciaLaboralObj3.escribirArchivoExperiencia();
        
        informacionContactoObj.escribirArchivoContacto();
        informacionContactoObj2.escribirArchivoContacto();
        informacionContactoObj3.escribirArchivoContacto();
        
        // Generando el cv Personalizado
        
        /*try{
            CvPersonalizado cv = new CvPersonalizado("1", "1", "1");
            cv.generarCv();
            System.out.println("Cv Generado Exitosamente");
            
            CvPersonalizado cv2 = new CvPersonalizado("2", "2", "2");
            cv2.generarCv();
            System.out.println("Cv Generado Exitosamente");
        } catch (IOException mensaje){
            mensaje.printStackTrace();
        }
        */
        new Interfaz(datosPersonales, experienciaLaboral, informacionContacto );
    }
}
