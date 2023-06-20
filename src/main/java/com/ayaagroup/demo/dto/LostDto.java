package com.ayaagroup.demo.dto;

import com.ayaagroup.demo.entity.ContactUs.LostCard;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LostDto {
    private Integer RequestId;

    private String name;

    private String email;

    private String cardId;

    private String lossDetails;

    private String phone;

    public static LostDto toDto (LostCard entity){
        return LostDto.builder()
                .cardId(entity.getCardId())
                .RequestId(entity.getRequestId())
                .email(entity.getEmail())
                .name(entity.getName())
                .lossDetails(entity.getLossDetails())
                .phone(entity.getPhone())
                .build();
    }
}
