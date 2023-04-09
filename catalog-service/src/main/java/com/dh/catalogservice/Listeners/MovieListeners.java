package com.dh.catalogservice.Listeners;

import com.dh.catalogservice.api.service.OffLineService;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.OffLine;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListeners {


    @Autowired
    OffLineService offLineService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload OffLine offLine) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        offLineService.create(offLine);
        System.out.println(offLine);
    }
}
