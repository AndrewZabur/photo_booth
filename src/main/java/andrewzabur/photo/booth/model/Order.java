package andrewzabur.photo.booth.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "order", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "is_prize")
    private Boolean isPrize;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderPackage> orderPackages = new ArrayList<>();

}
