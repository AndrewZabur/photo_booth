package andrewzabur.photo.booth.dto.order;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderDto {

    private Instant createdAt;

    private List<OrderPackageDto> orderPackages;

}
