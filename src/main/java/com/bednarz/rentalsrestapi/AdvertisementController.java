package com.bednarz.rentalsrestapi;

import com.bednarz.rentalsrestapi.repository.MockAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertisementController {

    @Autowired
    MockAdvertisementRepository mockAdvertisementRepository;

    @RequestMapping(value="/advertisements/{apartamentid}")
    public Advertisement getApartamentById(@PathVariable("apartamentid") int apartamentId) {
        return mockAdvertisementRepository.getAdvertisementById(1L);
    }
}
