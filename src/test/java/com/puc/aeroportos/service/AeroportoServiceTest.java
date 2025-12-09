package com.puc.aeroportos.service;

import com.puc.aeroportos.exception.AeroportoNaoEncontradoException;
import com.puc.aeroportos.repository.AeroportoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AeroportoServiceTest {

    @Mock
    private AeroportoRepository repository;

    @InjectMocks
    private AeroportoService service;



    @Test
    void deveConverterPesParaMetrosCorretamente() {
        Double resultado = service.converterPesParaMetros(1000.0);
        assertEquals(304.8, resultado);
    }

    @Test
    void deveRetornarBrParaBrasil() {
        String iso = service.obterIsoPais("Brazil");
        assertEquals("BR", iso);
    }

    @Test
    void deveLancarErroQuandoNaoEncontrarAeroporto() {
        when(repository.findByCodigoIata("XYZ")).thenReturn(Optional.empty());

        assertThrows(AeroportoNaoEncontradoException.class, () -> service.buscarPorIata("XYZ"));
    }
}