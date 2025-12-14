package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recommendation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity) {
        log.info("Received activity for processing: {}", activity.getId());
        Recommendation recommendation = aiService.generateRecommendation(activity);
        FileCredentialsCache recommendationRepository;
        recommendationRepository.save(recommendation);
    }
}
