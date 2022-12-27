package com.example.pasteboxproject.repository;

import com.example.pasteboxproject.model.PasteBoxEntity;

import java.util.List;

public interface PasteBoxRepository {
    PasteBoxEntity getByHash(String hash);

    List<PasteBoxEntity> getListOfPublicAndAlive(int amount);

    void add(PasteBoxEntity pasteBoxEntity);
}