package com.moviebooking.movie.model;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "halltypes")
public class HallType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallTypeId;
    private String hallTypeName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinTable(name = "movie_halltype", joinColumns = @JoinColumn(name = "hall_type_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinTable(name = "hall_halltype", joinColumns = @JoinColumn(name = "hall_type_id"), inverseJoinColumns = @JoinColumn(name = "hall_id"))
    private Set<Hall> halls;

}
