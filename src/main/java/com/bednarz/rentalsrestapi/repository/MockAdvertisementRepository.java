package com.bednarz.rentalsrestapi.repository;

import com.bednarz.rentalsrestapi.Advertisement;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class MockAdvertisementRepository {

    public Advertisement getAdvertisementById(long id) {
        return Advertisement.create(
                1L,
                "name",
                "advertisement desciption",
                Arrays.asList("https://res.cloudinary.com/dgmrp8gxe/image/upload/v1550950328/iqa7bvocufyiuatebrln.jpg",
                        "https://res.cloudinary.com/dgmrp8gxe/image/upload/v1550952528/lahs7xgqp1qtflnhwsw4.jpg"));

    }
}
