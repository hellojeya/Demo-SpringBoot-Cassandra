package com.meetup.devops.cassandra.domain;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Set;



@Table
public class Attendance {

    @PrimaryKeyColumn(name = "attendeeid", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String attendeeid;
    @Column
    private String emails;
    @Column
    private String first_name;
    @Column
    private String last_name;

    public String getAttendeeid() {
        return attendeeid;
    }

    public void setAttendeeid(String attendeeid) {
        this.attendeeid = attendeeid;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
