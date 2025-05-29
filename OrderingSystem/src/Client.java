import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

        return getName() + " (" + formatter.format(getBirthDate()) + ") - " + getEmail();
    }
}
