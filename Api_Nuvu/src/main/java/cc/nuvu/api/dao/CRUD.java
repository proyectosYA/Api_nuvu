/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.dao;

import cc.nuvu.api.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Yio
 */
public interface CRUD<T> {

    boolean anadir(T object);

    boolean modificar(T object);

    T buscar(long key);

    List<T> listar();
}
