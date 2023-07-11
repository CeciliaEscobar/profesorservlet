/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cecilia;

import com.cecilia.dao.ProfesorDAO;
import com.cecilia.dao.ProfesorDAOImpl;
import com.cecilia.model.Profesor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author escob
 */

@WebServlet(urlPatterns="/ProfesorServlet")
public class ProfesorServlet extends HttpServlet {
    
    private ProfesorDAO profesorDao;
    
    public ProfesorServlet(){
        
        super();
        profesorDao = new ProfesorDAOImpl();
    }
    
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.procesarSolicitud(req, resp);
       
    }
    
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        this.procesarSolicitud(req, resp);
        
    }
    
    protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        switch (request.getParameter("action")){
            case "list":
                this.list(request,response);
                break;
              case "create":
                this.create(request,response);
                break;
                 case "read":
                this.read(request,response);
                break;
                 case "update":
                this.update(request,response);
                break;
                 case "delete":
                this.delete(request,response);
                break;
                 case "showRegister":
                this.showRegister(request,response);
                break;
                 case "index":
                this.index(request,response);
                break;
                 default:
                  this.index(request,response);
                   break;
                
        }
        
       
    }
     private void index (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
     private void showRegister(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
            dispatcher.forward(request, response);
     }
      private void create (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          //recoger los datos desde la peticion
          String name = request.getParameter("nombre");
          String apellido = request.getParameter("apellido");
          String email = request.getParameter("email");
          String colegio = request.getParameter("colegio");
          
          //crear el objeto que se envia al BD
          
          Profesor objProfesor = new Profesor();
          objProfesor.setNombre(name);
          objProfesor.setApellido(apellido);
          objProfesor.setEmail(email);
          objProfesor.setColegio(colegio);
          
          profesorDao.insert(objProfesor);
          
          //Redireccionar al "index"
          
          this.index(request, response);
     }
     private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          List<Profesor> listaProfesores = this.profesorDao.findAll();
          request.setAttribute ("lista", listaProfesores);
          
           RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
            dispatcher.forward(request, response);
     }
     private void read (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         //recoge el id del elemento a buscar
         Integer id = Integer.parseInt(request.getParameter("id"));
         
         Profesor datosObjProfesor = new Profesor();
         
         datosObjProfesor = this.profesorDao.findById(id);
         
         request.setAttribute("profesor", datosObjProfesor);
         
          RequestDispatcher dispatcher = request.getRequestDispatcher("/view/read.jsp");
            dispatcher.forward(request, response);
         
     }
     
      
     private void update (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         
         Integer id = Integer.parseInt(request.getParameter("id"));
         
         Profesor objProfesor = new Profesor();
         
         objProfesor = this.profesorDao.findById(id);
         
          String name = request.getParameter("nombre");
          String apellido = request.getParameter("apellido");
          String email = request.getParameter("email");
          String colegio = request.getParameter("colegio");
         
         
          objProfesor.setNombre(name);
          objProfesor.setApellido(apellido);
          objProfesor.setEmail(email);
          objProfesor.setColegio(colegio);
         
         
        //actualizar los datos en la base de datos
        
        profesorDao.updateById(id, objProfesor);
        
        this.list(request, response);
         
     }
      private void delete (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         
         Integer id = Integer.parseInt(request.getParameter("id"));
         
         Profesor objProfesor = new Profesor();
         
         objProfesor = this.profesorDao.findById(id);
         
        if (!objProfesor.getId().equals (0)){
            
            this.profesorDao.deleteById(id);
        }else{
            System.out.println ("No existe el elemento con este id");
        }
        
        this.list(request, response);
         
     }
}
