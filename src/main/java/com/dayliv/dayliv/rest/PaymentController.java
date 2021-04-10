package com.dayliv.dayliv.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.dto.ApiResponse;
import com.dayliv.dayliv.model.StripeClient;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.model.Charge;

@RestController
@RequestMapping("/dayliv-api/payment")
public class PaymentController {


    private StripeClient stripeClient;

    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public ResponseEntity<?> chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        System.out.println("Test...............");
        String status = this.stripeClient.chargeNewCard(token, amount).getStatus();
        System.out.println(status);
        
		return ResponseEntity.ok().body(new ApiResponse(true, status));

       // return new ResponseEntity<>(status, HttpStatus.OK);
    }
    

}