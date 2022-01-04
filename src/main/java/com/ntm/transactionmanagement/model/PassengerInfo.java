package com.ntm.transactionmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="passenger_info")
public class PassengerInfo {
	@Id
	@SequenceGenerator(
			name = "passenger_info_sequence",
			sequenceName = "passenger_info_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "passenger_info_sequence")
	private Long pId;
	private String name;
	private String email;
	private String source;
	private String destination;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date travelDate;
	private String pickUpTime;
	private String arrivalTime;
	private double fare;

}
