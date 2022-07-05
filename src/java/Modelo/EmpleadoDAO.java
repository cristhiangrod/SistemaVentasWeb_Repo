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
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    //CHANGES
    //Para validar se debe crear un store procedure que retorne el user
    //es decir, la consulta se debe limitar a una fila
    //
    public Empleado validar(String user, String dni){
        Empleado em=new Empleado();
        String sql="select*from empleado where User=? and Dni=?"; //esto no irá mas con el SP
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while (rs.next()){//No hay necesidad de un while, solo compara los valores que retornan del SQL con los ingresados desde la UI
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) { //AGREGA UNA EXPECTION QUE SE MUESTRE EN LA CONSOLA, AYUDARÁ CUANDO HAYA ERRORES
        }
        return em;
    }
}
