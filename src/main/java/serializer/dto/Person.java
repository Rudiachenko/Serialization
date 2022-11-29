package serializer.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Person implements Serializable {
    private String name;
    private String surname;
    private String address;
    transient private Integer age;
}
