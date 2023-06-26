package andrewzabur.photo.booth.component;

import andrewzabur.photo.booth.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFactory {

    private final OrderPackageFactory orderPackageFactory;

    public Order createOrder(PhotoType photoType, Boolean isPrize) {
        final Order order = new Order();
        order.setCreatedAt(Instant.now());
        order.setIsPrize(isPrize);
        addPaidOrderPackage(order, orderPackageFactory.createPaidOrderPackage(order, photoType));
        if (isPrize) {
            addFreeOrderPackages(order, orderPackageFactory.createFreeOrderPackages(order, photoType));
        }
        return order;
    }

    private void addPaidOrderPackage(Order order, OrderPackage paidOrderPackage) {
        order.getOrderPackages().add(paidOrderPackage);
    }

    private void addFreeOrderPackages(Order order, List<OrderPackage> freeOrderPackages) {
        order.getOrderPackages().addAll(freeOrderPackages);
    }
}
