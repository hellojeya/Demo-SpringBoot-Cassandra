##Demo

##This repository contains the basic project skeleton required top set up Spring boot with Spring data JPA and Cassandra

##Technology Stack##
* Java 8
* SpringBoot
* SpringDataJPA
* SpringDataCassandra


##Create Scheme##

CREATE KEYSPACE meetup WITH durable_writes = true AND replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

##Create Table##
CREATE TABLE meetup.attendance ( attendeeid text, emails text, first_name text, last_name text, employer text, PRIMARY KEY (attendeeid) );
