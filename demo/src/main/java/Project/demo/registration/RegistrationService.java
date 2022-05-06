package Project.demo.registration;

import Project.demo.appUser.AppUser;
import Project.demo.appUser.AppUserRole;
import Project.demo.appUser.AppUserService;
import Project.demo.registration.token.ConfirmationToken;
import Project.demo.registration.token.ConfirmationTokenService;
import Project.demo.registration.token.EmailValidator;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public RegistrationService(AppUserService appUserService, EmailValidator emailValidator, ConfirmationTokenService confirmationTokenService) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;
        this.confirmationTokenService = confirmationTokenService;
    }

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String token = appUserService.signupUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER

                )
        );
        return token;
    }

        @Transactional
        public String confirmToken(String token) {
            ConfirmationToken confirmationToken = confirmationTokenService
                    .getToken(token)
                    .orElseThrow(() ->
                            new IllegalStateException("token not found"));

            if (confirmationToken.getConfirmedAt() != null) {
                throw new IllegalStateException("email already confirmed");
            }

            LocalDateTime expiredAt = confirmationToken.getExpiresAt();

            if (expiredAt.isBefore(LocalDateTime.now())) {
                throw new IllegalStateException("token expired");
            }

            confirmationTokenService.setConfirmedAt(token);
            appUserService.enableAppUser(
                    confirmationToken.getAppUser().getEmail());
            return "confirmed";
        }
}
