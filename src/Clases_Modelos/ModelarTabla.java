package Clases_Modelos;

import javax.swing.JTable;

/**
 * @author Usuario
 */
public class ModelarTabla {
    
    public void modela(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(140);
            tabla.getColumnModel().getColumn(1).setMaxWidth(220);
            tabla.getColumnModel().getColumn(2).setMaxWidth(60);
            tabla.getColumnModel().getColumn(3).setMaxWidth(60);
            tabla.getColumnModel().getColumn(4).setMaxWidth(110);
            tabla.getColumnModel().getColumn(5).setMaxWidth(60);
            tabla.getColumnModel().getColumn(6).setMaxWidth(60);
            tabla.getColumnModel().getColumn(7).setMaxWidth(80);
            tabla.getColumnModel().getColumn(8).setMaxWidth(80);
        }
    }
    
    public void modelaEmp(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(160);
            tabla.getColumnModel().getColumn(1).setMaxWidth(180);
            tabla.getColumnModel().getColumn(2).setMaxWidth(90);
            tabla.getColumnModel().getColumn(3).setMaxWidth(190);
        }
    }
    
    public void modelaVent(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(110);
            tabla.getColumnModel().getColumn(1).setMaxWidth(340);
            tabla.getColumnModel().getColumn(2).setMaxWidth(70);
            tabla.getColumnModel().getColumn(3).setMaxWidth(70);
            tabla.getColumnModel().getColumn(4).setMaxWidth(70);
        }
    }
    
    public void modelaUser(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(80);
            tabla.getColumnModel().getColumn(1).setMaxWidth(250);
            tabla.getColumnModel().getColumn(2).setMaxWidth(200);
        }
    }
    
    public void modelaVentaDiaria(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(70);
            tabla.getColumnModel().getColumn(1).setMaxWidth(340);
            tabla.getColumnModel().getColumn(2).setMaxWidth(100);
            tabla.getColumnModel().getColumn(3).setMaxWidth(100);
            tabla.getColumnModel().getColumn(4).setMaxWidth(90);
        }
    }
}