package Project.demo.registration;

import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/v1/registration")
@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("confirm") String token) {
        return registrationService.confirm(token);
    }
}
