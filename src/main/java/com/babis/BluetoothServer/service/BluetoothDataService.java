package com.babis.BluetoothServer.service;

import com.babis.BluetoothServer.dto.*;
import com.babis.BluetoothServer.entity.BluetoothData;

import java.util.List;
import java.util.Optional;

public interface BluetoothDataService {

    List<BluetoothData> getAllData();
    BluetoothData saveData(BluetoothData bluetoothData);
    List<BluetoothData> findByUserId(Long userId);
    List<GatheringInCities> findGatheringInCitiesByCountry(String countryName);
    List<GatheringInCountries> findGatheringInCountries();
    List<GatheringInCountriesByDay> findGatheringInCountriesByDay();
    List<GatheringInCountriesByDay> findGatheringInCountryByDay(String countryName);
    List<GatheringByCountryByDay> findGatheringByCountryByDay(String countryName, int day);
    List<LatLongByCountry> getLatLongByCountry(String countryName);

}
