/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.controlador;

import co.edu.ufps.ingsistemas.feriaproyectos.modelo.Fachada;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.EvaluadorDTO;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.PersonaDTO;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author marlonguerrero
 */
public class ControladorPersona extends HttpServlet {

    private PersonaDTO persona = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void registrarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //Atributos Persona
        int codigo = Integer.parseInt(request.getParameter("codEstudiante"));
        String nombre = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String contrasena = request.getParameter("contrasena");
        String contasenaN = request.getParameter("contrasenaN");
        String correo = request.getParameter("correo");
        //Variable para imprimir
        PrintWriter out = response.getWriter();
        // fachada(?)
        Fachada f = new Fachada();
        //Atributos Evaluador
        int cargo = 1;
        String dedicacion = "N/A";
        String asignaturas = "N/A";
        String postgrado = "";
        String foto = "";
        Part file = null;
        String ruta2 = "";
        String fileName = "fotoPerfil.jpg";
        OutputStream outt = null;
        String nuevaRuta = "";
        InputStream filecontent = null;
        if (request.getParameter("cargo") != null) {
            cargo = Integer.parseInt(request.getParameter("cargo"));
            if (request.getParameter("dedicacion") != null) {
                dedicacion = request.getParameter("dedicacion");
            }
            if (request.getParameter("asignaturas") != null) {
                asignaturas = request.getParameter("asignaturas");
            }
            postgrado = request.getParameter("estudios");
            //Imagen
            ruta2 = getServletContext().getRealPath("/");
            ruta2 += "pFotos" + File.separator + codigo;
            file = request.getPart("file");

        }
        try {
            if (file != null && !file.getSubmittedFileName().equals("")) {

                File dir = new File(ruta2);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                outt = new FileOutputStream(new File(ruta2 + File.separator
                        + fileName));
                nuevaRuta = "/FeriaProyectos/pFotos/" + codigo + File.separator
                        + fileName;
                filecontent = file.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    outt.write(bytes, 0, read);
                }
            }
            if (f.registrarPersona(codigo, nombre, apellidos, contrasena, correo, cargo, dedicacion, postgrado, nuevaRuta, asignaturas)) {
                if (cargo > 1) {
                    consultarEvaluadores(request, response);
                    consultarEstudiantes(request, response);
                    consultarDocentes(request, response);
                }
                out.write("true");
            } else {
                out.write("false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean rel = false;
        int codigo = Integer.parseInt(request.getParameter("codEstudiante"));
        String contrasena = request.getParameter("contrasena");
        Fachada f = new Fachada();
        PrintWriter out = response.getWriter();
        try {
            persona = f.iniciarSesion(codigo, contrasena);
            if (persona != null) {
                request.getSession().setAttribute("persona", persona);
                rel = true;
                consultarEvaluadores(request, response);
                consultarEstudiantes(request, response);
                consultarDocentes(request, response);
            }
            out.write("" + rel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarEvaluadores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Fachada f = new Fachada();
            ArrayList<EvaluadorDTO> list = f.consultarEvaluadores();
            request.getSession().setAttribute("evaluadores", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void consultarDocentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Fachada f = new Fachada();
            ArrayList<PersonaDTO> list = f.consultarPersona(2);
            request.getSession().setAttribute("docentes", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarEstudiantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Fachada f = new Fachada();
            ArrayList<PersonaDTO> list = f.consultarPersona(1);
            request.getSession().setAttribute("estudiantes", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultar_persona_codigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Fachada f = new Fachada();
            PersonaDTO persona = f.consultar_persona_codigo(codigo);
            Gson gson = new Gson();
            if(persona !=null){
                out.write(gson.toJson(persona));
            }else{
                out.write("null");
            }
            
        } catch (Exception e) {
        }
    }

    public void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/FeriaProyectos/");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("out") != null) {
            cerrarSesion(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("send") != null) {
            registrarPersona(request, response);
        } else if (request.getParameter("consultar_persona") != null) {
            consultar_persona_codigo(request, response);
        } else if (request.getParameter("logIn") != null) {
            iniciarSesion(request, response);
        } else if (request.getPart("file") != null) {
            registrarPersona(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
