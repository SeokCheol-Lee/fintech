package com.example.domain.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_key")
    private String userKey;

    @Column(name = "usr_reg_num")
    private String userRegistrationNumber;

    @Column(name = "usr_nm")
    private String userName;

    @Column(name = "usr_icm_amt")
    private Long userIncomeAmount;

    @Builder
    public UserInfo(String userKey, String userRegistrationNumber, String userName
        , Long userIncomeAmount){
        this.userKey = userKey;
        this.userRegistrationNumber = userRegistrationNumber;
        this.userName = userName;
        this.userIncomeAmount = userIncomeAmount;
    }
}
