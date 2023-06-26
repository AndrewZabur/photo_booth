package andrewzabur.photo.booth.service.impl;

import andrewzabur.photo.booth.model.Order;
import andrewzabur.photo.booth.repository.OrderRepository;
import andrewzabur.photo.booth.service.PrizeEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrizeEvaluationServiceImpl implements PrizeEvaluationService {

    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public Boolean isPrize() {
        final Instant currentHour = Instant.now().truncatedTo(ChronoUnit.HOURS);
        Optional<Order> lastWinningOrder =
                orderRepository.findFirstByIsPrizeTrueAndCreatedAtAfterOrderByCreatedAt(currentHour);

        return lastWinningOrder.isEmpty();
    }
}
