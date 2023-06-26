package andrewzabur.photo.booth.dto.order;

import andrewzabur.photo.booth.model.OrderPackageType;
import lombok.Data;

@Data
public class OrderPackageDto {

    private PhotoPackageDto photoPackage;

    private OrderPackageType orderPackageType;

}
