package com.example.pasteboxproject.controller;

import com.example.pasteboxproject.api.request.PasteBoxRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
public class PasteBoxController {

    @GetMapping("/")
    public Collection<String> getPublicPasteBoxes() {
        return Collections.emptyList();
    }

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash) {
        return hash;
    }

    @PostMapping("/")
    public String add(@RequestBody PasteBoxRequest request) {
        return request.getData();
    }
}