package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="timeslot")
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
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public Timeslot() {

    }

    public Timeslot(int beginTime, int endTime, String weekDay, Discipline discipline) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
        this.discipline = discipline;
    }

    public Timeslot(int beginTime, int endTime, String weekDay, String disciplineName) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", weekDay='" + weekDay + '\'' +
                ", discipline=" + discipline +
                '}';
    }
}
