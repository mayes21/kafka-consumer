package dev.sample.kafka;

import fr.laposte.intra.courrier.avro.out.v2.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaReceiver {

    @KafkaListener(id = "pause.resume", topics = "ticket-sdev")
    public void listen(ConsumerRecord<String, Ticket> consumerRecord) {
        log.info(consumerRecord.key() + " : " + consumerRecord.value());
    }
}
