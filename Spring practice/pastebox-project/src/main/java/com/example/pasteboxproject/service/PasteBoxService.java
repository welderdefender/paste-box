package com.example.pasteboxproject.service;

import com.example.pasteboxproject.api.request.PasteBoxRequest;
import com.example.pasteboxproject.api.response.PasteBoxResponse;
import com.example.pasteboxproject.api.response.PasteBoxUrlResponse;

import java.util.List;

public interface PasteBoxService {
    PasteBoxResponse getByHash(String hash);
    List<PasteBoxResponse> getFirstPublicPasteBoxes();
    PasteBoxUrlResponse create(PasteBoxRequest request);
}
