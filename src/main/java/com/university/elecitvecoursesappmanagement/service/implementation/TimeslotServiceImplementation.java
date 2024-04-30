package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Timeslot;
import com.university.elecitvecoursesappmanagement.repository.TimeslotRepository;
import com.university.elecitvecoursesappmanagement.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeslotServiceImplementation implements TimeslotService {
    @Autowired
    private final TimeslotRepository timeslotRepository;

    public TimeslotServiceImplementation(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    @Override
    public List<Timeslot> getAllTimeslot() {
        return timeslotRepository.findAll();
    }

    @Override
    public Optional<Timeslot> getTimeslotById(Long id) {
        return timeslotRepository.findById(id);
    }

    @Override
    public Timeslot addTimeslot(Timeslot timeslot) {
        return timeslotRepository.save(timeslot);
    }

    @Override
    public Timeslot updateTimeslot(Long id, Timeslot updateTimeslot) {
        Optional<Timeslot> existingTimeslot = timeslotRepository.findById(id);
        if(existingTimeslot.isPresent()) {
            Timeslot timeslotToUpdate = existingTimeslot.get();
            timeslotToUpdate.setBeginTime(updateTimeslot.getBeginTime());
            timeslotToUpdate.setEndTime(updateTimeslot.getEndTime());
            timeslotToUpdate.setWeekDay(updateTimeslot.getWeekDay());
            timeslotToUpdate.setDiscipline(updateTimeslot.getDiscipline());

            return timeslotRepository.save(timeslotToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTimeslotById(Long id) {
        timeslotRepository.deleteById(id);
    }

    @Override
    public void deleteAllTimeslots() {
        timeslotRepository.deleteAll();
    }

}
