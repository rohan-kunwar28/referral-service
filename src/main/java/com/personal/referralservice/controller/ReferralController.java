package com.personal.referralservice.controller;

import com.personal.referralservice.model.ReferralDetails;
import com.personal.referralservice.service.ReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/referral")
public class ReferralController {
    @Autowired private ReferralService referralService;
    @PostMapping
    public ResponseEntity<String> sendReferral(@RequestBody final ReferralDetails referralDetails) {
        referralService.sendReferral(referralDetails);
        WhatsAppController.sendWhatsAppMessage(referralDetails.getMobileNo(),referralDetails.getFullName(), referralDetails.getReferrerName());
        return ResponseEntity.ok("Referral sent successfully");
    }
    @GetMapping
    public ResponseEntity<List<ReferralDetails>> getReferrals(@RequestParam final String customerId) {
        final List<ReferralDetails> referralDetailsList = referralService.getReferrals(customerId);
        return ResponseEntity.ok(referralDetailsList);
    }
}
