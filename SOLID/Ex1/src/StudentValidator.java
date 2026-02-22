import java.util.*;
public class StudentValidator {
    public List<String> validate(StudentRequest req){
        

        // validation inline, printing inline
        List<String> errors = new ArrayList<>();
        if (req.getName().isBlank()) errors.add("name is required");
        if (req.getEmail().isBlank() || !req.getEmail().contains("@")) errors.add("email is invalid");
        if (req.getPhone().isBlank() || !req.getPhone().chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(req.getProgram().equals("CSE") || req.getProgram().equals("AI") || req.getProgram().equals("SWE"))) errors.add("program is invalid");
        return errors;
    }
}
