package com.bednarz.rentalsrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wololo.geojson.GeoJSON;

@RestController
public class LocationController {

    @Autowired
    private MockLocationRepository locationRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("locations")
    public GeoJSON getAllLocations() {
        return locationRepository.getAllLocations();
    }

    @PostMapping("/locations")
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.createAdvertisement(location);
    }

}
