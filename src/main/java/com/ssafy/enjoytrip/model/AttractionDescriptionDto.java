package com.ssafy.enjoytrip.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AttractionDescriptionDto {
    private int contentId;
    private String homepage;
    private String overview;
    private String telname;
}
