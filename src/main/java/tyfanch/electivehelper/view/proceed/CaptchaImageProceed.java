package tyfanch.electivehelper.view.proceed;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaImageProceed {
    /**
     * 生成验证码图像
     *
     * @param width 图像宽度
     * @param height 图像高度
     * @param captcha 验证码内容
     * @return 生成的验证码图像
     */
    public BufferedImage generateCaptchaImage(int width, int height, String captcha) {
        BufferedImage image;
        Graphics graphics;

        // 新建图像
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取画布
        graphics = image.getGraphics();
        // 画出背景
        this.drawBackground(graphics, width, height);
        // 画出验证码
        this.drawCaptcha(graphics, width, captcha);
        // 画出随机线条
        this.drawRandomLine(graphics, width, height, captcha.length());

        return image;
    }

    /**
     * 画出背景
     *
     * @param graphics 目标图像
     * @param width 画布宽度
     * @param height 画布高度
     */
    private void drawBackground(Graphics graphics, int width, int height) {
        // 背景颜色
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, 0, width, height);
    }

    /**
     * 画出验证码
     *
     * @param graphics 目标图像
     * @param width 画布宽度
     * @param captcha 验证码
     */
    private void drawCaptcha(Graphics graphics, int width, String captcha) {
        Random random = new Random();
        // 每个字符的宽度，多留下一个字符的空间
        int charWidth = width / (captcha.length() + 1);

        for (int i = 0; i < captcha.length(); i++) {
            // 转化成2D画布，用于旋转
            Graphics2D graphics2D = (Graphics2D) graphics;
            Color color = this.generateRandomColor();
            // 随机角度
            int degree = random.nextInt(90) - 45;
            // 弧度
            double radian = degree * Math.PI / 180.0;
            // 字符坐标
            int x = charWidth * i + charWidth / 2;
            int y = charWidth;

            graphics2D.setFont(new Font("Arial", Font.BOLD, charWidth));
            graphics2D.setColor(color);
            graphics2D.rotate(radian, x, y);
            graphics2D.drawString(captcha.substring(i, i + 1), x, y);
            graphics2D.rotate(-radian, x, y);
        }
    }

    /**
     * 画出随机干扰线
     *
     * @param graphics 目标图像
     * @param width 线条最大宽度
     * @param height 线条最大高度
     * @param count 线条数量
     */
    private void drawRandomLine(Graphics graphics, int width, int height, int count) {
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Color color = this.generateRandomColor();
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            graphics.setColor(color);
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 生成随机颜色
     *
     * @return 生成的颜色对象
     */
    private Color generateRandomColor() {
        Random random = new Random();
        Color color;

        color = new Color(random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256));

        return color;
    }
}
