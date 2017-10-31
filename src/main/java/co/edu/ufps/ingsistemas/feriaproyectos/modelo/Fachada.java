/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo;

import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dao.PersonaDAO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dao.ProyectoDAO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.EvaluadorDTO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.PersonaDTO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.Persona_TipoDTO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.ProyectoDTO;
import java.util.ArrayList;

/**
 *
 * @author marlonguerrero
 */
public class Fachada {
    
    ProyectoDAO proyectodao = new ProyectoDAO();
    PersonaDAO personadao = new PersonaDAO();

    public PersonaDTO iniciarSesion(int codigo, String contrasena) throws Exception {
        PersonaDTO dto = new PersonaDTO();
        dto.setCodigo(codigo);
        dto.setContrasena(contrasena);
        return personadao.iniciarSesion(dto);
    }
    
    public boolean registrarPersona(int codigo, String nombres, String apellidos,
            String contrasena, String correo,int tipo, String dedicacion, String postgrado, String foto,String asignaturas) throws Exception{
        Persona_TipoDTO tipoDTO = new Persona_TipoDTO();
        tipoDTO.setId(tipo);
        EvaluadorDTO evaluadorDTO = new EvaluadorDTO(codigo, dedicacion, postgrado, foto, nombres, apellidos, contrasena, correo, tipoDTO,asignaturas);
        return personadao.registrarPersona(evaluadorDTO);
    }
    
    public ArrayList<EvaluadorDTO> consultarEvaluadores() throws Exception{
        return personadao.consultarEvaluadores();
    }
    
    public boolean registrarProyecto(String titulo,String descripcion, int docenteGuia,String lineaTrabajo,int estudiante,String documento)throws Exception{
        PersonaDTO docente = new PersonaDTO();
        PersonaDTO est = new PersonaDTO();
        docente.setCodigo(docenteGuia);
        est.setCodigo(estudiante);
        ArrayList<PersonaDTO> estudiantesLIST = new ArrayList<>();
        estudiantesLIST.add(est);
        ProyectoDTO proyecto = new ProyectoDTO(titulo, descripcion, lineaTrabajo, docente, estudiantesLIST);
        proyecto.setDocumento(documento);
        return proyectodao.registrarProyecto(proyecto);
    }
    
    public ArrayList<PersonaDTO> consultarPersona(int tipo) throws Exception{        
        return personadao.consultarPersona(tipo);
    }
    
    public PersonaDTO consultar_persona_codigo(int codigo) throws Exception{
        return personadao.consultar_persona_codigo(codigo);
    }
    
    public ArrayList<ProyectoDTO> consultar_proyectos_inscritos(int codigo) throws Exception{
        return proyectodao.consultar_proyectos_inscritos(codigo);
    }
    
    public int consultar_cantidad_proyectos() throws Exception{
        return proyectodao.consultar_cantidad_proyectos();
    }
    
    public int envio_peticiones(int cod_origen,int cod_destino,int cod_proyecto) throws Exception{
        return proyectodao.envio_peticiones(cod_origen, cod_destino, cod_proyecto);
    }
}
