package com.gist.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by kh1888 on 08/10/17.
 */

@RequestMapping("/GistServices")
public class GistBaseController {

    public ResponseEntity handleEmptyObjects() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    public ResponseEntity handleRecordNotFound() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
    }
}
