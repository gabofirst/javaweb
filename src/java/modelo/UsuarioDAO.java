/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriel Casas
 */
public class UsuarioDAO {

    Conectar conectar = new Conectar();
    Connection con = null;

    private void iniciar() {
        conectar = new Conectar();
        con = conectar.getConnection();
    }

    private void cerrar() {
        conectar.closeConexion();
    }

    public Usuario acceso(Usuario u) {
        Usuario user = null;
        String sql = "SELECT id_usuario,nombre_completo,usuario FROM usuario  WHERE usuario='" + u.getUsuario() + "' and clave='" + u.getClave() + "'";
        iniciar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                user = new Usuario();
                user.setId_usuario(Integer.parseInt(rs.getString(1)));
                user.setNombre_completo(rs.getString(2));
                user.setUsuario(rs.getString(3));
                
                System.out.println(user.getId_usuario()+"--"+user.getNombre_completo()+"--"+user.getUsuario());
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error EX: " + e.getSQLState());
                }
            }
            cerrar();
        }
        return user;
    }

    public Usuario obtener(int id_usuario) {
        iniciar();
        Usuario u = null;
        String sql = "select * from usuario where id_usuario=" + id_usuario;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                u = new Usuario();
                u.setId_usuario(Integer.parseInt(rs.getString(1)));
                u.setNombre_completo(rs.getString(2));
                u.setUsuario(rs.getString(3));
                u.setClave(rs.getString(4));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(" Error Ex" + e.getSQLState());
                }
            }
            cerrar();
        }
        return u;
    }
}
