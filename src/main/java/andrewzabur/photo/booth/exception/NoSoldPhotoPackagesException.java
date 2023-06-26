package andrewzabur.photo.booth.exception;

public class NoSoldPhotoPackagesException extends RuntimeException {

    public NoSoldPhotoPackagesException() {
    }

    public NoSoldPhotoPackagesException(String message) {
        super(message);
    }

    public NoSoldPhotoPackagesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSoldPhotoPackagesException(Throwable cause) {
        super(cause);
    }
}
