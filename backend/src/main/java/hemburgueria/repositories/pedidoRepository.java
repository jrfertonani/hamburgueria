package hemburgueria.repositories;

import hemburgueria.domain.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pedidoRepository extends JpaRepository<Pedidos, Integer> {
}
