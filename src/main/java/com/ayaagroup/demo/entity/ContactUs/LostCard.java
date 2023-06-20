package com.ayaagroup.demo.entity.ContactUs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "LostCard")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LostCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestId")
    private Integer RequestId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "loss_details")
    private String lossDetails;

    @Column(name = "phone")
    private String phone;
}
