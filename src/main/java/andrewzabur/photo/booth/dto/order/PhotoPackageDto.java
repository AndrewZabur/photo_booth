package andrewzabur.photo.booth.dto.order;

import andrewzabur.photo.booth.model.PhotoType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PhotoPackageDto {

    private BigDecimal price;

    private String dimension;

    private PhotoType photoType;

}
