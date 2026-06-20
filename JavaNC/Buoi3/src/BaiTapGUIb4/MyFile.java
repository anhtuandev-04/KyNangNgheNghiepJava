package BaiTapGUIb4;

import java.io.*;

public class MyFile {
    public static void luuDoiTuong(Object obj, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(obj);
        } catch(Exception ex) { ex.printStackTrace(); }
    }
    public static Object docDoiTuong(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return in.readObject();
        } catch(Exception ex) { return null; }
    }
}
