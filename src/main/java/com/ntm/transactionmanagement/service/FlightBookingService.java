package com.ntm.transactionmanagement.service;

import com.ntm.transactionmanagement.dto.FlightBookingRequest;
import com.ntm.transactionmanagement.dto.FlightBookingResponse;
import com.ntm.transactionmanagement.model.PassengerInfo;
import com.ntm.transactionmanagement.model.PaymentInfo;
import com.ntm.transactionmanagement.repository.PassengerInfoRepository;
import com.ntm.transactionmanagement.repository.PaymentInfoRepository;
import com.ntm.transactionmanagement.utils.PaymentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	public FlightBookingService(PassengerInfoRepository passengerInfoRepository, PaymentInfoRepository paymentInfoRepository) {
		this.passengerInfoRepository = passengerInfoRepository;
		this.paymentInfoRepository = paymentInfoRepository;
	}

	@Transactional
	public FlightBookingResponse bookFlightTicket(FlightBookingRequest request){

		PassengerInfo passengerInfo = request.getPassengerInfo();
		System.out.println(passengerInfo);
			passengerInfoRepository.save(passengerInfo);


		PaymentInfo paymentInfo = request.getPaymentInfo();
			PaymentValidation.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());
			paymentInfo.setPassengerId(passengerInfo.getPId());
			paymentInfo.setAmount(passengerInfo.getFare());
			paymentInfoRepository.save(paymentInfo);

		return new FlightBookingResponse(
				"SUCCESS",passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0],
				passengerInfo
		);



	}
}
