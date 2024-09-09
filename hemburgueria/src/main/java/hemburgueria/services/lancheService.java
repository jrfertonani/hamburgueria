package hemburgueria.services;

import hemburgueria.domain.entity.DTO.lancheDTO;
import hemburgueria.domain.entity.Lanches;
import hemburgueria.repositories.lancheRepository;
import hemburgueria.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public lancheDTO findById(Integer id) {
        return mapper.map(
                repository.findById(id)
    .orElseThrow(() -> new ObjectNotFoundException("Lanche não encontrado! ID: " +id)
    ),lancheDTO.class
        );
    }

    public lancheDTO update(Integer id, lancheDTO dto) {
        Optional<Lanches> lancheOptional = repository.findById(id);

        // Verifica se o lanche existe
        if (lancheOptional.isPresent()) {
            Lanches lanche = lancheOptional.get();
            // Copia as propriedades do DTO para a entidade (evita NullPointerExceptions)
            BeanUtils.copyProperties(dto, lanche, "id"); // Ignora o ID para evitar sobrescrever

            return mapper.map(repository.save(lanche), lancheDTO.class);
        } else {
            throw new ObjectNotFoundException("Lanche não encontrado");
        }
    }

    public void delete(Integer id) {
        findById(id); // Verifica se o lanche existe
        repository.deleteById(id);
    }
}
