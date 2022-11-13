package com.kanni.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    Integer id;
    String title;
    Integer pages;
    Rating rating;
    Author author;
}
