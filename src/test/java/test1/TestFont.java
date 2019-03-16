package test1;

import com.lowagie.text.FontFactory;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: javademo
 * @description: 测试字体
 * @author: chenp
 * @create: 2018-12-29 15:08
 **/
public class TestFont {
    @Test
    public void  test(){
        String fontPath = "D:\\Workspaces\\idea\\demo-java\\src\\main\\java\\com\\font\\mingliu.ttc";
        File fontFile = new File(fontPath);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT,fontFile);
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            boolean mingliu = Arrays.stream(graphicsEnvironment.getAllFonts()).anyMatch(s -> s.getFontName().equals("mingliu"));
            graphicsEnvironment.registerFont(font);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void registerFont(String fontPath,String fontName){
        File fontFile = new File(fontPath);
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT,fontFile);
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            boolean isExit = Arrays.stream(graphicsEnvironment.getAllFonts()).anyMatch(s -> s.getFontName().equals(fontName));
            if (!isExit){
                graphicsEnvironment.registerFont(font);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}