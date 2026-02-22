import java.util.*;

public class FakeDb implements Database {
    public void save(StudentRecord r) { rows.add(r); }
    public int count() { return rows.size(); }
    public List<StudentRecord> all() { return Collections.unmodifiableList(rows); }
}
