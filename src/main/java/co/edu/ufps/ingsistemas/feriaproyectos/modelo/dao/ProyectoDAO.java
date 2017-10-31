/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo.dao;

import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.ProyectoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author marlonguerrero
 */
public class ProyectoDAO {

    private Connection conn;

    public boolean registrarProyecto(ProyectoDTO dto) throws Exception {
        boolean exito = false;
        conn = Conexion.generarConexion();
        if (conn != null) {
            String query = "{CALL registrar_proyecto(?,?,?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1, dto.getTitulo());
            stmt.setString(2, dto.getDescripcion());
            stmt.setInt(3, dto.getDocenteGuia().getCodigo());
            stmt.setString(4, dto.getLineaTrabajo());
            stmt.setInt(5, dto.getEstudiantes().get(0).getCodigo());
            stmt.setString(6, dto.getDocumento());
            try {
                exito = stmt.executeUpdate() > 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                conn.close();
                stmt.close();
            }
        }
        return exito;
    }

    public ArrayList<ProyectoDTO> consultar_proyectos_inscritos(int codigo) throws Exception {
        ArrayList<ProyectoDTO> list = new ArrayList<>();
        conn = Conexion.generarConexion();
        if (conn != null) {
            String query = "{CALL consultar_proyectos_inscritos(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                ProyectoDTO dto = new ProyectoDTO();
                dto.setCodigo(rs.getInt(1));
                dto.setTitulo(rs.getString(2));
                dto.setDescripcion(rs.getString(3));
                dto.setFecha(rs.getDate(4));
                dto.getDocenteGuia().setNombres(rs.getString(5));
                dto.setLineaTrabajo(rs.getString(6));
                dto.setIntegrantes(rs.getString(7));
                list.add(dto);
            }

        }
        return list;
    }

    public int consultar_cantidad_proyectos() throws Exception {
        int resultado = 0;
        conn = Conexion.generarConexion();
        if (conn != null) {
            String query = "{CALL consultar_cantidad_proyectos()}";
            CallableStatement stmt = conn.prepareCall(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt(1);
            }
        }
        return resultado;
    }

    public int envio_peticiones(int cod_origen,int cod_destino,int cod_proyecto) throws Exception {
        int resultado = 0;
        conn = Conexion.generarConexion();
        if (conn != null) {
            String query = "{CALL envio_peticiones(?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, cod_origen);
            stmt.setInt(2, cod_destino);
            stmt.setInt(4, cod_proyecto);            
            stmt.registerOutParameter(3,Types.INTEGER);
            stmt.execute();
            resultado = stmt.getInt(3);
        }
        return resultado;
    }
}
