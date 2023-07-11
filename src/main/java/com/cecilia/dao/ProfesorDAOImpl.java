/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cecilia.dao;

import com.cecilia.config.Conexion;
import com.cecilia.model.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author escob
 */
public class ProfesorDAOImpl implements ProfesorDAO{
    
    private Conexion objConexion;
    
    private Connection objConnection;
    
    public ProfesorDAOImpl(){
    objConexion = new Conexion();
    }

    @Override
    public List<Profesor> findAll() {
        //consulta SQL que se tiene que realizar 
        String consulta = "SELECT * FROM profesores";
        //listado de datos que se retorna
        List<Profesor> listado = new LinkedList<>();
        
        try{
           this.objConexion.conectar();
           this.objConnection = this.objConexion.getJdbcConnection();
           //se prepara la consulta
           PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            
           //se ejecuta la consulta
           ResultSet rs = prest.executeQuery(consulta);
           
           Profesor objProfesor;
           
           while(rs.next()){
               objProfesor = new Profesor();
               objProfesor.setId(rs.getInt("id"));
               objProfesor.setNombre(rs.getString ("nombre"));
               objProfesor.setApellido(rs.getString ("apellido"));
               objProfesor.setEmail(rs.getString ("email"));
               objProfesor.setColegio(rs.getString ("colegio"));
               
               listado.add(objProfesor);
               
           }
           
        }catch(Exception e){
            System.out.println("Error en la consulta");
        }
        return listado;
    }

    @Override
    public Profesor insert(Profesor objProfesor) {
        String consulta = "INSERT INTO profesores(nombre, apellido, email, colegio) VALUES(?,?,?,?)";
        try{
            this.objConexion.conectar();
            this.objConnection = this.objConexion.getJdbcConnection();
            //inicializacion de la consulta
            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            //agregar los datos dentro de la consulta
           
           prest.setString(1 , objProfesor.getNombre());
           prest.setString(2, objProfesor.getApellido());
           prest.setString(3 , objProfesor.getEmail());
           prest.setString(4 , objProfesor.getColegio());
           
           
           int count = prest.executeUpdate();
           
           ResultSet rs = null;
           rs = prest.executeQuery("SELECT LAST_INSERT_ID()");
           
           int autoKey = -1;
           if(rs.next()){
               autoKey = rs.getInt("id");
               objProfesor.setId(autoKey);
               System.out.println("Ultimo ID introducido" + autoKey);
           }else{
               System.out.println("No existe dato de ID");
           }
           
            
        }catch(Exception e){
            System.out.println("Error al insertar " + e);
        }
        return objProfesor;
    }

    @Override
    public Profesor findById(Integer id) {
    
        String consulta = "SELECT * FROM profesores WHERE id=?";
        
        Profesor objProfesor = new Profesor();
        
        try{
            this.objConexion.conectar();
            this.objConnection = objConexion.getJdbcConnection();
            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
       
            prest.setInt(1, id);
            
            ResultSet rs = prest.executeQuery();
            
            
            while(rs.next()){
               
               objProfesor.setId(rs.getInt("id"));
               objProfesor.setNombre(rs.getString ("nombre"));
               objProfesor.setApellido(rs.getString ("apellido"));
               objProfesor.setEmail(rs.getString ("email"));
               objProfesor.setColegio(rs.getString ("colegio"));
               
               
            }
            
            
        }catch(Exception e){
            
            System.out.println ("Error en findById" + e);
        }
        
        return objProfesor;
    }
       

    @Override
    public Profesor updateById(Integer id, Profesor objProfesor) {
        String consulta = "UPDATE profesores SET nombre=?, apellido=?, email=?, colegio=? WHERE id=?";
        
        try{
            this.objConexion.conectar();
            this.objConnection = objConexion.getJdbcConnection();
            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            
             prest.setString(1, objProfesor.getNombre());
             prest.setString(2, objProfesor.getApellido());
             prest.setString(3, objProfesor.getEmail());
             prest.setString(4, objProfesor.getColegio());
             prest.setInt(5, id);
            
            int resultado = prest.executeUpdate();
            
            if (resultado == 1){
                System.out.println ("Actualizacion satisfactoria");
                objProfesor.setId(id);
                
            }else{
                objProfesor.setId(0);
                System.out.println ("No se actualizo el registro");
            }
            
        }catch(Exception e){
            System.out.println ("Error en updateById" + e);
        }
        
        return objProfesor;
    }

    @Override
    public Boolean deleteById(Integer id) {
        String consulta = "DELETE FROM profesores WHERE id=?";
        Boolean returnValue = false;
        
        try{
            this.objConexion.conectar();
            this.objConnection = objConexion.getJdbcConnection();
            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            prest.setInt(1, id);
            
            int resultado = prest.executeUpdate();
            
            if (resultado > 0){
                returnValue = true;
            }
            System.out.println ("Eliminacion satisfactoria");
        }catch(Exception e){
            System.out.println ("Error en deleteById" + e);
        }
        return returnValue;
    }
    
}
