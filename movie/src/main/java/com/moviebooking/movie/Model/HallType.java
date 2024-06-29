package com.moviebooking.movie.Model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long hall_type_id;
    private String hall_type_name;
    @ManyToMany(mappedBy = "hallTypes")
    private Set<Movie> movies;
}
