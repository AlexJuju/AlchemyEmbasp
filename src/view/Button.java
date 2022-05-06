package view;

import commons.Enums;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private Enums.ButtonAction action;
    private int i_idx;
    private int j_idx;

    Button(String string, Enums.ButtonAction action, ActionListener listener, int i, int j) {
        super(string);
        this.action = action;
        this.i_idx = i;
        this.j_idx = j;
        this.addActionListener(listener);
    }

    public Enums.ButtonAction getButtonAction () {
        return this.action;
    }

    public int getI_idx() {
        return i_idx;
    }

    public int getJ_idx() {
        return j_idx;
    }
}
