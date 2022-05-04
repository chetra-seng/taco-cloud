package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String Zip);

}
