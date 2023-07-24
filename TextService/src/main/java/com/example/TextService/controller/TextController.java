package com.example.TextService.controller;

import com.example.TextService.TextMerger;
import com.example.TextService.WebConfig;
import com.example.TextService.model.DBtext;
import com.example.TextService.model.Response;
import com.example.TextService.model.Text;
import com.example.TextService.service.TextService;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Import(WebConfig.class)
@RestController
@RequestMapping("/texts")
@CrossOrigin(maxAge = 3600)
@AllArgsConstructor

public class TextController {
    private final TextService TextService;

    @GetMapping
    public ResponseEntity<List<DBtext>> getTexts() {
        return new ResponseEntity<>(TextService.getAllTexts(), null, 200);
    }

    @PostMapping
    public ResponseEntity<Response> createTexts(@RequestBody Text[] texts) {

        List<Text> textList = Arrays.asList(texts);
        List<String > cumleler = new ArrayList< >();

        for (Text text : textList) {
            cumleler.add(text.getText());
        }
        long start = System.nanoTime();
        String mergedText =  TextMerger.mergeTexts(cumleler);
        long finish = System.nanoTime();
        double timeElapsed = (finish - start)/(double) 1000000;
        System.out.println("Time Elapsed: " + timeElapsed +" ms");
        Response response = new Response(mergedText, timeElapsed);
        System.out.println("Merged Text: " + mergedText);


        return new ResponseEntity<>(response, null, 201);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTexts(@RequestBody DBtext dbtext) {
        System.out.println(dbtext);

//        Database kontrol ve ekleme
        List<DBtext> textsFromDB = TextService.getAllTexts();
        for (DBtext textFromDB : textsFromDB) {
            if (Objects.equals(textFromDB.getMetinList(), dbtext.getMetinList())) {
                System.out.println("Texts are same");
                return new ResponseEntity<>("Aynı textler var, başarısız", null, 201);

            }
        }

        System.out.println("Texts are not same");
        TextService.createText(new DBtext(dbtext.getMetinList(), dbtext.getMergedText(), dbtext.getElapsedTime()));
        return new ResponseEntity<>("Başarılı", null, 201);

    }

}
