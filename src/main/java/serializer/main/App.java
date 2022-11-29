package serializer.main;

import serializer.dto.Employee;
import serializer.dto.Person;
import serializer.service.impl.ObjectDeserializerServiceImpl;
import serializer.service.impl.ObjectSerializerServiceImpl;

import java.util.Objects;

public class App {
    private static final ObjectSerializerServiceImpl OBJECT_SERIALIZER_SERVICE_IMPL = new ObjectSerializerServiceImpl();
    private static final ObjectDeserializerServiceImpl OBJECT_DESERIALIZER_SERVICE_IMPL = new ObjectDeserializerServiceImpl();

    private static final String FILE_PATH_TO_PERSON = "src/main/resources/person.txt";
    private static final String FILE_PATH_TO_EMPLOYEE = "src/main/resources/employee.txt";

    public static void main(String[] args) {
        App app = new App();

        Person bob = app.createPersonToSerialize("Bob", "Alison", "Kudriashova-14b", 25);
        System.out.println(bob);

        Person serializedPerson = (Person) OBJECT_SERIALIZER_SERVICE_IMPL.serializeObject(bob, FILE_PATH_TO_PERSON);
        Person deserializedPerson = (Person) OBJECT_DESERIALIZER_SERVICE_IMPL.deserializeObject(FILE_PATH_TO_PERSON);
        System.out.println("Are objects equals: " + Objects.equals(serializedPerson, deserializedPerson));

        Employee employeeBob = app.createEmployeeToSerialize("Bob", "Alison", "Epam", "software engineer", 3);

        Employee serializedEmployee = (Employee) OBJECT_SERIALIZER_SERVICE_IMPL.serializeObject(employeeBob, FILE_PATH_TO_EMPLOYEE);
        Employee deserializeEmployee = (Employee) OBJECT_DESERIALIZER_SERVICE_IMPL.deserializeObject(FILE_PATH_TO_EMPLOYEE);
        // Here objects must be not equals, as we don't serialize Integer age field.
        System.out.println("Are objects equals: " + Objects.equals(serializedEmployee, deserializeEmployee));
    }

    private Person createPersonToSerialize(String name, String surname, String address, int age) {
        return new Person(name, surname, address, age);
    }

    private Employee createEmployeeToSerialize(String name, String surname, String company, String title, int experienceInYears) {
        return new Employee(name, surname, company, title, experienceInYears);
    }
}
