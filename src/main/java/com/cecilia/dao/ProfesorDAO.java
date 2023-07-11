/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cecilia.dao;

import com.cecilia.model.Profesor;
import java.util.List;

/**
 *
 * @author escob
 */
public interface ProfesorDAO {
    //metodo q devuelve el listado de objetos
    public List <Profesor> findAll();
    
    //metodo que inserta un objeto en la base de datos
    
    public Profesor insert (Profesor objProfesor);
    
    //metodo que devuelve un objeto en base a su id
    
    public Profesor findById(Integer id);
    
    //metodo que modifica un objeto en la base de datos en base a su ID
    
    public Profesor updateById(Integer id, Profesor objProfesor);
    
    //metodo que elimina un objeto de la base de datos(BDD) en base a su id
    public Boolean deleteById(Integer id);
    
    
}