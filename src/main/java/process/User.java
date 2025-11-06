package process;

import java.util.UUID;

public class User {

    private UUID uuid;
    private String surname;
    private String firstName;
    private String patronymic;

    public User(UUID uuid, String surname, String firstName, String patronymic) {
        this.uuid = uuid;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public UUID getUuid() {
        return uuid;
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
        return surname + " " + firstName + " " + patronymic + "\n";
    }
}
