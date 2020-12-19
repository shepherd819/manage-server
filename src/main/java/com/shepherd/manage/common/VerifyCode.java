package com.shepherd.manage.common;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 20:11
 */
public class VerifyCode {
    private int with = 100;
    private int height = 30;
    private String[] fontNames = {"宋体","楷体","隶书","微软雅黑"};
    private Color bgColor = new Color(255,255,255);
    private Random random = new Random();
    private String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String text;

    /**
     * 随机生成颜色
     * @return
     */
    private Color randomColor(){
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red,green,blue);
    }

    /**
     * 随机生成字体
     * @return
     */
    private Font randomFont(){
        String name = fontNames[random.nextInt(fontNames.length)];
        int style = random.nextInt(4);
        int size = random.nextInt(5)+24;
        return new Font(name,style,size);
    }

    /**
     * 随机获取一个字符
     * @return
     */
    private char randomChar(){
        return codes.charAt(random.nextInt(codes.length()));
    }

    /**
     * 生成空白图片
     * @return
     */
    private BufferedImage createImage(){
        BufferedImage image = new BufferedImage(with,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(bgColor);
        g2.fillRect(0,0,with,height);
        return image;
    }

    /**
     * 生成验证码图片
     * @return
     */
    public BufferedImage getImage(){
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            g2.setColor(randomColor());
            g2.setFont(randomFont());
            float x = i * with * 1.0f / 4;
            g2.drawString(s,x,height-8);
        }
        this.text = sb.toString();
        drawLine(image);
        return  image;
    }

    /**
     * 绘制干扰线
     * @param image
     */
    private void drawLine(BufferedImage image) {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(with);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(with);
            int y2 = random.nextInt(height);
            g2.setColor(randomColor());
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x1,y1,x2,y2);
        }
    }

    public String getText() {
        return text;
    }

    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image,"JPEG",out);
    }

}
