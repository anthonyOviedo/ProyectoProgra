/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Logic.Solicitud;
import Vista.VistaAdministrador;
import Vista.VistaSecretaria;
import java.util.ArrayList;
import java.util.Observable;


public class ModeloSecretaria extends Observable {

    VistaSecretaria vistaSecretaria;
    void setVistAdministrador(VistaSecretaria vistaSecretaria){
    this.vistaSecretaria =vistaSecretaria;
    }
    public void setTabla(Solicitud laSolicitud) {
                limpiar();
            this.vistaSecretaria.dtm.addRow(new Object[]{
                laSolicitud.getNumeroSolicitud(),
                laSolicitud.getFecha(),
                laSolicitud.getTipo(),
                "",
                "",
                laSolicitud.getEstado()
            });
 
    }

    public void setTabla(ArrayList<Solicitud> solicitudes) {
 
        limpiar();
        for (int i = 0; i < solicitudes.size(); i++) {
            this.vistaSecretaria.dtm.addRow(new Object[]{
               solicitudes.get(i).getNumeroSolicitud(),
               solicitudes.get(i).getFecha(),
               solicitudes.get(i).getTipo(),
                "",
                "",
                solicitudes.get(i).getEstado()
            });
        }
    }

    public void setVista(VistaSecretaria vista) {
        this.vistaSecretaria =vista;
     }
    
    public void limpiar(){
        this.vistaSecretaria.getCampoBuscar().setText("");
        this.vistaSecretaria.dtm.setRowCount(0);
    }
    
}
