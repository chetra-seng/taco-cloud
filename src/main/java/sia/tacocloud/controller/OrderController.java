package sia.tacocloud.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.model.Order;
import sia.tacocloud.repository.OrderRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public Order putOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @PatchMapping(value = "/{orderId}", consumes = APPLICATION_JSON_VALUE)
    public Order patchOrder(@PathVariable Long orderId, @RequestBody Order order){
       Order oldOrder = orderRepository.findById(orderId).get();
       if(order.getName() != null){
           oldOrder.setName(order.getName());
       }
       if (order.getStreet() != null){
           oldOrder.setStreet(order.getStreet());
       }
       if (order.getCity() != null) {
           oldOrder.setCity(order.getCity());
       }
       if(order.getState() != null){
           oldOrder.setState(order.getState());
       }
       if(order.getZip() != null){
           oldOrder.setZip(order.getZip());
       }
       if(order.getCcNumber() != null) {
           oldOrder.setCcNumber(order.getCcNumber());
       }
       if(order.getCcExpiration() != null){
           oldOrder.setCcExpiration(order.getCcExpiration());
       }
       if(order.getCcCVV() != null){
           oldOrder.setCcCVV(order.getCcCVV());
       }

       return orderRepository.save(oldOrder);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long orderId){
        try {
            orderRepository.deleteById(orderId);
        }
        catch (EmptyResultDataAccessException ex){

        }
    }
}