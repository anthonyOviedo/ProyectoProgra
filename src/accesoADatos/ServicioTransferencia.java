/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Transferencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fernando
 */
public class ServicioTransferencia extends Servicio {

    private static final String INSERTARTRANSFERENCIA = "{call insertarTransferencia(?,?,?,?,?)}";
    private static final String ELIMINARTRANSFERENCIA = "{call eliminarTransferencia(?)}";
    private static final String MODIFICARTRANSFERENCIA = "{call modificarTransferencia(?,?,?,?,?)}";
    private static final String LISTARTRANSFERENCIA = "{?=call listarTransferencia}";
    private static final String CONSULTARTRANSFERENCIA = "{?=call consultarTransferencia(?)}";
    
    private static ServicioTransferencia servicioTransferencia = new ServicioTransferencia();

    public void insertarTransferencia(Transferencia laTransferencia) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARTRANSFERENCIA);
            
            pstmt.setInt(1, laTransferencia.getNumero());
            pstmt.setInt(2, laTransferencia.getOrigen().getCodigo());
            pstmt.setInt(3, laTransferencia.getDestino().getCodigo());
            pstmt.setString(4, laTransferencia.getUbicacion());
            pstmt.setString(5, laTransferencia.getFuncionario().getId());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
    
    public void eliminarTransferencia(int elNumero) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        
        CallableStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = conexion.prepareCall(ELIMINARTRANSFERENCIA);
            pstmt.setInt(1, elNumero);
            pstmt.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }

    }
 
    public void modificarTransferencia(Transferencia laTransferencia) throws GlobalException, NoDataException {
        
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARTRANSFERENCIA);
            pstmt.setInt(1, laTransferencia.getNumero());
            pstmt.setInt(2, laTransferencia.getOrigen().getCodigo());
            pstmt.setInt(3, laTransferencia.getDestino().getCodigo());
            pstmt.setString(4, laTransferencia.getUbicacion());
            pstmt.setString(5, laTransferencia.getFuncionario().getId());

            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se realizo la modificacion");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("-------------Llave no existe");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    public ArrayList<Transferencia> listarTransferencia() throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Transferencia laTransferencia = null;
        ArrayList<Transferencia> coleccion = new ArrayList();

        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARTRANSFERENCIA);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                laTransferencia = new Transferencia(
                        rs.getInt("numero"),
                        ServicioDependencia.getServicioDependencia().buscarDependencia(rs.getInt("origen")),
                        ServicioDependencia.getServicioDependencia().buscarDependencia(rs.getInt("origen")),
                        ServicioBien.getServicioBien().buscarBienPorTransferencia(rs.getInt("numero")),
                        rs.getString("ubicacion"),
                        ServicioFuncionario.getServicioFuncionario().buscarFuncionarioPorTransferencia(rs.getInt("numero"))
                );
                coleccion.add(laTransferencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null) {
            throw new NoDataException("No hay datos");
        }
        return coleccion;
    }

    public Transferencia buscarTransferencia(int numero) throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Transferencia laTransferencia = null;
        CallableStatement pstmt = null;
        try { 
            pstmt = conexion.prepareCall(CONSULTARTRANSFERENCIA);	
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2, numero );
            pstmt.execute();	
            
            rs = (ResultSet)pstmt.getObject(1);
            while (rs.next()) {
                laTransferencia = new Transferencia(
                        rs.getInt("numero"),
                        ServicioDependencia.getServicioDependencia().buscarDependencia(rs.getInt("origen")),
                        ServicioDependencia.getServicioDependencia().buscarDependencia(rs.getInt("origen")),
                        ServicioBien.getServicioBien().buscarBienPorTransferencia(rs.getInt("numero")),
                        rs.getString("ubicacion"),
                        ServicioFuncionario.getServicioFuncionario().buscarFuncionarioPorTransferencia(rs.getInt("numero"))
                );
                break;
             }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (laTransferencia == null) {
            throw new NoDataException("No existe una transferencia con este número");
        }
        return laTransferencia;
    }

    public static ServicioTransferencia getServicioTransferencia() {
        return servicioTransferencia;
    }
}
