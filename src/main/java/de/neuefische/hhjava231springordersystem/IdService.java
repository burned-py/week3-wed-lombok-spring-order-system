package de.neuefische.hhjava231springordersystem;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
