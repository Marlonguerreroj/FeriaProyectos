/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto;

import java.util.ArrayList;

/**
 *
 * @author marlonguerrero
 */
public class PersonaDTO {

    private int codigo;
    private String nombres, apellidos, contrasena, correo;
    private Persona_TipoDTO tipo;
    private ArrayList<ProyectoDTO> proyectos;
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public PersonaDTO() {
        tipo = new Persona_TipoDTO();
        proyectos = new ArrayList<>();
    }

    public Persona_TipoDTO getTipo() {
        return tipo;
    }

    public void setTipo(Persona_TipoDTO tipo) {
        this.tipo = tipo;
    }

    public PersonaDTO(int codigo, String nombres, String apellidos, String contrasena, String correo, Persona_TipoDTO tipo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.correo = correo;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
