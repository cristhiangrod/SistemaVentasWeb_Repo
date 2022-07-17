/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CristhianACER
 */
public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    //CHANGES
    //Para validar se debe crear un store procedure que retorne el user
    //es decir, la consulta se debe limitar a una fila
    //
    public Usuario validar(String user, String password){
        Usuario em=new Usuario();
        String sql="select*from usuario where User=? and Password=?"; //esto no irá mas con el SP
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs=ps.executeQuery();
            while (rs.next()){//No hay necesidad de un while, solo compara los valores que retornan del SQL con los ingresados desde la UI
                em.setIdUsuario(rs.getInt("IdUsuario"));
                em.setUsuario(rs.getString("User"));
                em.setPassword(rs.getString("Password"));
                em.setNombreUsuario(rs.getString("NombreUsuario"));
            }
        } catch (Exception e) { 
            System.out.println(e);
        }
        return em;
    }
}
