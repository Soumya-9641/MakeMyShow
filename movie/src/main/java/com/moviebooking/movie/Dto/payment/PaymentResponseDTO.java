package com.moviebooking.movie.dto.payment;

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
public class PaymentResponseDTO {
    private Long paymentId;
    private Integer amount;
    private String paymentMethod;
    private String status;
    private String createdAt;
    private String updatedAt;
    private BookingDto booking;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookingDto {
        private Long bookingId;
        private Long userId;
        private String bookingTime;
    }
}
