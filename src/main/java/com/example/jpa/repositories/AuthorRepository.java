package com.example.jpa.repositories;

import com.example.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByFirstName(String fn);
    List<Author> findAllByFirstNameIgnoreCase(String fn);
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}