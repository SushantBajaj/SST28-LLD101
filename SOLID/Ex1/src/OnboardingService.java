import java.util.*;

public class OnboardingService {
    private final Database db;
    private final StudentParser parser;
    private final StudentValidator valiator;
    private final Printer printer;
    public OnboardingService(
        Database db,
        StudentParser parser,
        StudentValidator valiator,
        Printer printer
    ) { 
            this.db = db;
            this.parser = parser;
            this.valiator = valiator;
            this.printer = printer;
        }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printRaw(raw);;

        StudentRequest req = parser.parse(raw);

        List<String> errors = valiator.validate(req);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());

        StudentRecord rec = new StudentRecord(id, req.getName(), req.getEmail(), req.getPhone(), req.getProgram());
        db.save(rec);

        printer.printSuccess(rec,id,db.count());
    }

        
}
