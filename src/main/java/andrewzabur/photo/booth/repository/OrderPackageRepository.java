package andrewzabur.photo.booth.repository;

import andrewzabur.photo.booth.model.OrderPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderPackageRepository extends JpaRepository<OrderPackage, Long> {

    @Query(value = "SELECT COUNT(op.id) FROM OrderPackage op " +
            "JOIN op.order o " +
            "JOIN op.photoPackage pp " +
            "WHERE month(o.createdAt) = :month AND year(o.createdAt) = :year " +
            "AND op.orderPackageType = 'PAID'")
    Long countPaidOrderPackages(@Param("month") int month, @Param("year") int year);

}
