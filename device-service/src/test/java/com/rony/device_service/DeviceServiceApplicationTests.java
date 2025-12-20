package com.rony.device_service;

import com.rony.device_service.entity.Device;
import com.rony.device_service.model.DeviceType;
import com.rony.device_service.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
class DeviceServiceApplicationTests {

    public static final int NUMBER_OF_DEVICES = 200;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Disabled
    @Test
    void createDevices() {

        List<Long> userIds = jdbcTemplate.queryForList(
                "SELECT id FROM user",
                Long.class
        );

        if (userIds.isEmpty()) {
            throw new IllegalStateException("No users found in DB. Insert users before creating devices.");
        }

        for (int i = 1; i <= NUMBER_OF_DEVICES; i++) {

            Device device = Device.builder()
                    .name("Device" + i)
                    .type(DeviceType.values()[i % DeviceType.values().length])
                    .location("Location" + ((i % 3) + 1))
                    .userId(userIds.get(i % userIds.size()))
                    .build();

            deviceRepository.save(device);
        }

        log.info("Device Repository has been populated with {} devices", NUMBER_OF_DEVICES);
    }

}
