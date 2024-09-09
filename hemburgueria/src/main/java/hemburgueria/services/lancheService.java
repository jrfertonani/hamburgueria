package hemburgueria.services;

import hemburgueria.domain.entity.DTO.lancheDTO;
import hemburgueria.domain.entity.Lanches;
import hemburgueria.repositories.lancheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lancheService {

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private lancheRepository repository;


    public Lanches create(lancheDTO dto) {
        return repository.save(
                mapper.map(dto, Lanches.class)
        );
    }

    public List<Lanches> findAll() {
        return repository.findAll();
    }
}
