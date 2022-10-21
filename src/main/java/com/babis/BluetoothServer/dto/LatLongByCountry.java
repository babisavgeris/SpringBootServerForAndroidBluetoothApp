package com.babis.BluetoothServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LatLongByCountry {
    private String country;
    private double latitude;
    private double longitude;
}
