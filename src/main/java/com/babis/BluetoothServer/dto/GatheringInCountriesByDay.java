package com.babis.BluetoothServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GatheringInCountriesByDay {

    private int day; // 0:Sunday 1:Monday ...
    private long count;

}
