package com.babis.BluetoothServer.repo;

import com.babis.BluetoothServer.dto.*;
import com.babis.BluetoothServer.entity.BluetoothData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BluetoothDataRepo extends JpaRepository<BluetoothData, Long> {

    List<BluetoothData> findByUserId(Long userId);
    List<BluetoothData> findByCountry(String countryName);
    
    //@Query("select new com.babis.BluetoothServer.dto.GatheringInCities(b.city,count(b.city)) from BluetoothData b group by b.city")
    @Query("select new com.babis.BluetoothServer.dto.GatheringInCities(b.city,count(b.city)) " +
            "from BluetoothData b " +
            //"where b.numOfPhones > 9 " +
            "group by b.city " +
            "order by count(b.city) desc")
    List<GatheringInCities> findGatheringInCities();

    @Query("select new com.babis.BluetoothServer.dto.GatheringInCities(b.city,count(b.city)) " +
            "from BluetoothData b " +
            "where b.country=?1 " +
            //"and b.numOfPhones > 9 " +
            "group by b.city " +
            "order by count(b.city) desc")
    List<GatheringInCities> findGatheringInCitiesByCountry(String countryName);

    @Query("select new com.babis.BluetoothServer.dto.GatheringInCountries(b.country,count(b.country)) " +
            "from BluetoothData b " +
            "group by b.country " +
            "order by count(b.country) desc")
    List<GatheringInCountries> findGatheringInCountries();

    @Query("select new com.babis.BluetoothServer.dto.GatheringInCountriesByDay(extract(isodow from b.timestamp) as day, count(b.timestamp)) " +
            "from BluetoothData b " +
            "group by day " +
            "order by day") //0:Monday 1:Tuesday...
    List<GatheringInCountriesByDay> findGatheringInCountriesByDay();

    @Query("select new com.babis.BluetoothServer.dto.GatheringInCountriesByDay(extract(isodow from b.timestamp) as day, count(b.timestamp)) " +
            "from BluetoothData b " +
            "where b.country=?1 " +
            "group by day " +
            "order by day") //0:Sunday 1:Monday...
    List<GatheringInCountriesByDay> findGatheringInCountryByDay(String countryName);

    @Query("select new com.babis.BluetoothServer.dto.GatheringByCountryByDay(b.city, count(b.city)) " +
            "from BluetoothData b " +
            "where b.country=?1 " +
            "and extract(isodow from b.timestamp)=?2 " +
            "group by b.city " +
            "order by count(b.city) desc") //0:Sunday 1:Monday...
    List<GatheringByCountryByDay> findGatheringByCountryByDay(String countryName, int day);

    @Query("SELECT new com.babis.BluetoothServer.dto.LatLongByCountry(b.country, b.latitude, b.longitude)" +
            "FROM BluetoothData b " +
            "WHERE country=?1 ")
    List<LatLongByCountry> getLatLongByCountry(String countryName);
}
