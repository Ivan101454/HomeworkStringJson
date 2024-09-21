package ru.clevertec.testclass;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
public class Person {
    String name;
    String city;
    List<Car> cars;
    String job;
}
