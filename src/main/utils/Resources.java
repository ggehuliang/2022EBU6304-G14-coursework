package main.utils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Resources {
    public static URL getImgByName(String imgFullName) {
        return Resources.class.getClassLoader().getResource("resources/img/" + imgFullName);
    }

    public static void extractFile(String fileName) {
        String filePath = "resources/data/" + fileName;
        InputStream is = Resources.class.getClassLoader().getResourceAsStream(filePath);
        File file = new File(filePath);
        try {
            file.createNewFile();
            OutputStream os = new FileOutputStream(file);
            int index = 0;
            byte[] bytes = new byte[1024];
            while ((index = is.read(bytes)) != -1) {
                os.write(bytes, 0, index);
            }
            os.flush();
            os.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void extractData() {
        File folder = new File("resources/data");
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
            extractFile("person.json");
            extractFile("service.json");
            extractFile("flight.json");
        } else {
            System.out.println("Data already exist, start loading.");
        }

    }

    public static String readDataToString(String fileName) {
        String encoding = "UTF-8";
        String fileURL = "resources/data/" + fileName;
        File file = new File(fileURL);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeStringData(String fileName, String data) {
        String fileURL = "resources/data/" + fileName;
        File file = new File(fileURL);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(data);
            osw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
