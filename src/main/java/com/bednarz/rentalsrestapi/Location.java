package com.bednarz.rentalsrestapi;

import lombok.Data;

import java.util.Objects;

@Data
public class Location {
    double latitudex;
    double longitudey;
    String title;
    String city;
    int price;
}
