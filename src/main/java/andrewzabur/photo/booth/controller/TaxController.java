package andrewzabur.photo.booth.controller;

import andrewzabur.photo.booth.dto.tax.TaxCreateDto;
import andrewzabur.photo.booth.dto.tax.TaxDto;
import andrewzabur.photo.booth.service.TaxService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaxController {

    private final TaxService taxService;

    @PostMapping("/tax")
    public ResponseEntity<TaxDto> calculate(@Valid @RequestBody TaxCreateDto taxCreateDto) {
        final TaxDto taxDto = taxService.calculateTax(taxCreateDto);

        return ResponseEntity.ok(taxDto);
    }

}
