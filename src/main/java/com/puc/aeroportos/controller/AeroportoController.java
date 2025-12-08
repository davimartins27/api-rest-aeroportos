package com.puc.aeroportos.controller;

import com.puc.aeroportos.model.Aeroporto;
import com.puc.aeroportos.service.AeroportoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoService service;

    @GetMapping
    public List<Aeroporto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{iata}")
    public ResponseEntity<Aeroporto> buscarPorIata(@PathVariable String iata) {
        Aeroporto aeroporto = service.buscarPorIata(iata);
        return ResponseEntity.ok(aeroporto);
    }

    @PostMapping
    public ResponseEntity<Aeroporto> criar(@RequestBody @Valid Aeroporto aeroporto) {
        Aeroporto aeroportoSalvo = service.salvar(aeroporto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aeroportoSalvo);
    }

    @PutMapping("/{iata}")
    public ResponseEntity<Aeroporto> atualizar(@PathVariable String iata, @RequestBody @Valid Aeroporto aeroportoAtualizado) {
        Aeroporto aeroportoExistente = service.buscarPorIata(iata);

        aeroportoExistente.setNomeAeroporto(aeroportoAtualizado.getNomeAeroporto());
        aeroportoExistente.setCidade(aeroportoAtualizado.getCidade());
        aeroportoExistente.setCodigoPaisIso(aeroportoAtualizado.getCodigoPaisIso());
        aeroportoExistente.setLatitude(aeroportoAtualizado.getLatitude());
        aeroportoExistente.setLongitude(aeroportoAtualizado.getLongitude());
        aeroportoExistente.setAltitude(aeroportoAtualizado.getAltitude());

        service.salvar(aeroportoExistente);

        return ResponseEntity.ok(aeroportoExistente);
    }

    @DeleteMapping("/{iata}")
    public ResponseEntity<Void> deletar(@PathVariable String iata) {
        service.deletar(iata);
        return ResponseEntity.noContent().build();
    }
}