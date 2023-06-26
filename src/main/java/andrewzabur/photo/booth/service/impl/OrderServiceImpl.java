package andrewzabur.photo.booth.service.impl;

import andrewzabur.photo.booth.component.OrderFactory;
import andrewzabur.photo.booth.dto.order.OrderCreateDto;
import andrewzabur.photo.booth.dto.order.OrderDto;
import andrewzabur.photo.booth.model.Order;
import andrewzabur.photo.booth.model.PhotoType;
import andrewzabur.photo.booth.repository.OrderRepository;
import andrewzabur.photo.booth.service.OrderService;
import andrewzabur.photo.booth.service.PrizeEvaluationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final PrizeEvaluationService prizeEvaluationService;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;
    private final ObjectMapper mapper;

    @Transactional
    @Override
    public OrderDto placeOrder(OrderCreateDto orderCreateDto) {
        final Order order = orderFactory.createOrder(PhotoType.valueOf(orderCreateDto.getPhotoType()),
                prizeEvaluationService.isPrize());
        return mapper.convertValue(orderRepository.save(order), OrderDto.class);
    }

}
