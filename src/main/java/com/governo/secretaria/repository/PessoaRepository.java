package com.governo.secretaria.repository;

import com.governo.secretaria.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Juhnao on 1/16/18.
 */
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    List<Pessoa> findByLoginAndSenha(String login, String senha);
}
