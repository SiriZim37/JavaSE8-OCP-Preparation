package ocpexam;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

//class Person {
//    private Integer number;
//    private String name;
//
//    public Person(Integer number, String name) {
//        this.number = number;
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return number + " :: " + name;
//    }
//}

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PerClassOptionalOrNull {

    private Optional<String> name;
    private Optional<Integer> number;

    public PerClassOptionalOrNull(Integer number, String name) {
        this.number = Optional.ofNullable(number); // Wrap number in Optional
        this.name = Optional.ofNullable(name);     // Wrap name in Optional
    }


    public String print() {   
        return number.orElse(0) + " :: " + name.orElse("Unknown");
    }

    public static void main(String[] args) {
        // Create Optional instances
        Optional<PerClassOptionalOrNull> first = Optional.of(new PerClassOptionalOrNull(null, "Anna"));
        Optional<PerClassOptionalOrNull> second = Optional.empty(); // No object
        Optional<PerClassOptionalOrNull> third = Optional.of(new PerClassOptionalOrNull(300, "Tom"));

        // Store in a list
        List<Optional<PerClassOptionalOrNull>> people = Arrays.asList(first, second, third);

        // Iterate and print values
        people.forEach(opt -> {
            opt.ifPresent(person -> System.out.println("> " + person.print()));

            // If Optional is empty, provide default
            PerClassOptionalOrNull person = opt.orElse(new PerClassOptionalOrNull(0, "Unknown"));
            System.out.println("orElse: " + person.print());
        });
    }
}
