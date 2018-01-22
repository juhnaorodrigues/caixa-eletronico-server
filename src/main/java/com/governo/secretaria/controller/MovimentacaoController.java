package com.governo.secretaria.controller;

import com.governo.secretaria.entity.Cedula;
import com.governo.secretaria.entity.request.QuantidadeCedulasRequest;
import com.governo.secretaria.repository.CedulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juhnao on 1/5/18.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value="rest/movimentacao")
public class MovimentacaoController {

    private CedulaRepository cedulaRepository;

    @Autowired
    public MovimentacaoController(CedulaRepository cedulaRepository) {

        this.cedulaRepository = cedulaRepository;
    }

    @RequestMapping(value = "rest/movimentacao/saque", method = RequestMethod.POST)
    public List<Cedula> sacarCedulas(@RequestBody QuantidadeCedulasRequest quantidadeCedulasRequest) {

        manutencaoCedulasBanco(quantidadeCedulasRequest, "SAQUE");

        return cedulaRepository.findAll();
    }

    @RequestMapping(value = "rest/movimentacao/deposito", method = RequestMethod.POST)
    public List<Cedula> depositarCedulas(@RequestBody QuantidadeCedulasRequest quantidadeCedulasRequest) {

        manutencaoCedulasBanco(quantidadeCedulasRequest, "DEPOSITO");

        return cedulaRepository.findAll();
    }

    private void manutencaoCedulasBanco(QuantidadeCedulasRequest quantidadeCedulasRequest, String tipoOperacao) {
        List<Cedula> cedulasBanco = cedulaRepository.findAll();

        for (Cedula cedula : cedulasBanco) {

            if( cedula.getValor() == 10 && quantidadeCedulasRequest.getQuantidadeCedulas10() > 0) {
                cedula.setQuantidade(efetuaOperacao(cedula.getQuantidade(), quantidadeCedulasRequest.getQuantidadeCedulas10(), tipoOperacao));
            }

            if( cedula.getValor() == 20 && quantidadeCedulasRequest.getQuantidadeCedulas20() > 0) {
                cedula.setQuantidade(efetuaOperacao(cedula.getQuantidade(), quantidadeCedulasRequest.getQuantidadeCedulas20(), tipoOperacao));
            }

            if( cedula.getValor() == 50 && quantidadeCedulasRequest.getQuantidadeCedulas50() > 0) {
                cedula.setQuantidade(efetuaOperacao(cedula.getQuantidade(), quantidadeCedulasRequest.getQuantidadeCedulas50(), tipoOperacao));
            }

            if( cedula.getValor() == 100 && quantidadeCedulasRequest.getQuantidadeCedulas100() > 0) {
                cedula.setQuantidade(efetuaOperacao(cedula.getQuantidade(), quantidadeCedulasRequest.getQuantidadeCedulas100(), tipoOperacao));
            }

            cedulaRepository.save(cedula);

        }
    }

    public int efetuaOperacao(int valorBanco, int valorRequest, String tipoOperacao) {

        int valorFinal = 0;

        if( "SAQUE".equalsIgnoreCase(tipoOperacao) ) {
            valorFinal = valorBanco - valorRequest;
        } else if ( "DEPOSITO".equalsIgnoreCase(tipoOperacao) ) {
            valorFinal = valorBanco + valorRequest;
        }

        return valorFinal;
    }

}
