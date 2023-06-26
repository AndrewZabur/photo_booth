package andrewzabur.photo.booth.service;

import andrewzabur.photo.booth.dto.reversedSentence.ReversedSentenceCreateDto;
import andrewzabur.photo.booth.dto.reversedSentence.ReversedSentenceDto;

import java.util.List;

public interface ReversedSentenceService {

    List<ReversedSentenceDto> getAll();

    ReversedSentenceDto reverseSentence(ReversedSentenceCreateDto reversedSentenceCreateDto);

}
