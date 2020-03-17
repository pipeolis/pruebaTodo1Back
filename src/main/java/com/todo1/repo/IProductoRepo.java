package com.todo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.model.Producto;
@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
