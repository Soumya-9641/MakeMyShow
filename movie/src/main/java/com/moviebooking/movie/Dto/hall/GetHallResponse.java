package com.moviebooking.movie.dto.hall;

import java.time.LocalDateTime;
import java.util.List;

import com.moviebooking.movie.dto.halltype.HallTypeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class GetHallResponse {

    // private List<CinemaResponseDto> cinemas;
    private List<HallTypeResponse> hallTypes;

    private Long hallId;
    private String hallName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CinemaResponse> cinemas;

    public GetHallResponse(Long hallId, String hallName, LocalDateTime createdAt, LocalDateTime updatedAt,
            List<CinemaResponse> cinemas, List<HallTypeResponse> hallTypes) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cinemas = cinemas;
        this.hallTypes = hallTypes;
    }

}

// {
// "Accountancy/Book Keeping (301)":
// "1:2;2:2;3:4;4:4;5:1;6:3;7:2;8:2;9:3;10:4;11:1;12:3;13:1;14:4;15:1;16:1;17:2;18:3;19:2;20:1;21:4;22:2;23:4;24:3;25:2;26:3;27:1;28:3;29:2;30:1;31:3;32:1;33:2;34:1;35:2;36:1;37:2;38:3;39:4;40:1;41:1;42:1;43:3;44:3;45:4;46:3;47:1;48:2;49:2;50:2",
// "Business Studies (305)":
// "1:1;2:4;3:3;4:3;5:5;6:1;7:2;8:3;9:2;10:4;11:3;12:3;13:1;14:3;15:3;16:3;17:4;18:2;19:2;20:1;21:3;22:3;23:2;24:4;25:4;26:1;27:2;28:1;29:2;30:3;31:1;32:1;33:1;34:1;35:4;36:1;37:4;38:1;39:2;40:3;41:4;42:1;43:2;44:3;45:2;46:4;47:4;48:2;49:4;50:4",
// "Economics/Business Economics (309)":
// "1:2;2:2;3:2;4:2;5:3;6:3;7:3;8:2;9:2;10:4;11:3;12:2;13:2;14:1;15:3;16:4;17:2;18:4;19:3;20:1;21:2;22:2;23:3;24:3;25:2;26:1;27:3;28:2;29:3;30:3;31:4;32:4;33:4;34:2;35:4;36:4;37:2;38:3;39:3;40:1;41:2;42:2;43:2;44:2;45:4;46:2;47:3;48:4;49:3;50:3",
// "English (101)":
// "1:3;2:2;3:3;4:2;5:1;6:3;7:1;8:2;9:3;10:1;11:2;12:3;13:2;14:3;15:1;16:3;17:3;18:2;19:2;20:1;21:3;22:5;23:4;24:3;25:3;26:2;27:4;28:1;29:2;30:3;31:1;32:3;33:4;34:3;35:1;36:1;37:2;38:1;39:3;40:1;41:3;42:1;43:D;44:2;45:3;46:1;47:4;48:1;49:1;50:2",
// "General Test (501)":
// "1:3;2:1;3:3;4:2;5:2;6:2;7:2;8:3;9:3;10:2;11:3;12:4;13:4;14:3;15:3;16:2;17:1;18:1;19:2;20:2;21:2;22:1;23:1;24:1;25:2;26:2;27:1;28:2;29:3;30:2;31:4;32:1;33:2;34:4;35:1;36:4;37:4;38:2;39:1;40:1;41:1;42:4;43:3;44:4;45:2;46:4;47:2;48:3;49:2;50:3;51:2;52:2;53:4;54:2;55:2;56:2;57:4;58:3;59:3;60:4"
// }