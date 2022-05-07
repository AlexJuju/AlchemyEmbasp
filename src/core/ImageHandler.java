package core;

import commons.RuneType;
import models.Rune;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    private static final String path = "src"+ File.separator+"resources" + File.separator;

    public static Image getRuneImg (Rune rune ) {
        String filename;
        if(rune.getType() == RuneType.Type.STONE) {
            filename = RuneType.Type.STONE.getName()+".png";
        }
        else {
            filename = rune.getShape().getName() + rune.getColor().getName()+".png";
        }
        File file = new File( path + filename);
        Image icona = null;
        try {
            icona = ImageIO.read(file);
        } catch (IOException e) {e.printStackTrace();}
        return icona;
    }

    public static String getRunePath(Rune rune) {
        String filename;
        if(rune.getType() == RuneType.Type.STONE) {
            filename = RuneType.Type.STONE.getName()+".png";
        }
        else {
            filename = rune.getShape().getName() + rune.getColor().getName()+".png";
        }
        return path + filename;
    }

    public static Image getBottleImg (int index) {
        File file = new File( path + "Bottle" + index + ".png");
        Image icona = null;
        try {
            icona = ImageIO.read(file);
        } catch (IOException e) {e.printStackTrace();}
        return icona;
    }
}
