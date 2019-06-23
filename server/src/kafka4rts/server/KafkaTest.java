package kafka4rts.server;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaTest {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", "un43:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		for (int i = 0; i < 100; ++i)
			producer.send(new ProducerRecord<String, String>("test2", "", "java_" + Integer.toString(i)));

		producer.close();

		System.out.println("done");

	}

}
