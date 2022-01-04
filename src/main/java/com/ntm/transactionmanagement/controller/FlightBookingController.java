package com.ntm.transactionmanagement.controller;

import com.ntm.transactionmanagement.dto.FlightBookingRequest;
import com.ntm.transactionmanagement.dto.FlightBookingResponse;
import com.ntm.transactionmanagement.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class FlightBookingController {
	@Autowired
	private FlightBookingService service;

	public FlightBookingController(FlightBookingService service) {
		this.service = service;
	}

	@PostMapping("/booking")
	public FlightBookingResponse bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}
}
