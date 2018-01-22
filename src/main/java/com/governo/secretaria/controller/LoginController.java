package com.governo.secretaria.controller;

import com.governo.secretaria.entity.Pessoa;
import com.governo.secretaria.entity.PessoaToken;
import com.governo.secretaria.entity.request.PessoaRequest;
import com.governo.secretaria.repository.PessoaRepository;
import com.governo.secretaria.security.JwtGenerator;
import com.governo.secretaria.security.entity.JwtUser;
//import com.governo.secretaria.security.entity.JwtUserDetails;
import com.governo.secretaria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juhnao on 1/16/18.
 */
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

    private PessoaRepository pessoaRepository;
    private JwtGenerator jwtGenerator;

    @Autowired
    public LoginController(PessoaRepository repositorio, JwtGenerator jwtGenerator) {

        this.jwtGenerator = jwtGenerator;

        this.pessoaRepository = repositorio;
    }

//    @RequestMapping(value = "/findUserLogin", method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.POST)
    public PessoaToken findUserLogin(@RequestBody PessoaRequest pessoaRequest) throws Exception{
        List<Pessoa> pessoas = pessoaRepository.findByLoginAndSenha(pessoaRequest.getLogin(), Util.md5(pessoaRequest.getSenha()));
        Pessoa pessoa = new Pessoa();

        if ( pessoas != null && !pessoas.isEmpty() ) {
            pessoa = pessoas.get(0);
        } else {
//            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }

        JwtUser jwtUser = new JwtUser();
        jwtUser.setLogin(pessoa.getLogin());
        jwtUser.setId(pessoa.getId());
        jwtUser.setRole(pessoa.getRole());

        String token = jwtGenerator.generate(jwtUser);

        PessoaToken pessoaToken = new PessoaToken();
        pessoaToken.setPessoa(pessoa);
        pessoaToken.setToken(token);

        return pessoaToken;
    }

}
