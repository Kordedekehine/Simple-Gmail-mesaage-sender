package Project.demo.email;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface EmailSender {
    void send(String to, String email);
}
