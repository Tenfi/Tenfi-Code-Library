package some;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("first_name")
    private String FirstName;

    private Integer age;
}
