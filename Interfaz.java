
package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class Interfaz extends JFrame {
    
    // Atributos de la clase
    private JComboBox<String>datosPersonales;
    private JComboBox<String>experienciaLaboral;
    private JComboBox<String>informacionContacto;
    private JButton boton;
    
    // Constructor de la clase y de la venta
    public Interfaz(List<String>_datosPersonales, List<String>_experienciaLaboral,
            List<String>_informacionContacto){
        
        // Configuramos la ventana
        setTitle("CV Personalizado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        
        // Creamos los ComboBoxes
        datosPersonales = new JComboBox<>(_datosPersonales.toArray(new String[0]));
        experienciaLaboral = new JComboBox<>(_experienciaLaboral.toArray(new String[0]));
        informacionContacto = new JComboBox<>(_informacionContacto.toArray(new String[0]));
        
        // Creamos el boton
        boton = new JButton("Generar CV");
        
        // Anadimos los componentes creados a la ventana
        add(new JLabel("Datos Personales: "));
        add(datosPersonales);
        
        add(new JLabel("Experiencia Laboral: "));
        add(experienciaLaboral);
        
        add(new JLabel("Informacion Contacto: "));
        add(informacionContacto);
        
        add(new JLabel(""));
        add(boton);
        
        // Funciones del boton
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent accion){
                String idDatosPersonales = getSelectedId(datosPersonales);
                String idExperienciaLaboral = getSelectedId(experienciaLaboral);
                String idInformacionContacto = getSelectedId(informacionContacto);
                
                if(idDatosPersonales.isEmpty() || idExperienciaLaboral.isEmpty() ||
                        idInformacionContacto.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Seleccione un registro por categoria");
                    return;
                }
                
                try{
                    CvPersonalizado cv = new CvPersonalizado(idDatosPersonales,
                    idExperienciaLaboral, idInformacionContacto);
                    cv.generarCv();
                     JOptionPane.showMessageDialog(null, "Cv generado");
                } catch(IllegalArgumentException mensaje){
                    JOptionPane.showMessageDialog(null, "Error" + mensaje.getMessage());
                } catch (IOException mensaje){
                    JOptionPane.showMessageDialog(null, "Seleccione un registro por categoria");
                }
            }

        });
        
        setVisible(true);
    }
    
    // Metodo para obtener el id de un ComboBox
    private String getSelectedId(JComboBox<String> combobox){
        String selectedItem = (String) combobox.getSelectedItem();
        return selectedItem != null ?selectedItem.split("")[0]:"";
    }
}
    

   

   
    