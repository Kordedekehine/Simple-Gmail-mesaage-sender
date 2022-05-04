package Project.demo.AppUser.registration;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //Todo: Regex to validate email
        return true;
    }
}
