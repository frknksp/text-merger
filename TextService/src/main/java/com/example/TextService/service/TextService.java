package com.example.TextService.service;

import com.example.TextService.model.DBtext;
import com.example.TextService.repository.TextRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TextService {
    private final TextRepository textRepository;

    public List <DBtext> getAllTexts() {
        return textRepository.findAll();
    }
    public void createText(DBtext dBtext) {
        if (!dBtext.getMergedText().isEmpty()) {
            textRepository.save(dBtext);
        }
        else {
            System.out.println("Text is empty");
        }
//        return textRepository.save(dBtext);
    }

}
