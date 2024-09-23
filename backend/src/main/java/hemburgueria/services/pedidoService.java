package hemburgueria.services;


import hemburgueria.repositories.pedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pedidoService {

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private pedidoRepository pedidoRepository;

    @Autowired
    private clienteService clienteService;

    @Autowired
    private lancheService lancheService;


}
