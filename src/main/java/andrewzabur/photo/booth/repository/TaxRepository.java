package andrewzabur.photo.booth.repository;

import andrewzabur.photo.booth.dto.tax.IncomeSummaryDto;
import andrewzabur.photo.booth.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Month;
import java.util.Optional;

public interface TaxRepository extends JpaRepository<Tax, Long> {

    @Query(value = "SELECT new andrewzabur.photo.booth.dto.tax.IncomeSummaryDto(:month, :year, SUM(pp.price), COUNT(op.id)) " +
            "FROM OrderPackage op " +
            "JOIN op.order o " +
            "JOIN op.photoPackage pp " +
            "WHERE month(o.createdAt) = :month AND year(o.createdAt) = :year " +
            "AND op.orderPackageType = 'PAID'")
    IncomeSummaryDto calculateIncome(@Param("month") int month, @Param("year") int year);

    Optional<Tax> findByMonthAndYear(Month month, Integer year);
}
