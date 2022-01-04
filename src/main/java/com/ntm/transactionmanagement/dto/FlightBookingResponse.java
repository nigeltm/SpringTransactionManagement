package com.ntm.transactionmanagement.dto;

import com.ntm.transactionmanagement.model.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingResponse {
	private String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
