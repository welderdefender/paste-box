package com.example.pasteboxproject;

import com.example.pasteboxproject.api.response.PasteBoxResponse;
import com.example.pasteboxproject.exception.NotFoundEntityException;
import com.example.pasteboxproject.model.PasteBoxEntity;
import com.example.pasteboxproject.repository.PasteBoxRepository;
import com.example.pasteboxproject.service.PasteBoxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteBoxServiceTests {

    @Autowired
    private PasteBoxService pasteBoxService;

    @MockBean
    private PasteBoxRepository pasteBoxRepository;

    @Test
    public void notExistHash() {
        when(pasteBoxRepository.getByHash(anyString())).thenThrow(NotFoundEntityException.class);
        assertThrows(NotFoundEntityException.class, () -> pasteBoxService.getByHash("askdlfa"));
    }

    @Test
    public void getExistingHash() {
        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setHash("1");
        pasteBoxEntity.setData("11");
        pasteBoxEntity.setPublic(true);

        when(pasteBoxRepository.getByHash("1")).thenReturn(pasteBoxEntity);

        PasteBoxResponse expected = new PasteBoxResponse("11", true);
        PasteBoxResponse actual = pasteBoxService.getByHash("1");

        assertEquals(expected, actual);
    }
}