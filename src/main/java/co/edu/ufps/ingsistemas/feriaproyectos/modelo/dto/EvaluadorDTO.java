/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto;

/**
 *
 * @author marlonguerrero
 */
public class EvaluadorDTO extends PersonaDTO {

    private int id, codigo;
    private String dedicacion, postgrado, foto, asignaturas;

    public EvaluadorDTO() {
    }

    public EvaluadorDTO(int codigo, String dedicacion, String postgrado, String foto, String nombres, String apellidos, String contrasena, String correo, Persona_TipoDTO tipo, String asignaturas) {
        super(codigo, nombres, apellidos, contrasena, correo, tipo);
        this.codigo = codigo;
        this.dedicacion = dedicacion;
        this.postgrado = postgrado;
        this.foto = foto;
        this.asignaturas = asignaturas;
    }

    public int getId() {
        return id;
    }

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public String getPostgrado() {
        return postgrado;
    }

    public void setPostgrado(String postgrado) {
        this.postgrado = postgrado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
