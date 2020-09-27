package com.example.adboard.util;

import com.example.adboard.domain.ad.Ad;
import com.example.adboard.web.form.AdForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AdMapper {

    @Mappings({
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "price", source = "price"),
    })
    Ad toAd(AdForm form);
}
