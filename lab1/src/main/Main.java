package main;

import fileReader.CSVFileReader;
import journal.Journal;
import screen.AbstractScreen;
import screen.Monitor;
import screen.Television;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Journal journal = new Journal();
        CSVFileReader reader = new CSVFileReader();
        for (String arg : args) {
            List<String[]> data = reader.readFile(arg);
            journal.write(reader.getMessage());
            //Преобразуем прочитанные из csv файла данные в объекты
            int counterObj = 0;
            if (!data.isEmpty()) {
                AbstractScreen[] arr = new AbstractScreen[data.size()];
                for (String[] strObj : data) {
                    int typeObject = Integer.parseInt(strObj[0]);
                    if (typeObject == 0) {
                        Television television = new Television(strObj[1], Float.parseFloat(strObj[2]), strObj[3], Integer.parseInt(strObj[4]), strObj[5]);
                        arr[counterObj] = television;
                        journal.write("Added object television str " + counterObj);
                    } else if (typeObject == 1) {
                        Monitor monitor = new Monitor(strObj[1], Float.parseFloat(strObj[2]), strObj[3], Integer.parseInt(strObj[4]), Integer.parseInt(strObj[5]));
                        arr[counterObj] = monitor;
                        journal.write("Added object monitor str " + counterObj);
                    } else {
                        journal.write("Error in file Unknown type object in str " + counterObj);
                        return;
                    }
                    counterObj++;
                }
                System.out.println("Before serialization:");
                journal.write("Before serialization");
                for (AbstractScreen obj : arr) {
                    System.out.println(obj.toString());
                    journal.write(obj.toString());
                }

                // Сериализация
                System.out.println("Start seriallization");
                journal.write("Start seriallization");
                FileOutputStream outputStream = new FileOutputStream(".\\saveObjects.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                objectOutputStream.writeObject(arr);

                objectOutputStream.close();
                System.out.println("End seriallization");
                journal.write("End seriallization");
                // Десериализация
                System.out.println("Start deseriallization");
                journal.write("Start deseriallization");
                FileInputStream fileInputStream = new FileInputStream(".\\saveObjects.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                AbstractScreen[] deserializedArr = (AbstractScreen[]) objectInputStream.readObject();
                System.out.println("End deserialization");
                journal.write("End deserialization");

                System.out.println("After serialization:");
                journal.write("After serialization:");
                for (AbstractScreen obj : deserializedArr) {
                    System.out.println(obj.toString());
                    journal.write(obj.toString());
                }
                //
                for (AbstractScreen obj : arr) {
                    System.out.println(obj.turnOn());
                    journal.write(obj.turnOn());
                    System.out.println(obj.turnOff());
                    journal.write(obj.turnOff());
                }
            }
        }
    }
}