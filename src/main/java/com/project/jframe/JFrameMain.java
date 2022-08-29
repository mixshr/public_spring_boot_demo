package com.project.jframe;

import com.project.integrated.MainSpringApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain extends JFrame {

    private String[] args;

    private JButton buttonRunService = new JButton("Запустить сервис");
    private JButton buttonStopService = new JButton("Остановить сервис");

    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);

    public JFrameMain(String[] args) throws HeadlessException {

        this.args = args;

        this.setTitle("Панель управления сервисом");
        this.setBounds(500, 500, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5, 5, 5, 5));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(buttonRunService);
        buttonGroup.add(buttonStopService);

        buttonRunService.addActionListener(new ButtonEventListenerRunService());
        buttonStopService.addActionListener(new ButtonEventListenerCloseService());

        container.add(buttonRunService);
        container.add(buttonStopService);


     /*   Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        container.add(radio1);

        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);*/
    }

    class ButtonEventListenerRunService implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            boolean serviceIsStarted = MainSpringApplication.isActive();

            if (!serviceIsStarted) {
                MainSpringApplication.run(args);
            }

            String message = "Сервис запущен";

            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonEventListenerCloseService implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            boolean serviceIsStarted = MainSpringApplication.isActive();

            if (serviceIsStarted) {
                MainSpringApplication.stop();
            }

            String message = (serviceIsStarted) ? "Сервис был успешно остановлен":"Сервис уже остановлен";

            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
