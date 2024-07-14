package com.moviebooking.movie.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "cinemashow")
public class Show {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long showId;
        @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinColumn(name = "hall_id", nullable = false)
        private Hall hall;
        @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
                        CascadeType.REFRESH })
        @JoinColumn(name = "movie_id", nullable = false)
        private Movie movie;

        @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
        private List<Booking> bookings;
        private String startTime;
        private String endTime;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
