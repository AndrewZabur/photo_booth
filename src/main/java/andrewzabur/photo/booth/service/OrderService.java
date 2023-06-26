package andrewzabur.photo.booth.service;

import andrewzabur.photo.booth.dto.order.OrderCreateDto;
import andrewzabur.photo.booth.dto.order.OrderDto;

public interface OrderService {

    OrderDto placeOrder(OrderCreateDto orderCreateDto);

}
