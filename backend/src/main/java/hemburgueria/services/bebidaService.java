package hemburgueria.services;

import hemburgueria.domain.entity.Bebidas;
import hemburgueria.domain.entity.DTO.bebidaDTO;
import hemburgueria.repositories.bebidaRepository;
import hemburgueria.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bebidaService {


    @Autowired
    private ModelMapper mapper;


    @Autowired
    private bebidaRepository repository;


    public Bebidas create(bebidaDTO dto) {
        return repository.save(
                mapper.map(dto, Bebidas.class)
        );
    }


    public List<Bebidas> findAll() {
        return repository.findAll();
    }

    public bebidaDTO findById(Integer id) {
        return mapper.map(
        repository.findById(id)
                .orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! ID: " +id)
                ), bebidaDTO.class);
    }


    public Bebidas update(Integer id, bebidaDTO dto) {
        findById(id);
        return repository.save(
                mapper.map(dto, Bebidas.class));
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
