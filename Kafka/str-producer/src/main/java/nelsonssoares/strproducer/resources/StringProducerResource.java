package nelsonssoares.strproducer.resources;

import lombok.RequiredArgsConstructor;
import nelsonssoares.strproducer.services.StringProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class StringProducerResource {

    private final StringProducerService stringProducerService;


    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {

        stringProducerService.sendStringMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
