package com.nelson.urlsaver.repository;

import com.nelson.urlsaver.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    // Leave this empty!
    // by extending JpaRepository, the interface inherits over 30 methods defined by Spring
    // Repo gives access to .findAll() and .save()
}