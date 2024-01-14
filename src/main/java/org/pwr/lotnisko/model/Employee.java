package org.pwr.lotnisko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    int id;
    String firstName;
    String secondName;
    EmployeeRole role;
}
