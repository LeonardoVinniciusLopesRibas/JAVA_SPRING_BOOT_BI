package br.com.estudo.calculos.bi.service;

import br.com.estudo.calculos.bi.model.Switches;
import br.com.estudo.calculos.bi.repository.SwitchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SwitchesService {

    @Autowired
    private SwitchesRepository switchesRepository;


    public List<Switches> get(String query) {

        Sort sort = Sort.by(Sort.Direction.ASC, "modelo");
        List<Switches> switchesList = switchesRepository.findAll(sort);
        String lowerCaseQuery = query.toLowerCase();

        return switchesList.stream()
                .filter(switches -> {
                    boolean matches = switches.getRegistro().toString().contains(lowerCaseQuery) ||
                            switches.getData().toString().contains(lowerCaseQuery) ||
                            switches.getHora().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getHostname().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getIp_address().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getMac_address().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getMarca().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getModelo().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getNum_serie().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getVersao().toLowerCase().contains(lowerCaseQuery) ||
                            switches.getImobilizado().toLowerCase().contains(lowerCaseQuery);
                    return matches;
                })

                .map(switches -> new Switches(
                        switches.getRegistro(),
                        switches.getData(),
                        switches.getHora(),
                        switches.getHostname(),
                        switches.getIp_address(),
                        switches.getMac_address(),
                        switches.getMarca(),
                        switches.getModelo(),
                        switches.getNum_serie(),
                        switches.getVersao(),
                        switches.getImobilizado()
                ))
                .collect(Collectors.toMap(
                        s -> s.getIp_address() + "_" + s.getNum_serie(),
                        s -> s,
                        (existing, replacement) -> existing)) 
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
