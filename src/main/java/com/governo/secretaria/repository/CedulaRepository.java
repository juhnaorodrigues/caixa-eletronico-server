package com.governo.secretaria.repository;

import com.governo.secretaria.entity.Cedula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Juhnao on 1/11/18.
 */
@Repository
public interface CedulaRepository extends JpaRepository<Cedula, Long> {
}
