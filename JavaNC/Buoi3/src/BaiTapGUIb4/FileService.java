package BaiTapGUIb4;

import java.io.*;

public class FileService {
    public static void luuFile(Object obj, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        } catch (Exception e) { e.printStackTrace(); }
    }
    public static Object docFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        } catch (Exception e) { return null; }
    }
}