package view;

import commons.Enums;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private Enums.ButtonAction action;
    private int x;
    private int y;

    Button(String string, Enums.ButtonAction action, ActionListener listener, int x, int y) {
        super(string);
        this.action = action;
        this.x = x;
        this.y = y;
        this.addActionListener(listener);
    }

    public Enums.ButtonAction getButtonAction () {
        return this.action;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
