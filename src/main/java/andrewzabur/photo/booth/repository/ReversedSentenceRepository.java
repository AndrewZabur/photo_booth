package andrewzabur.photo.booth.repository;

import andrewzabur.photo.booth.model.ReversedSentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReversedSentenceRepository extends JpaRepository<ReversedSentence, Long> {
}
