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
public class PaymentRequestDTO {
    private Integer amount;
    private String paymentMethod;
    private String status;
    private String createdAt;
    private String updatedAt;
    private Long bookingId;
}
