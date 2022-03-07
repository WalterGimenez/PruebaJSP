
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Persona;


@WebServlet(name = "SvPersona", urlPatterns = {"/SvPersona"})
public class SvPersona extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //debemos traer la lista para pasar de jsp a jsp antes de la request
        
        List <Persona> listaPersonas = control.traerPersonas();
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaPersonas", listaPersonas);
        
        //redirijimos a otro jsp
        response.sendRedirect("verPersonas.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
     
        Persona pers = new Persona(0, dni, nombre, apellido, telefono);
        control.crearPersona(pers);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
