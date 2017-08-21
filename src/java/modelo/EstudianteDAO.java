/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import entidades.Estudiante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class EstudianteDAO {
        Conectar conectar;
    Connection con;
    
    private void inicir(){
        conectar= new Conectar();
        con=conectar.getConnection();
    }
    private void cerrar(){
        conectar.closeConexion();
    }
    
    public List<Estudiante> ObtenerEstudiante(){
        inicir();
        List<Estudiante> lista = new ArrayList<Estudiante>();
        String sql="select * from estudiante";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Estudiante e = new Estudiante();
                e.setId_estudiante(Integer.parseInt(rs.getString(1)));
                e.setCi(rs.getString(2));
                e.setRu(rs.getString(3));
                e.setNombre_completo(rs.getString(4));
                lista.add(e);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("SQLException: "+e.getMessage());
        }finally{
            if(con!=null){
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println("Error colse :"+e.getMessage());
                }
            }
            cerrar();
        }
        return lista;
    }
}
