package sia.tacocloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.model.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
