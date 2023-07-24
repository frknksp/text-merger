package com.example.TextService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DBtext {

    private List<String> metinList;
    private String MergedText;
    private double ElapsedTime;



}
