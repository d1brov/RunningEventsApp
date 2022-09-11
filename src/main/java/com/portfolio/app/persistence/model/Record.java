package com.portfolio.app.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "records")
@IdClass(RecordId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    @Column(name = "race_id")
    @JsonIgnore
    private Integer raceId;

    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private Integer userId;

    @ManyToOne
    @MapsId("raceId")
    @JsonIgnore
    private Race race;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @Column(name = "bib_number")
    private Integer bibNumber;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "finish_time")
    private LocalTime finishTime;
}
