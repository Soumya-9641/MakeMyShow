package com.moviebooking.movie.service.booking;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.payment.PaymentRequestDTO;
import com.moviebooking.movie.dto.payment.PaymentResponseDTO;
import com.moviebooking.movie.dto.payment.PaymentResponseDTO.BookingDto;
import com.moviebooking.movie.model.Booking;
import com.moviebooking.movie.model.Payment;
import com.moviebooking.movie.repository.booking.BookingRepository;
import com.moviebooking.movie.repository.booking.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public PaymentResponseDTO createPayment(PaymentRequestDTO request) {
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + request.getBookingId()));

        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus(request.getStatus());
        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());
        payment.setBooking(booking);

        payment = paymentRepository.save(payment);

        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setPaymentId(payment.getPaymentId());
        response.setAmount(payment.getAmount());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setStatus(payment.getStatus());
        response.setCreatedAt(payment.getCreatedAt().toString());
        response.setUpdatedAt(payment.getUpdatedAt().toString());

        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setUserId(booking.getUser().getUserId());
        bookingDto.setBookingTime(booking.getBookingTime());
        response.setBooking(bookingDto);

        return response;
    }

    @Transactional
    public PaymentResponseDTO getPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));

        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setPaymentId(payment.getPaymentId());
        response.setAmount(payment.getAmount());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setStatus(payment.getStatus());
        response.setCreatedAt(payment.getCreatedAt().toString());
        response.setUpdatedAt(payment.getUpdatedAt().toString());

        Booking booking = payment.getBooking();
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setUserId(booking.getUser().getUserId());
        bookingDto.setBookingTime(booking.getBookingTime());
        response.setBooking(bookingDto);

        return response;
    }
}
