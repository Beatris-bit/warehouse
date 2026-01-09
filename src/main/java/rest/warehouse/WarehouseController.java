package rest.warehouse;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import rest.model.WarehouseData;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger =
            LoggerFactory.getLogger(WarehouseController.class);

    private static final String TOPIC_NAME = "bpavlova";

    @GetMapping("/")
    public String warehouseMain() {
        return "This is the warehouse application!";
    }

    @GetMapping(value = "/warehouse/{id}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseDataJson(@PathVariable String id) {
        return service.getWarehouseData(id);
    }

    @GetMapping(value = "/warehouse/{id}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXml(@PathVariable String id) {
        return service.getWarehouseData(id);
    }

    @GetMapping(value = "/warehouse/send", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sendWarehouseToKafka(
            @RequestParam(defaultValue = "001") String id,
            @RequestParam(defaultValue = "json") String format) {

        try {
            WarehouseData data = service.getWarehouseData(id);
            String payload = "xml".equalsIgnoreCase(format)
                    ? new XmlMapper().writeValueAsString(data)
                    : new ObjectMapper().writeValueAsString(data);

            kafkaTemplate.send(TOPIC_NAME, payload);
            return "SENT";
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
