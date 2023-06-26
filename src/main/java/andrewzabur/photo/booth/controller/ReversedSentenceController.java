package andrewzabur.photo.booth.controller;

import andrewzabur.photo.booth.dto.reversedSentence.ReversedSentenceCreateDto;
import andrewzabur.photo.booth.dto.reversedSentence.ReversedSentenceDto;
import andrewzabur.photo.booth.service.ReversedSentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReversedSentenceController {

    private final ReversedSentenceService reversedSentenceService;

    @GetMapping("/all-reversed-sentences")
    public ResponseEntity<List<ReversedSentenceDto>> getAllReversedSentences() {
        final List<ReversedSentenceDto> reversedSentenceDtos = reversedSentenceService.getAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reversedSentenceDtos);
    }

    @PostMapping("/reversed-sentence")
    public ResponseEntity<ReversedSentenceDto> reverseSentence(ReversedSentenceCreateDto reversedSentenceCreateDto) {
        final ReversedSentenceDto reversedSentenceDto = reversedSentenceService
                .reverseSentence(reversedSentenceCreateDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reversedSentenceDto);
    }

}
