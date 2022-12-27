package com.example.pasteboxproject.controller;

import com.example.pasteboxproject.api.request.PasteBoxRequest;
import com.example.pasteboxproject.api.response.PasteBoxResponse;
import com.example.pasteboxproject.api.response.PasteBoxUrlResponse;
import com.example.pasteboxproject.service.PasteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PasteBoxController {
    private final PasteBoxService pasteBoxService;

    @GetMapping("/")
    public Collection<PasteBoxResponse> getPublicPasteBoxes() {
        return pasteBoxService.getFirstPublicPasteBoxes();
    }

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash) {
        return pasteBoxService.getByHash(hash);
    }

    @PostMapping("/")
    public PasteBoxUrlResponse add(@RequestBody PasteBoxRequest request) {
        return pasteBoxService.create(request);
    }
}