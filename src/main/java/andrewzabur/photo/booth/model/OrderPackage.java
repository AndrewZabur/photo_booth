package andrewzabur.photo.booth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@ToString(exclude = {"order"})
@Data
@Entity
@Table(name = "order_package", schema = "public")
public class OrderPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_package_sequence")
    @SequenceGenerator(name = "order_package_sequence", sequenceName = "order_package_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "photo_package_id")
    private PhotoPackage photoPackage;

    @Column(name = "order_package_type")
    @Enumerated(EnumType.STRING)
    private OrderPackageType orderPackageType;

}
