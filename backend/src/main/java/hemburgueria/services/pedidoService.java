package hemburgueria.services;

import hemburgueria.repositories.lancheRepository;
import hemburgueria.repositories.pedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class pedidoService {

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private pedidoRepository repository;


}
