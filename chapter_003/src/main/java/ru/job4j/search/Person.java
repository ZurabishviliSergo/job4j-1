package ru.job4j.search;

/**
 * Person for dictionary.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/5/18
 */
public class Person {
    /**
     * Person name.
     */
    private String name;
    /**
     * Person surname.
     */
    private String surname;
    /**
     * Person phone.
     */
    private String phone;
    /**
     * Person address.
     */
    private String address;

    /**
     * New person constructor.
     * @param name - new name for person.
     * @param surname - new surname for person.
     * @param phone - new phone for person.
     * @param address - new address for person.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }
    /**
     * Person name getter.
     * @return current person name.
     */
    public String getName() {
        return name;
    }
    /**
     * Person surname getter.
     * @return current person surname.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Person phone getter.
     * @return current person phone.
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Person address getter.
     * @return current person address.
     */
    public String getAddress() {
        return address;
    }
}