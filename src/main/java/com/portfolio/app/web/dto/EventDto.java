package com.portfolio.app.web.dto;

import com.portfolio.app.persistence.model.Race;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDto {
    private Integer id;
    private String name;
    private String description;
    private List<Race> races;
}