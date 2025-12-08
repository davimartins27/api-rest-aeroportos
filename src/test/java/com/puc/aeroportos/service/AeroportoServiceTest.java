package com.puc.aeroportos.service;

import com.puc.aeroportos.service.AeroportoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AeroportoServiceTest {

    private final AeroportoService service = new AeroportoService();

    @Test
    void deveConverterPesParaMetrosCorretamente() {
        Double pes = 1000.0;

        Double metros = service.converterPesParaMetros(pes);

        assertEquals(304.8, metros);
    }

    @Test
    void deveRetornarBrParaBrasil() {
        String pais = "Brazil";

        String iso = service.obterIsoPais(pais);

        assertEquals("BR", iso);
    }
}