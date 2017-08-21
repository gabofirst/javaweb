/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.UsuarioDAO;

/**
 *
 * @author Gabriel Casas
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        sesion.removeAttribute("usuario");
        sesion.removeAttribute("user");
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
        session.setMaxInactiveInterval(600);
        String usuario = request.getParameter("g_usuario");
        String clave = request.getParameter("g_clave");
        String pagina = "index.jsp";
        Usuario u = new Usuario(usuario, clave);
        u=(new UsuarioDAO()).acceso(u);
        if (u!=null) {
            u=(new UsuarioDAO().obtener(u.getId_usuario()));
            session.setAttribute("usuario", u.getNombre_completo());
            session.setAttribute("user", u);
            pagina="sorteo.jsp";
        }else{
            session.invalidate();
        }
        response.sendRedirect(pagina);
    }
}
