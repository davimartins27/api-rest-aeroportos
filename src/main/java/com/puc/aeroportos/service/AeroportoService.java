package com.puc.aeroportos.service;

import com.puc.aeroportos.exception.AeroportoNaoEncontradoException;
import com.puc.aeroportos.model.Aeroporto;
import com.puc.aeroportos.repository.AeroportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportoService {

    @Autowired
    private AeroportoRepository repository;

    public List<Aeroporto> listarTodos() {
        return repository.findAll();
    }

    public Aeroporto buscarPorIata(String iata) {
        return repository.findByCodigoIata(iata)
                .orElseThrow(() -> new AeroportoNaoEncontradoException(iata));
    }

    public Aeroporto salvar(Aeroporto aeroporto) {
        return repository.save(aeroporto);
    }

    public void deletar(String iata) {
        Aeroporto aeroporto = buscarPorIata(iata);
        repository.delete(aeroporto);
    }

    public Double converterPesParaMetros(Double pes) {
        return pes * 0.3048;
    }

    public String obterIsoPais(String nomePais) {
        if ("Brazil".equalsIgnoreCase(nomePais)) return "BR";
        if ("United States".equalsIgnoreCase(nomePais)) return "US";
        return "XX";
    }
}