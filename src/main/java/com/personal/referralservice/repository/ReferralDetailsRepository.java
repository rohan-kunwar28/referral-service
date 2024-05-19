package com.personal.referralservice.repository;

import com.personal.referralservice.model.ReferralDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReferralDetailsRepository extends MongoRepository<ReferralDetails, String> {
    List<ReferralDetails> findByReferrerId(String leadId);
}
