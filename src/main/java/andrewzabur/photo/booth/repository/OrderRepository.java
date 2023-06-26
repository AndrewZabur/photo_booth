package andrewzabur.photo.booth.repository;

import andrewzabur.photo.booth.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findFirstByIsPrizeTrueAndCreatedAtAfterOrderByCreatedAt(Instant currentHour);

}
