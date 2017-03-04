package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes)
    {
        if (imageTypes == ImageTypes.JPG) return new JpgReader();
        if (imageTypes == ImageTypes.BMP) return new BmpReader();
        if (imageTypes == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
