package main.utils;

import java.net.URL;

public class Resources {
    public static URL getImgByName(String imgFullName){
        return Resources.class.getClassLoader().getResource("resources/img/"+imgFullName);
    }
}
