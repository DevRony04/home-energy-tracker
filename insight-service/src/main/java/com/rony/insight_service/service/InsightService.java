package com.rony.insight_service.service;

import com.rony.insight_service.client.UsageClient;
import com.rony.insight_service.dto.InsightDto;
import com.rony.insight_service.dto.UsageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InsightService {

    private final UsageClient usageClient;

    public InsightDto getOverview(Long userId){
        // Fetch data from Usage Service
        final UsageDto usageData = usageClient.getXDaysUsageForUser(userId, 3);
    }
}
