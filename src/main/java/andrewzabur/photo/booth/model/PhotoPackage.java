package andrewzabur.photo.booth.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "photo_package_type", schema = "public")
public class PhotoPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_package_type_sequence")
    @SequenceGenerator(name = "photo_package_type_sequence", sequenceName = "photo_package_type_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "price", columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal price;

    @Column(name = "dimension")
    private String dimension;

    @Column(name = "photo_type", unique = true)
    @Enumerated(EnumType.STRING)
    private PhotoType photoType;

}
