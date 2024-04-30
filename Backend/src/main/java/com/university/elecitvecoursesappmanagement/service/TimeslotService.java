package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Timeslot;

import java.util.List;
import java.util.Optional;

public interface TimeslotService {
    List<Timeslot> getAllTimeslot();

    Optional<Timeslot> getTimeslotById(Long id);

    Timeslot addTimeslot(Timeslot timeslot);

    Timeslot updateTimeslot(Long id, Timeslot updateTimeslot);

    void deleteTimeslotById(Long id);

    void deleteAllTimeslots();
}
