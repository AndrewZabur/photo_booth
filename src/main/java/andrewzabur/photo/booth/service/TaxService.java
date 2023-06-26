package andrewzabur.photo.booth.service;

import andrewzabur.photo.booth.dto.tax.TaxCreateDto;
import andrewzabur.photo.booth.dto.tax.TaxDto;

public interface TaxService {

    TaxDto calculateTax(TaxCreateDto taxCreateDto);


}
