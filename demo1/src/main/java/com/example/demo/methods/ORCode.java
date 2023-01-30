package com.example.demo.methods;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ORCode {
    /**
     * 二维码生成
     */
    public static void main(String[] args) throws Exception {
        MultiFormatWriter mfw = new MultiFormatWriter();
        //二维码的内容
        String str = "姜信同的二维码！";
        //二维码的格式
        BarcodeFormat type = BarcodeFormat.QR_CODE;
        //二维码的宽度、高度
        int width = 600;
        int height = 600;
        Map<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 2);
        BitMatrix bitMatrix = mfw.encode(str, type, width, height, map);
        int black = Color.BLACK.getRGB();
        int white = Color.WHITE.getRGB();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? black : white);
            }
        }
        File file = new File("C://Users//lenovo//Desktop//test.jpg");
        ImageIO.write(bufferedImage, "jpg", file);

    }
}
