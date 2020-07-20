package priv.lyq.springboot.web.entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author Li Yuqing
 */
public class VerifyCode {
    /**
     * 图片宽 单位：像素
     */
    private int width = 75;
    /**
     * 图片高 单位：像素
     */
    private int height = 35;

    /**
     * 默认画干扰线
     */
    private boolean line = true;
    /**
     * 生成随机数
     */
    private Random r = new Random();
    /**
     * 列举验证图片中验证码的字体类型
     */
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};

    /**
     * 背景色
     */
    private Color bgColor = Color.white;

    /**
     * 验证码上的文本
     */
    private String text;

    /**
     * 生成随机的颜色
     *
     * @return Color
     */
    private Color randomColor() {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 生成随机的字体
     *
     * @return Font
     */
    private Font randomFont() {
        int index = r.nextInt(fontNames.length);
        //生成随机的字体名称
        String fontName = fontNames[index];
        //生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int style = r.nextInt(4);
        //生成随机字号, 24 ~ 28
        int size = r.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    /**
     * 画干扰线
     *
     * @param image BufferedImage
     */
    private void drawLine(BufferedImage image) {
        //一共画3条
        int num = 3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        //生成两个点的坐标，即4个值
        for (int i = 0; i < num; i++) {
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));
            //干扰线是蓝色
            g2.setColor(Color.BLUE);
            //画线
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 随机生成一个字符
     *
     * @return char
     */
    private char randomChar() {
        // 验证码可选字符
        String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 创建BufferedImage
     *
     * @return BufferedImage
     */
    private BufferedImage createImage() {
        //宽，高，图片的类型
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 保存图片到指定的输出流
     *
     * @param image BufferedImage
     * @param out   OutputStream
     * @throws IOException IOException
     */
    public static void output(BufferedImage image, OutputStream out)
            throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

    /**
     * 调用这个方法得到验证码
     *
     * @return BufferedImage
     */
    public BufferedImage getImage() {
        // 创建图片缓冲区
        BufferedImage image = createImage();
        // 得到绘制环境
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        // 用来装载生成的验证码文本
        StringBuilder sb = new StringBuilder();
        // 向图片中画4个字符，循环四次，每次生成一个字符
        for (int i = 0; i < 4; i++) {
            // 随机生成一个字母
            String s = randomChar() + "";
            // 把字母添加到sb中
            sb.append(s);
            // 设置当前字符的x轴坐标
            float x = i * 1.0F * width / 4;
            // 设置当前字符的y轴坐标
            float y = height - (height / 3.2F);
            // 设置随机字体
            g2.setFont(randomFont());
            // 设置随机颜色
            g2.setColor(randomColor());
            // 画图
            g2.drawString(s, x, y);
        }
        // 把生成的字符串赋给了this.text
        this.text = sb.toString();
        // 添加干扰线
        if (line) {
            drawLine(image);
        }
        return image;
    }

    /**
     * 返回验证码图片上的文本
     *
     * @return 文本
     */
    public String getText() {
        return text;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLine(boolean line) {
        this.line = line;
    }
}
