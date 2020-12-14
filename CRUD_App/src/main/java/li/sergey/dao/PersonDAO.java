package li.sergey.dao;

import org.springframework.stereotype.Component;
import li.sergey.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Oleg", 2012, "oleg@gmail.ru", "mercedes", 45000));
        people.add(new Person(++PEOPLE_COUNT, "Alex", 1980, "alex@gmail.ru", "suzuki", 21000));
        people.add(new Person(++PEOPLE_COUNT, "Dima", 2015, "dima@yandex.ru", "bmw", 1900));
        people.add(new Person(++PEOPLE_COUNT, "Sergey", 2000, "sergey@gmail.com", "volkswagen", 10000));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        personToBeUpdated.setCar(updatedPerson.getCar());
        personToBeUpdated.setYear(updatedPerson.getYear());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
