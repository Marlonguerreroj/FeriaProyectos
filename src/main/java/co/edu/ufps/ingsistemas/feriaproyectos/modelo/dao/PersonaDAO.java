/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo.dao;

import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.EvaluadorDTO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.PersonaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marlonguerrero
 */
public class PersonaDAO {

    private Connection conn;

    public boolean registrarPersona(EvaluadorDTO dto) throws Exception {
        boolean exito = false;
        conn = Conexion.generarConexion();
        if (conn != null) {
            String query = "{CALL registrar_persona(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            System.out.println(dto.getNombres());
            stmt.setInt(1, dto.getCodigo());
            stmt.setString(2, dto.getNombres());
            stmt.setString(3, dto.getApellidos());
            stmt.setString(4, dto.getContrasena());
            stmt.setInt(5, dto.getTipo().getId());
            stmt.setString(6, dto.getCorreo());
            stmt.setString(7, dto.getDedicacion());
            stmt.setString(8, dto.getPostgrado());
            stmt.setString(9, dto.getFoto());
            stmt.setString(10, dto.getAsignaturas());

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

    public PersonaDTO iniciarSesion(PersonaDTO dto) throws Exception {
        PersonaDTO rel = null;
        conn = Conexion.generarConexion();
        String query = "{CALL iniciar_sesion(?,?)}";
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setInt(1, dto.getCodigo());
        stmt.setString(2, dto.getContrasena());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            rel = new PersonaDTO();
            rel.setCodigo(rs.getInt(1));
            rel.setNombres(rs.getString(2));
            rel.setApellidos(rs.getString(3));
            rel.setContrasena(rs.getString(4));
            rel.getTipo().setId(rs.getInt(5));
            rel.setCorreo(rs.getString(6));
            rel.getTipo().setDescripcion(rs.getString(7));
        }
        return rel;
    }

    public ArrayList<EvaluadorDTO> consultarEvaluadores() throws Exception {
        ArrayList<EvaluadorDTO> list = new ArrayList<>();
        conn = Conexion.generarConexion();
        String query = "{CALL consultar_evaluadores()}";
        CallableStatement stmt = conn.prepareCall(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            EvaluadorDTO dto = new EvaluadorDTO();
            dto.setNombres(rs.getString(1));
            dto.setApellidos(rs.getString(2));
            dto.setFoto(rs.getString(3));
            dto.getTipo().setDescripcion(rs.getString(4));
            dto.setDedicacion(rs.getString(5));
            dto.setPostgrado(rs.getString(6));
            dto.setCorreo(rs.getString(7));
            dto.setAsignaturas(rs.getString(8));
            list.add(dto);
        }
        return list;
    }

    public ArrayList<PersonaDTO> consultarPersona(int tipo) throws Exception {
        ArrayList<PersonaDTO> list = new ArrayList<>();
        conn = Conexion.generarConexion();
        String query = "{CALL consultar_persona(?)}";
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setInt(1, tipo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            PersonaDTO dto = new PersonaDTO();
            dto.setCodigo(rs.getInt(1));
            dto.setNombres(rs.getString(2));
            list.add(dto);
        }
        return list;
    }

    public PersonaDTO consultar_persona_codigo(int codigo) throws Exception {
        PersonaDTO dto = null;
        conn = Conexion.generarConexion();
        String query = "{CALL consultar_persona_codigo(?)}";
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            dto = new PersonaDTO();
            dto.setCodigo(rs.getInt(1));
            dto.setNombres(rs.getString(2));

        }
        return dto;
    }

}
