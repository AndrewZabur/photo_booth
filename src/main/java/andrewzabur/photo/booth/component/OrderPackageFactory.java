package andrewzabur.photo.booth.component;

import andrewzabur.photo.booth.model.*;
import andrewzabur.photo.booth.repository.PhotoPackageTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderPackageFactory {

    private final PhotoPackageTypeRepository photoPackageTypeRepository;

    @Transactional
    public OrderPackage createPaidOrderPackage(Order order, PhotoType photoType) {
        final PhotoPackage paidPhotoPackage = photoPackageTypeRepository.findByPhotoType(photoType);
        return createOrderPackage(order, paidPhotoPackage, OrderPackageType.PAID);
    }

    @Transactional
    public List<OrderPackage> createFreeOrderPackages(Order order, PhotoType photoType) {
        final List<PhotoPackage> freePhotoPackages = photoPackageTypeRepository.findByPhotoTypeNot(photoType);
        return freePhotoPackages.stream()
                .map(freePhotoPackage ->
                        createOrderPackage(order, freePhotoPackage, OrderPackageType.FREE))
                .toList();
    }

    private OrderPackage createOrderPackage(Order order, PhotoPackage photoPackage, OrderPackageType orderPackageType) {
        final OrderPackage orderPackage = new OrderPackage();
        orderPackage.setOrder(order);
        orderPackage.setPhotoPackage(photoPackage);
        orderPackage.setOrderPackageType(orderPackageType);
        return orderPackage;
    }

}
