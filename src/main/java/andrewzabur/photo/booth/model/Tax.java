package andrewzabur.photo.booth.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;

@Data
@Entity
@Table(name = "tax", schema = "public")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_sequence")
    @SequenceGenerator(name = "tax_sequence", sequenceName = "tax_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "month")
    @Enumerated(EnumType.STRING)
    private Month month;

    @Column(name = "year")
    private Integer year;

    @Column(name = "tax_percent")
    private Double taxPercent;

    @Column(name = "quantity_of_sold_packages")
    private Long quantityOfSoldPackages;

    @Column(name = "total_income")
    private BigDecimal totalIncome;

    @Column(name = "tax")
    private BigDecimal tax;
}
