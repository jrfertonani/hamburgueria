package hemburgueria.repositories;

import hemburgueria.domain.entity.Bebidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bebidaRepository extends JpaRepository<Bebidas, Integer> {
}
