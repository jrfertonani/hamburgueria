package hemburgueria.repositories;

import hemburgueria.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepositiory extends JpaRepository<Cliente, Integer> {
}
