package com.ntm.transactionmanagement.repository;

import com.ntm.transactionmanagement.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
