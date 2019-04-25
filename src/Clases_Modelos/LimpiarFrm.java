
package Clases_Modelos;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Usuario
 */
public class LimpiarFrm {
    public static void limpiarFormulario(JPanel jpanel){
        for(int i=0;jpanel.getComponents().length>i;i++){
            if(jpanel.getComponents()[i]instanceof JTextField){
                ((JTextField)jpanel.getComponents()[i]).setText("");
            }
            else if(jpanel.getComponents()[i]instanceof JPasswordField){
                ((JPasswordField)jpanel.getComponents()[i]).setText("");
            }
        }
    }
}
