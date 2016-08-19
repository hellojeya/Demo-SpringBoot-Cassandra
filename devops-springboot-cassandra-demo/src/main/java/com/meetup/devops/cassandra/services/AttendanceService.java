package com.meetup.devops.cassandra.services;

import static org.springframework.data.cassandra.repository.support.BasicMapId.id;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import com.meetup.devops.cassandra.domain.Attendance;
import com.meetup.devops.cassandra.repository.AttendanceRepository;


@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance createAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public Attendance findAttendanceById(String attendeeid){
        MapId id = id("attendeeid", attendeeid);
        return attendanceRepository.findOne(id);
    }

    public List<Attendance> getAttendance(){
        return (List<Attendance>) attendanceRepository.findAll();
    }

    public Attendance editAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(String attendeeid){
        MapId id = id("attendeeid", attendeeid);
        attendanceRepository.delete(id);
    }

    public boolean exitsAttendance(String attendeeid){
        MapId id = id("attendeeid", attendeeid);
        return attendanceRepository.exists(id);
    }

}
