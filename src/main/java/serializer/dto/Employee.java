package serializer.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
public class Employee implements Serializable {
    private String name;
    private String surname;
    private String company;
    private String title;
    transient private Integer experienceInYears;
}
