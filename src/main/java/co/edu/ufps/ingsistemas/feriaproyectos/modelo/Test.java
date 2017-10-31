/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.ingsistemas.feriaproyectos.modelo;

/**
 *
 * @author marlonguerrero
 */
public class Test {

    public static void main(String[] args) {
        Fachada f = new Fachada();
        try {
            //System.out.println("Message: "+f.registrarEstudiante(1151089, "Marlon", "Guerrero", "123456", "marl@gue.com"));
            //System.out.println("Message: "+f.iniciarSesion(1151089, "1231233").getApellidos());
            //System.out.println("Message: "+f.registrarPersona(1151256, "Pedro", "Perez", "123123", "pedroperez@ufps.edu.co",1 , "", "", ""));
            //System.out.println("Message: "+f.consultar_cantidad_proyectos());
            System.out.println("Message: "+f.envio_peticiones(1151089, 1151256, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
