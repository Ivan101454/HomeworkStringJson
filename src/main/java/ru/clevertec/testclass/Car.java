package ru.clevertec.testclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Car {
    String name;
}
