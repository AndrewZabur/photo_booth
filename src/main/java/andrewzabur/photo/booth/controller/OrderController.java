package andrewzabur.photo.booth.controller;

import andrewzabur.photo.booth.dto.order.OrderCreateDto;
import andrewzabur.photo.booth.dto.order.OrderDto;
import andrewzabur.photo.booth.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody @Valid OrderCreateDto orderCreateDto) {
        final OrderDto orderDto = orderService.placeOrder(orderCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderDto);
    }

}
