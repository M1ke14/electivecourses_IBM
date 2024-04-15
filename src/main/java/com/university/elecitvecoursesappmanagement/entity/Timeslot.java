package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "timeslot")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int beginTime;

    @Column
    private int endTime;

    @Column
    private String weekDay;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
