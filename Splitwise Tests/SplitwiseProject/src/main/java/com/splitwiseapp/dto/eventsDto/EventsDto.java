package com.splitwiseapp.dto.eventsDto;

import com.splitwiseapp.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EventsDto {

    private Integer idEvent;

    private String eventName;

}
