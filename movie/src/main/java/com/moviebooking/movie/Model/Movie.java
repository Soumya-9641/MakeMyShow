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
import jakarta.persistence.OneToMany;
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
@Table(name = "movies")
public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long movie_id;
        private String title;
        private String description;

        private String duration;
        private String trailerLink;
        private Integer likesCount;
        private Integer viewsCount;
        private String releaseDate;
        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
        private Set<Language> languages;
        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinTable(name = "movie_halltype", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "hall_type_id"))
        private Set<HallType> hallTypes;

        @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
        private List<Review> reviews;

        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "cast_id"))
        private Set<Cast> cast;

        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinTable(name = "movie_crew", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "crew_id"))
        private Set<Crew> crew;
        @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
        private List<Show> shows;

}
