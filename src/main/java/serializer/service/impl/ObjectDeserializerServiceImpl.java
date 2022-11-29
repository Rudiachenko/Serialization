package serializer.service.impl;

import serializer.service.ObjectDeserializationService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectDeserializerServiceImpl implements ObjectDeserializationService {

    @Override
    public Object deserializeObject(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("Start deserialization");

            Object object = objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("Success deserialization");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Can't deserialize object", e);
        }
    }
}
