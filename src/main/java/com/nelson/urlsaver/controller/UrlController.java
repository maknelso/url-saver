package com.nelson.urlsaver.controller;

import com.nelson.urlsaver.entity.Url;
import com.nelson.urlsaver.repository.UrlRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing URL-related web requests.
 * Handles the creation and retrieval of shortened or saved URLs.
 */
@RestController // Tells Spring this class handles web requests
@RequestMapping("/api/urls") // The "base path" for all methods in this class
@RequiredArgsConstructor // Automatically generates the constructor for all 'final' fields
public class UrlController {

    // Declaration - no other class should be touching the controller's db connection
    // final - ensures once repository is set up and never changed. make controller immutable
    // Controller has full access urlRepository's methods like .save()
    // Composition simply means - a class contains another class as a field
    private final UrlRepository urlRepository;

    // GET localhost:8080/api/urls - Returns all saved URLs
    // Annotation tells Spring:
    //      when a user hits this URL with GET request,
    //      run the code inside this method
    @GetMapping
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    // POST localhost:8080/api/urls - Saves a new URL
    /**
     * Saves a new URL to the database.
     * @param url the URL object containing the data to be saved,
     * typically provided in the request body
     *
     * @return the persisted URL entity, including the database-generated ID
     */
    @PostMapping
    public Url addUrl(@RequestBody Url url) { //@RequestBody tells Spring to look at JSON data coming from user and turn it into Java Url obj
        // Controller can call .save() because it "owns" the reference
        // Sends SQL `INSERT` command to Postgres
        return urlRepository.save(url);
    }
}

