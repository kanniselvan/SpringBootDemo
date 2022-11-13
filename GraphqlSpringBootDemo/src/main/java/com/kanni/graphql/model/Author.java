package com.kanni.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    Integer id;
    String firstName;
    String lastName;

    public String fullName() {
        return firstName + " " + lastName;
    }

}
