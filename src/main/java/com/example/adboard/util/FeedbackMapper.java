package com.example.adboard.util;

import com.example.adboard.domain.feedback.Feedback;
import com.example.adboard.web.form.FeedbackForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "text", source = "text"),
            @Mapping(target = "rating", source = "rating"),
            @Mapping(target = "ad", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
    })
    Feedback toFeedback(FeedbackForm form);
}
