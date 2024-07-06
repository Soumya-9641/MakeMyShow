package com.moviebooking.movie.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long castId;
    private String castName;
    private String famousAs;
    private String details;
    private String dob;
    private List<String> industries;
    // @ManyToMany(mappedBy = "cast", fetch = FetchType.LAZY, cascade = {
    // CascadeType.PERSIST, CascadeType.MERGE,
    // CascadeType.DETACH, CascadeType.REFRESH })
    // private Set<Movie> movies;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinTable(name = "movie_crew", joinColumns = @JoinColumn(name = "cast_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;
}
