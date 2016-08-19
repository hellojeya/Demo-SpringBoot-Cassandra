package com.meetup.devops.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.meetup.devops.cassandra.domain.Attendance;


public interface AttendanceRepository extends CassandraRepository<Attendance> {
}
