package com.babis.BluetoothServer.service;

import com.babis.BluetoothServer.dto.*;
import com.babis.BluetoothServer.entity.BluetoothData;
import com.babis.BluetoothServer.repo.BluetoothDataRepo;
import com.babis.BluetoothServer.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BluetoothDataServiceImpl implements BluetoothDataService{

    private final BluetoothDataRepo bluetoothDataRepo;
    private final UserRepo userRepo;

    @Override
    public List<BluetoothData> getAllData() {
        return bluetoothDataRepo.findAll();
    }


    @Override
    public BluetoothData saveData(BluetoothData bluetoothData) {

        return bluetoothDataRepo.save(bluetoothData);
    }

    @Override
    public List<BluetoothData> findByUserId(Long userId) {
        return bluetoothDataRepo.findByUserId(userId);
    }

    /**@Override
    public List<GatheringInCities> findGatheringInCitiesByCountry(String countryName) {
        return bluetoothDataRepo.findGatheringInCitiesByCountry(countryName);
    }**/

    @Override
    public List<GatheringInCities> findGatheringInCitiesByCountry(String countryName) {
        List<BluetoothData> bluetoothData = bluetoothDataRepo.findByCountry(countryName);
        if (bluetoothData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data for country: " + countryName);
        } else {
            return bluetoothDataRepo.findGatheringInCitiesByCountry(countryName);
        }
    }


    @Override
    public List<GatheringInCountries> findGatheringInCountries() {
        return bluetoothDataRepo.findGatheringInCountries();
    }

    @Override
    public List<GatheringInCountriesByDay> findGatheringInCountriesByDay() {
        return bluetoothDataRepo.findGatheringInCountriesByDay();
    }

    @Override
    public List<GatheringInCountriesByDay> findGatheringInCountryByDay(String countryName) {
        List<BluetoothData> bluetoothData = bluetoothDataRepo.findByCountry(countryName);
        if (bluetoothData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data for country: " + countryName);
        } else {
            return bluetoothDataRepo.findGatheringInCountryByDay(countryName);
        }
    }

    @Override
    public List<GatheringByCountryByDay> findGatheringByCountryByDay(String countryName, int day) {
        List<BluetoothData> bluetoothData = bluetoothDataRepo.findByCountry(countryName);
        if (bluetoothData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data for country: " + countryName);
        } else {
            return bluetoothDataRepo.findGatheringByCountryByDay(countryName, day);
        }
    }

    @Override
    public List<LatLongByCountry> getLatLongByCountry(String countryName) {
        List<BluetoothData> bluetoothData = bluetoothDataRepo.findByCountry(countryName);
        if (bluetoothData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data for country: " + countryName);
        } else {
            return bluetoothDataRepo.getLatLongByCountry(countryName);
        }
    }


}
