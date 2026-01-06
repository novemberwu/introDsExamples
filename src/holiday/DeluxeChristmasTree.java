package holiday;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class DeluxeChristmasTree extends JPanel implements ActionListener {
    private int frameCount = 0;
    private ArrayList<Snowflake> snowLayer1 = new ArrayList<>();
    private ArrayList<Snowflake> snowLayer2 = new ArrayList<>();
    private Random rand = new Random();

    public DeluxeChristmasTree() {
        // Create two layers of snow for 3D depth
        for (int i = 0; i < 80; i++) snowLayer1.add(new Snowflake(800, 800, 2, 2));
        for (int i = 0; i < 50; i++) snowLayer2.add(new Snowflake(800, 800, 4, 4));

        Timer timer = new Timer(30, this);
        timer.start();
        playMusic("carol.wav"); // Ensure this file is in your project folder
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Sky Gradient
        GradientPaint sky = new GradientPaint(0, 0, new Color(5, 10, 30), 0, getHeight(), new Color(20, 40, 80));
        g2d.setPaint(sky);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 2. Background Snow (Slow)
        g2d.setColor(new Color(255, 255, 255, 150));
        for (Snowflake s : snowLayer1) {
            s.update(getWidth(), getHeight());
            g2d.fillOval(s.x, s.y, s.size, s.size);
        }

        // 3. Draw Fractal Tree
        int centerX = getWidth() / 2;
        int baseY = getHeight() - 150;
        double sway = Math.sin(frameCount * 0.04) * 0.1; // Gentle 3D sway

        drawTrunk(g2d, centerX, baseY);
        drawFractalTree(g2d, centerX, baseY, -Math.PI / 2 + sway, 100, 7);

        // 4. Foreground Snow (Fast/Big)
        g2d.setColor(Color.WHITE);
        for (Snowflake s : snowLayer2) {
            s.update(getWidth(), getHeight());
            g2d.fillOval(s.x, s.y, s.size, s.size);
        }

        // 5. Text Overlay
        g2d.setFont(new Font("Serif", Font.ITALIC, 40));
        g2d.setColor(new Color(255, 215, 0, (int)(150 + 100 * Math.sin(frameCount * 0.05))));
        g2d.drawString("Merry Christmas", centerX - 130, 80);

        frameCount++;
    }

    private void drawTrunk(Graphics2D g2d, int x, int y) {
        g2d.setColor(new Color(60, 40, 20));
        g2d.fillRect(x - 15, y, 30, 60);
    }

    private void drawFractalTree(Graphics2D g2d, int x, int y, double angle, double length, int depth) {
        if (depth == 0) return;

        int x2 = x + (int) (Math.cos(angle) * length);
        int y2 = y + (int) (Math.sin(angle) * length);

        // Branch color gets lighter/greener towards the top
        g2d.setColor(new Color(20, 60 + (depth * 15), 20));
        g2d.setStroke(new BasicStroke(depth * 1.5f));
        g2d.drawLine(x, y, x2, y2);

        // Draw Glowing Ornaments at the tips
        if (depth < 4 && frameCount % 10 < 7) {
            drawGlow(g2d, x2, y2, depth);
        }

        // Recursive branches
        drawFractalTree(g2d, x2, y2, angle - 0.4 + (Math.sin(frameCount*0.02)*0.05), length * 0.8, depth - 1);
        drawFractalTree(g2d, x2, y2, angle + 0.4 + (Math.sin(frameCount*0.02)*0.05), length * 0.8, depth - 1);
    }

    private void drawGlow(Graphics2D g2d, int x, int y, int depth) {
        Color[] colors = {Color.RED, Color.YELLOW, Color.CYAN, Color.MAGENTA};
        Color c = colors[(depth + frameCount/10) % colors.length];

        // Simple radial glow
        g2d.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
        g2d.fillOval(x - 6, y - 6, 12, 12);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x - 2, y - 2, 4, 4);
    }

    public void playMusic(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(stream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }
        } catch (Exception e) { System.out.println("Audio Error: Place 'carol.wav' in folder."); }
    }

    @Override
    public void actionPerformed(ActionEvent e) { repaint(); }

    public static void main(String[] args) {
        JFrame f = new JFrame("3D Fractal Christmas");
        f.add(new DeluxeChristmasTree());
        f.setSize(800, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    class Snowflake {
        int x, y, size, speed;
        Snowflake(int w, int h, int s, int sp) {
            x = rand.nextInt(w); y = rand.nextInt(h);
            size = rand.nextInt(s) + 2;
            speed = rand.nextInt(sp) + 1;
        }
        void update(int w, int h) {
            y += speed;
            x += Math.sin(y * 0.01); // Drifting effect
            if (y > h) { y = -10; x = rand.nextInt(w); }
        }
    }
}

