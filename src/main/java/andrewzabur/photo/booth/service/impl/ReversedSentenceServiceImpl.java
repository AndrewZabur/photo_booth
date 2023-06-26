package andrewzabur.photo.booth.service.impl;

import andrewzabur.photo.booth.dto.reversedSentence.ReversedSentenceCreateDto;
import andrewzabur.photo.booth.dto.reversedSentence.ReversedSentenceDto;
import andrewzabur.photo.booth.model.ReversedSentence;
import andrewzabur.photo.booth.repository.ReversedSentenceRepository;
import andrewzabur.photo.booth.service.ReversedSentenceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReversedSentenceServiceImpl implements ReversedSentenceService {

    private final ReversedSentenceRepository reversedSentenceRepository;
    private final ObjectMapper mapper;

    @Transactional
    @Override
    public List<ReversedSentenceDto> getAll() {
        return mapper.convertValue(reversedSentenceRepository.findAll(), new TypeReference<>() {});
    }

    @Transactional
    @Override
    public ReversedSentenceDto reverseSentence(ReversedSentenceCreateDto reversedSentenceCreateDto) {
        final String reversedSentence = new StringBuilder(reversedSentenceCreateDto.getOriginalSentence())
                .reverse()
                .toString();

        final ReversedSentence reversedEntity = new ReversedSentence();
        reversedEntity.setOriginalSentence(reversedSentenceCreateDto.getOriginalSentence());
        reversedEntity.setReversedSentence(reversedSentence);

        return mapper.convertValue(reversedSentenceRepository.save(reversedEntity), ReversedSentenceDto.class);
    }
}
