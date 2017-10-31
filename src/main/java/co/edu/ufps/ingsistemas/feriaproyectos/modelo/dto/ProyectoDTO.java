/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author marlonguerrero
 */
public class ProyectoDTO {

    private int codigo;
    private String titulo, descripcion, lineaTrabajo,integrantes;
    private Date fecha;
    private PersonaDTO docenteGuia;
    private ArrayList<PersonaDTO> estudiantes;
    private String documento;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public ProyectoDTO() {
        docenteGuia = new PersonaDTO();
        estudiantes = new ArrayList<>();
        
    }

    public String getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
    }

    public ProyectoDTO(String titulo, String descripcion, String lineaTrabajo, PersonaDTO docenteGuia, ArrayList<PersonaDTO> estudiantes) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lineaTrabajo = lineaTrabajo;
        this.docenteGuia = docenteGuia;
        this.estudiantes = estudiantes;
    }
        

    public ProyectoDTO(int codigo, String titulo, String descripcion, String lineaTrabajo, Date fecha, PersonaDTO docenteGuia, ArrayList<PersonaDTO> estudiantes) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lineaTrabajo = lineaTrabajo;
        this.fecha = fecha;
        this.docenteGuia = docenteGuia;
        this.estudiantes = estudiantes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLineaTrabajo() {
        return lineaTrabajo;
    }

    public void setLineaTrabajo(String lineaTrabajo) {
        this.lineaTrabajo = lineaTrabajo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public PersonaDTO getDocenteGuia() {
        return docenteGuia;
    }

    public void setDocenteGuia(PersonaDTO docenteGuia) {
        this.docenteGuia = docenteGuia;
    }

    public ArrayList<PersonaDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<PersonaDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
    

}
