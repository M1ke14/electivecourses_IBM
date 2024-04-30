package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Timeslot;
import com.university.elecitvecoursesappmanagement.entity.User;
import com.university.elecitvecoursesappmanagement.service.implementation.TimeslotServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/timeslot")
public class TimeslotController {
    @Autowired
    private final TimeslotServiceImplementation timeslotServiceImplementation;

    public TimeslotController(TimeslotServiceImplementation timeslotServiceImplementation) {
        this.timeslotServiceImplementation = timeslotServiceImplementation;
    }

    @GetMapping("/getAllTimeslots")
    public List<Timeslot> getAllTimeslots() {
        return timeslotServiceImplementation.getAllTimeslot();
    }

    @GetMapping("/getTimeslotById/{id}")
    public Optional<Timeslot> getTimeslotById(@PathVariable Long id) {
        return timeslotServiceImplementation.getTimeslotById(id);
    }

    @PostMapping("/addTimeslot")
    public Timeslot addTimeslot(@RequestBody Timeslot timeslot) {
        return timeslotServiceImplementation.addTimeslot(timeslot);
    }

    @PostMapping("/updateTimeslot/{id}")
    public Timeslot updateTimeslot(@PathVariable Long id, @RequestBody Timeslot timeslot) {
        return timeslotServiceImplementation.updateTimeslot(id, timeslot);
    }

    @DeleteMapping("/deleteTimeslotById/{id}")
    public void deleteTimeslot(@PathVariable Long id) {
        timeslotServiceImplementation.deleteTimeslotById(id);
    }

    @DeleteMapping("/deleteAllTimeslots")
    public void deleteAllTimeslots() {
        timeslotServiceImplementation.deleteAllTimeslots();
    }
}
