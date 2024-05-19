package com.personal.referralservice.model;

import com.personal.referralservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ReferralDetails")
public class ReferralDetails {
    private String fullName;
    private String emailId;
    private String mobileNo;
    private String referrerName;
    @Indexed private String referrerId;
}
