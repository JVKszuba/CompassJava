import java.time.LocalDate;

public class Client {

    private String name;
    private String email;
    private LocalDate birthDate;

    //Constructors
    public Client() {}

    public Client(String name, String email, LocalDate birthDate) {

        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    //Getters and setters methods
    public String getName() {return name;}
    public String getEmail() {return email;}
    public LocalDate getBirthDate() {return birthDate;}

    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}

    //General methods
    public String toString() {

        return "Name: " + name + ", Email: " + email + ", Birth Date: " + birthDate;
    }
}
