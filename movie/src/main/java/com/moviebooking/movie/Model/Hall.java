package com.moviebooking.movie.model;

import java.time.LocalDateTime;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hall {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long hallId;
        private String hallName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinTable(name = "cinema_hall", joinColumns = @JoinColumn(name = "hall_id"), inverseJoinColumns = @JoinColumn(name = "cinema_id"))
        private Set<Cinema> cinemas;
        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinTable(name = "hall_halltype", joinColumns = @JoinColumn(name = "hall_id"), inverseJoinColumns = @JoinColumn(name = "hall_type_id"))
        private Set<HallType> hallTypes;
        @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
        private List<Show> shows;
        @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
        private List<Seat> seats;
}
