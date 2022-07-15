package core;

import commons.RuneType;
import models.Rune;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    private static ImageHandler imageHandler;

    private ImageHandler() {}

    public static ImageHandler getInstance() {
        if( imageHandler == null )
            imageHandler = new ImageHandler();

        return imageHandler;
    }

    private static final String path = "resources" + File.separator;

    public Image getRuneImg (Rune rune ) {
        String filename;
        if(rune.getType() == RuneType.Type.STONE) {
            filename = RuneType.Type.STONE.getName() + ".png";
        }
        else {
            filename = rune.getShape().getName() + rune.getColor().getName() + ".png";
        }
        //File file = new File(path + filename);
        Image icona = null;
        try {
            icona = ImageIO.read( getClass().getClassLoader().getResourceAsStream(path+filename) );
        } catch (IOException e) {e.printStackTrace();}
        return icona;
    }

//    public static String getRunePath(Rune rune) {
//        String filename;
//        if(rune.getType() == RuneType.Type.STONE) {
//            filename = RuneType.Type.STONE.getName() + ".png";
//        }
//        else {
//            filename = rune.getShape().getName() + rune.getColor().getName()+".png";
//        }
//        return path + filename;
//    }

    public Image getBottleImg (int index) {
        //File file = new File( getClass().getClassLoader().getResource(path + "Bottle" + index + ".png").toString() );
        Image icona = null;
        try {
            icona = ImageIO.read( getClass().getClassLoader().getResourceAsStream(path + "Bottle" + index + ".png") );
        } catch (IOException e) {e.printStackTrace();}
        return icona;
    }
}
