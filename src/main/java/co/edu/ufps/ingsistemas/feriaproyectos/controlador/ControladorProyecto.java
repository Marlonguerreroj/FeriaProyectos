/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.controlador;

import co.edu.ufps.ingsistemas.feriaproyectos.modelo.Fachada;
import co.edu.ufps.ingsistemas.feriaproyectos.modelo.dto.PersonaDTO;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.util.SecuritySupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author marlonguerrero
 */
public class ControladorProyecto extends HttpServlet {

    Fachada f = new Fachada();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void registrar_proyecto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fileName = "Documento.docx";
        OutputStream outt;
        String nuevaRuta = "";
        InputStream filecontent;
        String ruta2 = getServletContext().getRealPath("/");
        int codigo = 0;
        try {
            codigo = f.consultar_cantidad_proyectos() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ruta2 += "pDocumentos" + File.separator + codigo;
        Part file = request.getPart("file");
        String fileNa = request.getParameter("fileName");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String lineaTrabajo = request.getParameter("lTrabajo");
        int docente = Integer.parseInt(request.getParameter("docente"));
        int estudiante = ((PersonaDTO) request.getSession().getAttribute("persona")).getCodigo();

        try {
            if (file != null && !file.getSubmittedFileName().equals("")) {

                File dir = new File(ruta2);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                outt = new FileOutputStream(new File(ruta2 + File.separator
                        + fileNa));
                nuevaRuta = "/FeriaProyectos/pDocumentos/" + codigo + File.separator
                        + fileNa;
                filecontent = file.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    outt.write(bytes, 0, read);
                }
            }

            out.write("" + f.registrarProyecto(titulo, descripcion, docente, lineaTrabajo, estudiante, nuevaRuta));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void consultar_proyectos_inscritos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int codigo = ((PersonaDTO) request.getSession().getAttribute("persona")).getCodigo();
        try {

            Gson g = new Gson();
            out.write(g.toJson(f.consultar_proyectos_inscritos(codigo)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void envio_peticiones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int cod_origen = ((PersonaDTO) request.getSession().getAttribute("persona")).getCodigo();
        int cod_destino = Integer.parseInt(request.getParameter("cod_destino"));
        int cod_proyecto = Integer.parseInt(request.getParameter("cod_proyecto"));
        try{
            int resultado = f.envio_peticiones(cod_origen, cod_destino, cod_proyecto);
            out.write(""+resultado);
        }catch(Exception e){
            e.printStackTrace();
        }
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
        if (request.getParameter("consultar_proyectos_inscritos") != null) {
            consultar_proyectos_inscritos(request, response);
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
        if(request.getParameter("envio_peticiones")!=null){
            envio_peticiones(request, response);
        }else if (request.getPart("file") != null) {
            registrar_proyecto(request, response);
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
