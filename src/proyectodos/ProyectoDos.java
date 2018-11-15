/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodos;

import Control.ControllerLogin;
import Modelo.ModeloLogin;
import Vista.VistaLogin;
import java.sql.SQLException;
 
/**
 *
 * @author Fernando
 */
public class ProyectoDos {

    
    public static void main(String[] args) throws SQLException {

        VistaLogin vista = new VistaLogin();
        
        ControllerLogin control = new ControllerLogin(new ModeloLogin(), vista);
        
        vista.setVisible(true);


    }

}
