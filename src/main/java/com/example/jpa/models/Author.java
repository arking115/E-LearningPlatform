package com.example.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity { 
    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    @Column
    private String lastName;
    @Column(
            unique = false,
            nullable = false
    )
    private String email;
    @Column
    private int age;
    @Column(
            updatable = false
            // nullable = false
    )
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;
}
