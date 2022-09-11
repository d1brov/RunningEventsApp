package com.portfolio.app.persistence.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RecordId implements Serializable {
    @Id
    @Column(name = "race_id")
    private Integer raceId;

    @Id
    @Column(name = "user_id")
    private Integer userId;
}