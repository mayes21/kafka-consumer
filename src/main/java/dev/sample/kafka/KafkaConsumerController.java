package dev.sample.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaConsumerController {


    private final KafkaListenerEndpointRegistry registry;

    @Autowired
    public KafkaConsumerController(KafkaListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    @GetMapping(value = "/partitions")
    public String partitionsKafkaConsumption() {
        return registry.getListenerContainer("pause.resume").getListenerId();
    }

    @GetMapping(value = "/pause")
    public void pauseKafkaConsumption() {
        registry.getListenerContainer("pause.resume").pause();
    }


    @GetMapping(value = "/resume")
    public void resumeKafkaConsumption() {
        registry.getListenerContainer("pause.resume").resume();
    }

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "hello";
    }
}