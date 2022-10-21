package com.babis.BluetoothServer.controller;

import com.babis.BluetoothServer.dto.*;
import com.babis.BluetoothServer.entity.BluetoothData;
import com.babis.BluetoothServer.entity.User;
import com.babis.BluetoothServer.repo.BluetoothDataRepo;
import com.babis.BluetoothServer.repo.UserRepo;
import com.babis.BluetoothServer.service.BluetoothDataService;
import com.babis.BluetoothServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class BluetoothDataController {

    private final BluetoothDataService bluetoothDataService;
    private final BluetoothDataRepo bluetoothDataRepo;
    private final UserRepo userRepo;

    @GetMapping("/getall")
    public ResponseEntity<List<BluetoothData>> getAllData(){
        return ResponseEntity.ok().body(bluetoothDataService.getAllData());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<BluetoothData> getByDataId(@PathVariable Long id){
        Optional<BluetoothData> optionalBluetoothData = bluetoothDataRepo.findById(id);
        if (!optionalBluetoothData.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok().body(optionalBluetoothData.get());
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<BluetoothData>> getByUserId(@PathVariable Long userId){
        return ResponseEntity.ok().body(bluetoothDataService.findByUserId(userId));
    }


    @PostMapping("/savedata")
    public ResponseEntity<BluetoothData> saveData(@RequestBody BluetoothData bluetoothData){
        //Optional<User> optionalUser = userRepo.findById(bluetoothData.getUser().getId());
        //bluetoothData.setUser(optionalUser.get());
        User user = userRepo.findByUsername(bluetoothData.getUser().getUsername());
        bluetoothData.setUser(user);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/data/savedata").toUriString());

        return ResponseEntity.created(uri).body(bluetoothDataService.saveData(bluetoothData));
    }

    @GetMapping("/getcountcities")
    public ResponseEntity<List<GatheringInCities>> findGatheringByCity(){
        return ResponseEntity.ok().body(bluetoothDataRepo.findGatheringInCities());
    }

    @GetMapping("/gatheringInCitiesByCountry/{countryName}")
    public ResponseEntity<List<GatheringInCities>> findGatheringInCitiesByCountry(@PathVariable String countryName){


        return ResponseEntity.ok().body(bluetoothDataService.findGatheringInCitiesByCountry(countryName));
    }

    @GetMapping("/gatheringInCountries")
    public ResponseEntity<List<GatheringInCountries>> findGatheringInCountries(){
        return ResponseEntity.ok().body(bluetoothDataService.findGatheringInCountries());
    }

    @GetMapping("/gatheringInCountriesByDay")
    public ResponseEntity<List<GatheringInCountriesByDay>> findGatheringInCountriesByDay(){
        return ResponseEntity.ok().body(bluetoothDataService.findGatheringInCountriesByDay());
    }

    @GetMapping("/gatheringInCountryByDay/{countryName}")
    public ResponseEntity<List<GatheringInCountriesByDay>> findGatheringInCountryByDay(@PathVariable String countryName){
        return ResponseEntity.ok().body(bluetoothDataService.findGatheringInCountryByDay(countryName));
    }

    @GetMapping("/gatheringByCountryByDay/{countryName}/{day}")
    public ResponseEntity<List<GatheringByCountryByDay>> findGatheringByCountryByDay(@PathVariable String countryName, @PathVariable int day){
        return ResponseEntity.ok().body(bluetoothDataService.findGatheringByCountryByDay(countryName, day));
    }

    @GetMapping("/latlongByCountry/{countryName}")
    public ResponseEntity<List<LatLongByCountry>> getLatLongByCountry(@PathVariable String countryName){
        return ResponseEntity.ok().body(bluetoothDataService.getLatLongByCountry(countryName));
    }

}
