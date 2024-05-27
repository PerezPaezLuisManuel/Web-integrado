/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author lurto
 */
public class Controlator extends HttpServlet {
    
    //Declaración de variables
    String listar="Vista/listar.jsp";
    String agregar="Vista/agregar.jsp";
    String editar="Vista/editar.jsp";
    Persona p=new Persona();
    PersonaDAO dao=new PersonaDAO();
    int id;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlator at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        //Declaración de variables
        String acceso=""; //Variable que determina la vista a la que se redirige
        String action=request.getParameter("accion"); //Obtiene el valor que se genera al presionar el botón "Listar persona" de "index.jsp"
        
        //Bucle if que determina la acción a realizar según el valor del parámetro "accion"
        if(action.equalsIgnoreCase("listar")){
            acceso=listar; //Redirige a la vista "listar.jsp"            
        }else if(action.equalsIgnoreCase("add")){
            acceso=agregar; //Redirige a la vista "agregar.jsp"
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
            //Recibe los datos de "agregar.jsp"
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            p.setDni(dni); //Establece el DNI en la clase "Persona"
            p.setNom(nom); //Establece el nombre en la clase "Persona"
            dao.agregar(p); //Llama al método agregar de la clase "PersonaDAO" para agregar a la persona a la BD
            acceso=listar; //Redirige a "listar.jsp"
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=editar; //Redirige a "editar.jsp"
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            
            //Recibe datos de editar.jsp
            id=Integer.parseInt(request.getParameter("txtid"));
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            p.setId(id); //Establece el ID en la clase Persona
            p.setDni(dni); //Establece el DNI en la clase Persona
            p.setNom(nom); //Establece el Nombre en la clase Persona
            dao.editar(p); //Llama al método editar de "PersonaDAO" para actualizar los datos 
            acceso=listar; //Redirige a "listar.jsp"
        }
        else if(action.equalsIgnoreCase("eliminar")){
            
            //Elimina una persona
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id); //Establece el ID en el Modelo Persona
            dao.eliminar(id); //Llama al método eliminar del DAO y elimina a la persona
            acceso=listar; //Redirecciona a la vista listar
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
        processRequest(request, response);
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
