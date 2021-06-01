package ru.geekbrains.april.market.HW;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.error_handling.ResourceNotFoundException;
import ru.geekbrains.april.market.models.OrderItem;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.services.ProductService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class CartService
{
    private final ProductService productService;
    private  final Cart cart;



    public  void addToCart(Long id) {
        for (OrderItem orderItem : cart.getItems()) {
            if (orderItem.getProduct().getId().equals(id)) {
                orderItem.incrementQuantity();
                cart.recalculate();
                return;
            }
        }

        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + id + " (add to cart)"));
        cart.items.add(new OrderItem(product));
        cart.recalculate();
    }


    public List<OrderItem> getItems()
    {
        return Collections.unmodifiableList(cart.getItems());
    }
}
