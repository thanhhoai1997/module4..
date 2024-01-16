package com.example.th_qlkh_tinh.formatter;

import com.example.th_qlkh_tinh.model.Province;
import com.example.th_qlkh_tinh.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter  implements Formatter<Province> {
    private IProvinceService iProvinceService;
    @Autowired

    public ProvinceFormatter(IProvinceService iProvinceService) {
        this.iProvinceService = iProvinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> provinceOptional = iProvinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }


    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
