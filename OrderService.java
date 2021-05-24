package ru.geekbrains.april.market.HW;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.models.Order;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.repositories.OrderRepository;
import ru.geekbrains.april.market.utils.Cart;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
    private final Cart cart;


    public List<Order> findAllByUser(User user)
    {
        return orderRepository.findAllByUser(user);
    }

    public Order createOrderForCurrentUser(User user, PreOrderDetails preOrderDetails)
    {
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getSum());
        order.setAddress(preOrderDetails.getAddress());
        order.setPhoone(preOrderDetails.getPhone());
        order.setItems(cart.getItems());
        cart.setOrder(order);
        order = orderRepository.save(order);


        cart.clear();
        return order;
    }
}
