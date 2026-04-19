package com.nelson.urlsaver.entity; // Make sure this matches your folder path!

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// tells Spring to monitor this class - when app starts, check the DB
// if a table named 'url' (default to lowercase in Spring) doesn't exist, create one to look exactly like this class
@Entity // @Entity creates Table INSIDE the DB (database is H2, Url.java is the Entity) -> blueprint for specific table in the db
@Data // Quality of Life tool -> @Data writes all the getId(), setId(), getOriginalUrl(), toString(), equals()
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells DB, handle the numbering, just give next avail number
    private Long id; // every row in db must have unique finterprint

    private String originalUrl;
}