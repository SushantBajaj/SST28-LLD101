import java.util.ArrayList;
import java.util.List;

public interface Database {
    public final List<StudentRecord> rows = new ArrayList<>();
    public void save(StudentRecord r);
    public int count();
    public List<StudentRecord> all();
} 
