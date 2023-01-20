package com.github.phoswald.sample;

import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwingApplication extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(SwingApplication.class);

    public SwingApplication() {
        super("SwingApplication");
        initComponents();
        setMinimumSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    private void initComponents() {
        JLabel label = new JLabel("Hello World", JLabel.CENTER);
        getContentPane().add(label);
    }

    public static void main(String[] args) {
        logger.info("main() called with args={}", Arrays.asList(args));
        new SwingApplication().setVisible(true);
    }
}
