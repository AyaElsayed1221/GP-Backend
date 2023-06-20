package com.ayaagroup.demo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllContactRequestsDto {

    private Integer TicketId;

    private String name;
}
