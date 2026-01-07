package com.rony.usage_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Device {
    Long id;
    String name;
    String type;
    String location;
    Long userId;
    Double energyConsumed;
}
