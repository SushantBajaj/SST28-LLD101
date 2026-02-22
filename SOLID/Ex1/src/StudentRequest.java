public class StudentRequest {
    String name;
    String email;
    String phone;
    String program;
    public StudentRequest(String name, String email, String phone, String program){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getProgram(){
        return this.program;
    }
    



}
