package ru.clevertec.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Person {
    String name;
    String city;
    List<Car> cars;
    String job;
}
