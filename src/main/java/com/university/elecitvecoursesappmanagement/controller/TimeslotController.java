package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Timeslot;
import com.university.elecitvecoursesappmanagement.repo.TimeslotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TimeslotController {
    @Autowired
    TimeslotRepo timeslotRepo;

    @GetMapping("/getAllTimeslots")
    public ResponseEntity<List<Timeslot>> getAllTimeslots() {
        try {
            List<Timeslot> timeslotList = new ArrayList<>();
            timeslotRepo.findAll().forEach(timeslotList::add);

            if(timeslotList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(timeslotList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTimeslotById/{id}")
    public ResponseEntity<Timeslot> getTimeslotById(@PathVariable Long id) {
        Optional<Timeslot> timeslotObj = timeslotRepo.findById(id);
        if(timeslotObj.isPresent()) {
            return new ResponseEntity<>(timeslotObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addTimeslot")
    public ResponseEntity<Timeslot> addTimeslot(@RequestBody Timeslot timeslot) {
        try {
            Timeslot timeslotObj = timeslotRepo.save(timeslot);
            return new ResponseEntity<>(timeslotObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateTimeslot/{id}")
    public ResponseEntity<Timeslot> updateTimeslot(@PathVariable Long id, @RequestBody Timeslot timeslot) {
        try {
            Optional<Timeslot> timeslotData = timeslotRepo.findById(id);
            if(timeslotData.isPresent()) {
                Timeslot updateTimeslotData = timeslotData.get();
                updateTimeslotData.setBeginTime(timeslot.getBeginTime());
                updateTimeslotData.setEndTime(timeslot.getEndTime());
                updateTimeslotData.setWeekDay(timeslot.getWeekDay());
                updateTimeslotData.setUser(timeslot.getUser());

                Timeslot timeslotObj = timeslotRepo.save(updateTimeslotData);
                return new ResponseEntity<>(timeslotObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteTimeslotById/{id}")
    public ResponseEntity<HttpStatus> deleteTimeslot(@PathVariable Long id) {
        try {
            timeslotRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllTimeslots")
    public ResponseEntity<HttpStatus> deleteAllTimeslots() {
        try {
            timeslotRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
