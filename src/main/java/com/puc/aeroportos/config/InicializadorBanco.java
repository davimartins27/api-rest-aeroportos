package com.puc.aeroportos.config;

import com.puc.aeroportos.model.Aeroporto;
import com.puc.aeroportos.repository.AeroportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import jakarta.transaction.Transactional;

import java.util.Arrays;

@Configuration
public class InicializadorBanco implements CommandLineRunner {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Verifica se a tabela já tem dados para não duplicar
        if (aeroportoRepository.count() == 0) {

            Aeroporto confins = new Aeroporto();
            confins.setNomeAeroporto("Tancredo Neves International Airport");
            confins.setCodigoIata("CNF");
            confins.setCidade("Belo Horizonte");
            confins.setCodigoPaisIso("BR");
            confins.setLatitude(-19.6244);
            confins.setLongitude(-43.9719);
            confins.setAltitude(827.0);

            Aeroporto guarulhos = new Aeroporto();
            guarulhos.setNomeAeroporto("Guarulhos - Governador André Franco Montoro International Airport");
            guarulhos.setCodigoIata("GRU");
            guarulhos.setCidade("São Paulo");
            guarulhos.setCodigoPaisIso("BR");
            guarulhos.setLatitude(-23.4356);
            guarulhos.setLongitude(-46.4731);
            guarulhos.setAltitude(750.0);

            aeroportoRepository.saveAll(Arrays.asList(confins, guarulhos));

            System.out.println("-------------------------------------------------");
            System.out.println(" BANCO DE DADOS INICIALIZADO COM SUCESSO! ");
            System.out.println("-------------------------------------------------");
        }
    }
}