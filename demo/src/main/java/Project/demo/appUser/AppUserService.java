package Project.demo.appUser;

import Project.demo.registration.token.ConfirmationToken;
import  Project.demo.registration.token.ConfirmationTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND= "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public AppUserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new
                UsernameNotFoundException(String.format(USER_NOT_FOUND,email)));
        //through this we get the user when they try to log in
    }
   //The link we get to register
   public String signupUser(AppUser appUser){
     boolean userExist =   appUserRepository.findByEmail(appUser.getEmail()).isPresent();

     if (userExist){
         throw new IllegalStateException("Email already exists/taken");
     }
      String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

     appUser.setPassword(encodedPassword);

       appUserRepository.save(appUser);

       String token = UUID.randomUUID().toString();
       //Todo:send confirmation token
       ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
               LocalDateTime.now().plusMinutes(15),appUser);

       confirmationTokenService.saveConfirmationToken(confirmationToken);

       //Todo: send email
        return token;
   }

    public void enableAppUser(String email) {

    }
}
