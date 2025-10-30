package process;

public class User implements UserFormatter{

    private int uuid;
    private String surname;
    private String firstName;
    private String patronymic;

    public User(int uuid, String surname, String firstName, String patronymic) {
        this.uuid = uuid;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public User(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return uuid + " " + surname + " " + firstName + " " + patronymic + "\n";
    }

    @Override
    public String format() {
        return surname + " " + firstName + " " + patronymic + "\n";
    }
}
