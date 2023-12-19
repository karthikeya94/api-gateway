
@RestController
public class FallbackController{
    @GetMapping("/employeeserviefallback")
    public ResponseEntity<String> employeeBreaker(){
        return new ResponseEntity<>("employee service is taking longer than expected please try again later",HttpStatus.GATEWAY_TIMEOUT);
    }
    @GetMapping("/customerserviefallback")
    public ResponseEntity<String> customerBreaker(){
        return new ResponseEntity<>("customer service is taking longer than expected please try again later",HttpStatus.GATEWAY_TIMEOUT);
    }
    @GetMapping("/orderserviefallback")
    public ResponseEntity<String> orderBreaker(){
        return new ResponseEntity<>("order service is taking longer than expected please try again later",HttpStatus.GATEWAY_TIMEOUT);
    }
    @GetMapping("/employeeserviefallback")
    public ResponseEntity<String> productBreaker(){
        return new ResponseEntity<>("product service is taking longer than expected please try again later",HttpStatus.GATEWAY_TIMEOUT);
    }
}