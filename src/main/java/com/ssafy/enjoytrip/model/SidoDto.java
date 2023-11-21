package com.ssafy.enjoytrip.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SidoDto {
    private int sidoCode;
    private String sidoName;
}
