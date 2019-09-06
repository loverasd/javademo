package com.note.myConcurrent;

/**
 * @Classname ImmutableRGB
 * @Date 2019-08-13 10:52
 * @Created by chenpan
 * @Description 不可变 。RGB对象
 */
public class ImmutableRGB {
    final private int red;
    final private int green;
    final private int blue;
    final private String name;

    private void check(int red, int green, int blue) {
        if (red < 0 || green < 0 || blue < 0 ||
                red > 255 || green > 255 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableRGB(int red, int green, int blue,String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;

    }

    public int getRGB() {
        return (red << 16 | green <<8 | blue);
    }
    public String getName() {
        return name;
    }
    public ImmutableRGB invert(){
        return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "inverse of" + name);
    }

}
