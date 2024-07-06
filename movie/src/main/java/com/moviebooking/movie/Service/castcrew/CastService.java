package com.moviebooking.movie.service.castcrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.cast.CastRequest;
import com.moviebooking.movie.dto.cast.CatsReponse;
import com.moviebooking.movie.dto.cast.CrewRequest;
import com.moviebooking.movie.dto.cast.CrewResponse;
import com.moviebooking.movie.model.Cast;
import com.moviebooking.movie.model.Crew;
import com.moviebooking.movie.repository.castcrew.CastRepo;
import com.moviebooking.movie.repository.castcrew.CrewRepo;

@Service
public class CastService {

    @Autowired
    private CastRepo castrepo;
    @Autowired
    private CrewRepo crewrepo;

    public CatsReponse addCast(CastRequest request) {
        Cast cast = new Cast();
        cast.setCastName(request.getCastName());
        cast.setFamousAs(request.getFamousAs());
        cast.setDetails(request.getDetails());
        cast.setDob(request.getDob());
        cast.setIndustries(request.getIndustries());

        Cast savedCast = castrepo.save(cast);

        return new CatsReponse(savedCast.getCastId(), savedCast.getCastName(), savedCast.getFamousAs(),
                savedCast.getDetails(), savedCast.getDob(), savedCast.getIndustries());
    }

    public CrewResponse createCrew(CrewRequest request) {
        Crew crew = new Crew();
        crew.setCrewName(request.getCrewName());
        crew.setDetails(request.getDetails());
        crew.setDob(request.getDob());
        crew.setFamousAs(request.getFamousAs());
        crew.setIndustries(request.getIndustries());
        Crew savedCrew = crewrepo.save(crew);

        return new CrewResponse(savedCrew.getCrewId(), savedCrew.getCrewName(), savedCrew.getDetails(),
                savedCrew.getDob(), savedCrew.getFamousAs(), savedCrew.getIndustries());

    }

}
