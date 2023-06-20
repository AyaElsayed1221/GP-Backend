package com.ayaagroup.demo.dto;

import com.ayaagroup.demo.entity.ContactUs.ContactUs;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Integer TicketId;

    private String name;

    private String email;

    private String message;

    private String  phone;

    public static ContactDto toDto (ContactUs entity){
        return ContactDto.builder()
                .email(entity.getEmail())
                .message(entity.getMessage())
                .name(entity.getName())
                .phone(entity.getPhone())
                .TicketId(entity.getTicketId())
                .build();
    }
}
