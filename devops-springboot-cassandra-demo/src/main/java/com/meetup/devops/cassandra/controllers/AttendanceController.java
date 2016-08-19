package com.meetup.devops.cassandra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meetup.devops.cassandra.domain.Attendance;
import com.meetup.devops.cassandra.services.AttendanceService;


@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @RequestMapping( method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<List<Attendance>> getAttendees(){
        return new ResponseEntity(service.getAttendance(), HttpStatus.OK);
    }


    @RequestMapping( method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
    public ResponseEntity<Attendance> addUser(@RequestBody Attendance attendance){
    	Attendance attendanceCreated = service.createAttendance(attendance);
        return new ResponseEntity(attendanceCreated, HttpStatus.CREATED);
    }

    @RequestMapping( path = "/{id}", method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable String id){
        if(!service.exitsAttendance(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Attendance attendance = service.findAttendanceById(id);
        return new ResponseEntity(attendance,HttpStatus.ACCEPTED);
    }

    @RequestMapping(  method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Attendance> editUser(@RequestBody Attendance attendance){
        if(attendance.getAttendeeid() == null || !service.exitsAttendance(attendance.getAttendeeid())){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Attendance attendanceEdited = service.editAttendance(attendance);
        return new ResponseEntity(attendanceEdited, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Attendance> deleteUser(@PathVariable String id){
        if(!service.exitsAttendance(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Attendance attendance = service.findAttendanceById(id);
        service.deleteAttendance(id);
        return new ResponseEntity(attendance, HttpStatus.ACCEPTED);

    }

}
