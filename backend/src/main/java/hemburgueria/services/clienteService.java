package hemburgueria.services;

import hemburgueria.domain.entity.Clientes;
import hemburgueria.domain.DTO.clienteDTO;
import hemburgueria.repositories.clienteRepository;
import hemburgueria.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private clienteRepository repository;

    public Clientes create(clienteDTO dto) {
        return repository.save(
                mapper.map(dto, Clientes.class)
        );
    }

    public List<Clientes> findAll() {
        return repository.findAll();
    }

    public Clientes findById(Integer id) {
        return repository.findById(id).orElseThrow(
       () -> new ObjectNotFoundException("Objeto não encontrado! ID: " +id)
        );
    }

    public Clientes update(Integer id, clienteDTO dto) {
        findById(id);
        return repository.save(
                mapper.map(dto, Clientes.class)
        );
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
