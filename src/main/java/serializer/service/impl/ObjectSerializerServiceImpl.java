package serializer.service.impl;

import serializer.service.ObjectSerializationService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSerializerServiceImpl implements ObjectSerializationService {

    @Override
    public Object serializeObject(Object object, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);) {
            System.out.println("Start serialization");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();

            System.out.println("Success serialization");
            return object;
        } catch (IOException e) {
            throw new RuntimeException("Can't serialize object", e);
        }
    }
}
