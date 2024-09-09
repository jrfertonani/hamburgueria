package hemburgueria.repositories;

import hemburgueria.domain.entity.Lanches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface lancheRepository extends JpaRepository<Lanches, Integer> {
}
