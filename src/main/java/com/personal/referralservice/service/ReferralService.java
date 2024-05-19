package com.personal.referralservice.service;

import com.personal.referralservice.model.ReferralDetails;
import com.personal.referralservice.repository.ReferralDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReferralService {
    @Autowired private ReferralDetailsRepository referralDetailsRepository;
    public void sendReferral(final ReferralDetails referralDetails) {
        //send referral to whatsapp or message
        referralDetailsRepository.insert(referralDetails);
    }
    public List<ReferralDetails> getReferrals(final String customerId) {
        return referralDetailsRepository.findByReferrerId(customerId);
    }


}
