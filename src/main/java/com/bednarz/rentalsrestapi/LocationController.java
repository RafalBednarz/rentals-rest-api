package com.bednarz.rentalsrestapi;

import com.bednarz.rentalsrestapi.repository.MockLocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wololo.geojson.GeoJSON;

@RestController
public class LocationController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private MockLocationRepository locationRepository;

    @RequestMapping("locations")
    public GeoJSON getAllLocations(@RequestParam(required = false) String price) {

        if(price!=null && !price.equals("")) {
            return locationRepository.getLocationsByPrice(price);
        }
        return locationRepository.getAllLocations();
    }

    @PostMapping("/locations")
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.createAdvertisement(location);
    }

}
