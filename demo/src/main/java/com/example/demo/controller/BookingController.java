package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PassengerService;
import com.example.demo.model.Passengerdetails;

@Controller
public class BookingController {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping("/booking")
    public String showBookingPage() {
        System.out.println("Booking page");
        return "booking"; // Shows the booking.jsp page
    }

    @PostMapping("/booking")
    public String bookTicket(@ModelAttribute Passengerdetails details, Model model) {
        passengerService.Booking(details,"******");
        model.addAttribute("message", "Booking successful for " + details.getName());
        return "dashboard"; // Redirect to dashboard after booking
    }
}

