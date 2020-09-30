package com.example.adboard.util;

import com.example.adboard.domain.complaint.Complaint;
import com.example.adboard.web.form.ComplaintForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "addressedUser", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "reason", source = "reason"),
    })
    Complaint toComplaint(ComplaintForm form);
}
