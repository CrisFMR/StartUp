package cl.praxis.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.models.dto.Usuarios;
import cl.praxis.models.dao.UserDAOImpl;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        int pesoStr = Integer.parseInt(request.getParameter("peso"));

        if (correo == null || password == null || nick == null ||  nombre == null ) {
            response.sendRedirect(request.getContextPath() +"/views/register.jsp");
            return;
        }else if (correo.isEmpty() || password.isEmpty() || nick.isEmpty() || nombre.isEmpty()){
        	response.sendRedirect(request.getContextPath() +"/views/register.jsp");
            return;
        }
        int peso;
        
        try {
        	peso = pesoStr;
        } catch (NumberFormatException e) {
            response.sendRedirect("/views/register.jsp");
            return;
        }

        UserDAOImpl uDAO = new UserDAOImpl();
        if (uDAO.mailReg(correo)) {
            request.setAttribute("error", "El correo electrónico ya existe");
            response.sendRedirect(request.getContextPath() + "/views/register.jsp");
            return;
        }

        Usuarios u = new Usuarios();
        u.setCorreo(correo);
        u.setPassword(password);
        u.setNick(nick);
        u.setNombre(nombre);
        u.setPeso(peso);
        u.setCreatedAt(LocalDate.now());
        u.setUpdatedAt(LocalDate.now());

        try {
            uDAO.create(u);
            response.sendRedirect(request.getContextPath() + "/views/login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/views/register.jsp");
        }
    }
}
