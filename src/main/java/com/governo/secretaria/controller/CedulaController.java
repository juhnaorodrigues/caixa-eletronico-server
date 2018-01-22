package com.governo.secretaria.controller;

import com.governo.secretaria.entity.Cedula;
import com.governo.secretaria.repository.CedulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Juhnao on 1/17/18.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CedulaController {


    private CedulaRepository cedulaRepository;

    @Autowired
    public CedulaController(CedulaRepository cedulaRepository) {

        this.cedulaRepository = cedulaRepository;
    }

    @RequestMapping(value = "rest/cedula/findAll", method = RequestMethod.GET)
    public List<Cedula> findAll() {
        return cedulaRepository.findAll();
    }

}
