package holiday;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class QuietChristmasTree extends JPanel implements ActionListener {
    private int frameCount = 0;
    private ArrayList<Snowflake> snowflakes = new ArrayList<>();
    private Random rand = new Random();

    public QuietChristmasTree() {
        // 初始化雪花
        for (int i = 0; i < 250; i++) {
            snowflakes.add(new Snowflake());
        }
        // 设置动画定时器
        Timer timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. 夜空渐变背景
        GradientPaint sky = new GradientPaint(0, 0, new Color(5, 10, 25), 0, getHeight(), new Color(20, 35, 65));
        g2d.setPaint(sky);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 2. 绘制动态雪花
        g2d.setColor(Color.WHITE);
        for (Snowflake s : snowflakes) {
            s.update(getWidth(), getHeight());
            g2d.fillOval(s.x, s.y, s.size, s.size);
        }

        int centerX = getWidth() / 2;
        int groundY = getHeight() - 50;
        int treeBaseY = groundY - 20;

        // 3. 绘制雪地
        g2d.setColor(new Color(240, 248, 255));
        g2d.fillArc(-100, groundY - 40, getWidth() + 200, 150, 0, 180);
        g2d.setColor(new Color(200, 220, 240));
        g2d.drawArc(-100, groundY - 41, getWidth() + 200, 150, 0, 180);

        // 4. 绘制树干
        g2d.setColor(new Color(45, 30, 15));
        g2d.fillRect(centerX - 18, treeBaseY - 40, 36, 50);

        // 5. 绘制下宽上窄的圣诞树层
        int layers = 6;
        for (int i = 0; i < layers; i++) {
            int y = treeBaseY - 30 - (i * 55);
            int width = 360 - (i * 55);
            int height = 100;

            // 绘制深绿底层和亮绿表层
            g2d.setColor(new Color(15, 45, 15));
            drawTreeLayer(g2d, centerX, y, width + 10, height);
            g2d.setColor(new Color(34, 105, 34));
            drawTreeLayer(g2d, centerX, y - 5, width, height - 10);
        }

        // 6. 绘制金色装饰带
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(255, 215, 0, 150));
        for (int i = 0; i < layers - 1; i++) {
            int y = treeBaseY - 60 - (i * 55);
            int w = 310 - (i * 55);
            g2d.drawArc(centerX - w/2, y, w, 35, 0, -180);
        }

        // 7. 彩色闪烁灯
        drawLights(g2d, centerX, treeBaseY);

        // 8. 树顶大金星
        int starY = treeBaseY - 30 - ((layers - 1) * 55) - 95;
        drawStar(g2d, centerX, starY);

        // 9. 堆放礼物盒和 Ivy League Offer
        drawGiftsAndOffer(g2d, centerX, groundY);

        frameCount++;
    }

    private void drawTreeLayer(Graphics2D g2d, int cx, int y, int w, int h) {
        Polygon p = new Polygon();
        p.addPoint(cx - w / 2, y);
        p.addPoint(cx + w / 2, y);
        p.addPoint(cx, y - h);
        g2d.fillPolygon(p);
    }

    private void drawLights(Graphics2D g2d, int cx, int baseY) {
        Color[] colors = {Color.RED, Color.YELLOW, Color.CYAN, Color.WHITE, Color.ORANGE};
        for (int i = 0; i < 35; i++) {
            Random r = new Random(i * 99);
            int layer = r.nextInt(6);
            int wLimit = 300 - (layer * 50);
            int x = cx + r.nextInt(wLimit + 1) - wLimit / 2;
            int y = baseY - 60 - (layer * 55) - r.nextInt(40);

            if ((frameCount + i) % 30 < 15) {
                Color c = colors[i % colors.length];
                g2d.setColor(c);
                g2d.fillOval(x, y, 7, 7);
                g2d.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 60));
                g2d.fillOval(x - 3, y - 3, 13, 13);
            }
        }
    }

    private void drawStar(Graphics2D g2d, int x, int y) {
        g2d.setColor(new Color(255, 255, 200, 150));
        g2d.fillOval(x - 25, y - 25, 50, 50);
        g2d.setColor(new Color(255, 220, 0));
        int[] px = new int[10];
        int[] py = new int[10];
        for (int i = 0; i < 10; i++) {
            double angle = Math.PI / 5 * i - Math.PI / 2;
            double r = (i % 2 == 0) ? 22 : 9;
            px[i] = x + (int) (Math.cos(angle) * r);
            py[i] = y + (int) (Math.sin(angle) * r);
        }
        g2d.fillPolygon(px, py, 10);
    }

    private void drawGiftsAndOffer(Graphics2D g2d, int centerX, int groundY) {
        // 绘制几个不同颜色的礼物盒
        drawSingleBox(g2d, centerX - 180, groundY - 60, 70, 60, new Color(200, 50, 50), Color.YELLOW, false);
        drawSingleBox(g2d, centerX + 100, groundY - 70, 80, 70, new Color(50, 150, 200), Color.RED, false);
        drawSingleBox(g2d, centerX - 100, groundY - 140, 60, 50, new Color(200, 100, 50), Color.WHITE, false);

        // 带有 Offer 的特殊礼物盒
        drawSingleBox(g2d, centerX + 20, groundY - 150, 80, 60, new Color(150, 50, 200), Color.CYAN, true);
    }

    private void drawSingleBox(Graphics2D g2d, int x, int y, int w, int h, Color boxC, Color ribC, boolean hasOffer) {
        g2d.setColor(boxC);
        g2d.fillRect(x, y, w, h);
        g2d.setColor(ribC);
        g2d.fillRect(x + w / 2 - 4, y, 8, h);
        g2d.fillRect(x, y + h / 2 - 4, w, 8);

        if (hasOffer) {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(x + 5, y - 35, w - 10, 30);
            g2d.setColor(new Color(0, 50, 0)); // 常春藤绿
            g2d.setFont(new Font("Arial", Font.BOLD, 10));
            g2d.drawString("IVY LEAGUE", x + 10, y - 22);
            g2d.drawString("OFFER", x + 25, y - 10);
        }
    }

    @Override public void actionPerformed(ActionEvent e) { repaint(); }

    public static void main(String[] args) {
        JFrame f = new JFrame("Silent Christmas & Success");
        f.add(new QuietChristmasTree());
        f.setSize(750, 900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    class Snowflake {
        int x = rand.nextInt(750), y = rand.nextInt(900), size = rand.nextInt(4) + 2, speed = rand.nextInt(3) + 1;
        void update(int w, int h) {
            y += speed;
            x += Math.sin(y * 0.02);
            if (y > h - 50) { y = -10; x = rand.nextInt(w); }
        }
    }
}
