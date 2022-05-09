package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.model.Order;
import sia.tacocloud.model.User;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String Zip);

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
