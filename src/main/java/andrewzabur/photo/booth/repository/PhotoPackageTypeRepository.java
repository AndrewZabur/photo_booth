package andrewzabur.photo.booth.repository;

import andrewzabur.photo.booth.model.PhotoPackage;
import andrewzabur.photo.booth.model.PhotoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoPackageTypeRepository extends JpaRepository<PhotoPackage, Long> {

    PhotoPackage findByPhotoType(PhotoType photoType);

    List<PhotoPackage> findByPhotoTypeNot(PhotoType photoType);

}
