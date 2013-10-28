package com.tutorials_point.DesignPatterns.ObserverPattern.mvc.view;

import com.tutorials_point.DesignPatterns.ObserverPattern.mvc.model.EventModel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * Created with IntelliJ IDEA.
 * User: mabdira
 * Date: 7/10/13
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventView extends JFrame implements ActionListener {

    private EventModel model;
    private JButton okButton;
    private JTextField nameField;
    private JPasswordField passField;

    private LoginListener loginListener;

    public EventView(EventModel model) {
        super("MVC Demo");

        this.model = model;

        nameField = new JTextField(10);
        passField = new JPasswordField(10);
        okButton = new JButton("OK");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.gridx=1;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(100, 0, 0, 10);
        gc.fill=GridBagConstraints.NONE;

        add(new JLabel("Name: "), gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx=2;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(100, 0, 0, 0);
        gc.fill=GridBagConstraints.NONE;

        add(nameField, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx=1;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.fill=GridBagConstraints.NONE;

        add(new JLabel("Password: "), gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx=2;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill=GridBagConstraints.NONE;

        add(passField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx=2;
        gc.gridy=3;
        gc.weightx=1;
        gc.weighty=100;
        gc.fill=GridBagConstraints.NONE;

        add(okButton, gc);

        okButton.addActionListener(this);

        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String password = new String(passField.getPassword());
        String name = nameField.getText();

        fireLoginEvent(new LoginFormEvent(name, password));
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void fireLoginEvent(LoginFormEvent event) {
        if(loginListener != null) {
            loginListener.loginPerformed(event);
        }
    }

}

