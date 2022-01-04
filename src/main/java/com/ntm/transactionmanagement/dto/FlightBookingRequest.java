package com.ntm.transactionmanagement.dto;

import com.ntm.transactionmanagement.model.PassengerInfo;
import com.ntm.transactionmanagement.model.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;
}
