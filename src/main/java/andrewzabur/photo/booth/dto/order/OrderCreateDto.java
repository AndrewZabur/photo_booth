package andrewzabur.photo.booth.dto.order;

import andrewzabur.photo.booth.annotation.EnumValueConstraint;
import andrewzabur.photo.booth.model.PhotoType;
import lombok.Data;

@Data
public class OrderCreateDto {

    @EnumValueConstraint(enumClass = PhotoType.class)
    private String photoType;

}
