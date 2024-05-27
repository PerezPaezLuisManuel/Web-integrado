
package Modelo;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAO implements CRUD{
    
    //Instanciado de clases para la conexión a la base de datos
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from persona";
        try {
            con=cn.getConnection(); //Establece la conexión con la BD
            ps=con.prepareStatement(sql); //Prepara la consulta SQL
            rs=ps.executeQuery(); //Ejecuta la consulta y la almacena en el ResultSet
            
            //Bucle que agrega personas a la lista
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("ID"));
                per.setDni(rs.getString("DNI"));
                per.setNom(rs.getString("Nombres"));
                list.add(per); //Agrega la persona a la lista
            }
        } catch (Exception e){
        }
        //Retorna la lista de personas
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="select * from persona where ID="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            //Extrae datos de la persona de acuerdo a su ID
            while(rs.next()){                
                p.setId(rs.getInt("ID"));
                p.setDni(rs.getString("DNI"));
                p.setNom(rs.getString("Nombres"));
                
            }
        } catch (Exception e) {
        }
        return p; //Retorna a la persona
    }

    @Override
    //Método que agrega a una persona
    public boolean agregar(Persona per) {
        String sql="insert into persona(DNI, Nombres)values('"+per.getDni()+"','"+per.getNom()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    //Método que permite editar los datos de una persona
    public boolean editar(Persona per) {
        String sql="update persona set DNI='"+per.getDni()+"',Nombres='"+per.getNom()+"'where ID="+per.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    //Método que permite eliminar a una persona
    public boolean eliminar(int id) {
        String sql="delete from persona where ID="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
