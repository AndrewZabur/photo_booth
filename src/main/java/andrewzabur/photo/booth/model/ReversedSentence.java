package andrewzabur.photo.booth.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reversed_sentence", schema = "public")
public class ReversedSentence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reversed_sentence_sequence")
    @SequenceGenerator(name = "reversed_sentence_sequence", sequenceName = "reversed_sentence_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "original_sentence", columnDefinition = "TEXT")
    private String originalSentence;

    @Column(name = "reversed_sentence", columnDefinition = "TEXT")
    private String reversedSentence;

}
