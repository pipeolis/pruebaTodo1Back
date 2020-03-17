package com.todo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.model.Movimiento;
@Repository
public interface IMovimientoRepo extends JpaRepository<Movimiento, Integer>{

}
