package com.rony.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlertingEvent {
    private Long userId;
    private String message;
    private double threshold;
    private double energyConsumed;
    private String email;
}
