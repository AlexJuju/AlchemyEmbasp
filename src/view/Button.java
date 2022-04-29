package view;

import commons.Enums;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private Enums.ButtonAction action;

    Button(String string, Enums.ButtonAction action, ActionListener listener) {
        super(string);
        this.action = action;
        this.addActionListener(listener);
    }

    public Enums.ButtonAction getButtonAction () {
        return this.action;
    }
}
