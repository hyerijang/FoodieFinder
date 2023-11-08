package com.foodiefinder.datapipeline.writer;

import com.foodiefinder.datapipeline.cache.DataPipelineCacheRepository;
import com.foodiefinder.datapipeline.processor.dto.CombineRestaurantProcessorResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CombineRestaurantWriter implements ItemWriter<CombineRestaurantProcessorResultData> {

    private final RestaurantWriter restaurantWriter;
    private final DataPipelineCacheRepository dataPipelineCacheRepository;

    @Override
    public void write(CombineRestaurantProcessorResultData input) {
        if (input != null || !input.getRestaurants().isEmpty()) {
            restaurantWriter.write(input.getRestaurants());
            // Response, Restaurant 캐시 데이터 저장
            dataPipelineCacheRepository.setResponseCache(input.getResponse());
            dataPipelineCacheRepository.setRestaurantCache(input.getRestaurants());
        }
    }
}
