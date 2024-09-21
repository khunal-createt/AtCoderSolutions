package com.atCoder.bedinnerContest.controller;


import com.atCoder.bedinnerContest.contest371.Jiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/371")
public class BeginnerContestController {

    @Autowired
    private Jiro jiro;

    @GetMapping("/contest/jiro")
    public ResponseEntity<Character> BeginnerContest(@RequestBody List<Character> relations) {
        return ResponseEntity.ok(jiro.middleBrother(relations));
    }

}
