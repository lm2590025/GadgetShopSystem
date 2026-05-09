/**
 * GadgetShop.java
 * GUI class for the GadgetShop system.
 * Student: Md Mirazul Islam Rahat
 * Student ID: 221LM2590025
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {
    private ArrayList<Gadget> gadgetList;

    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadSizeField;
    private JTextField displayNumberField;

    private JTextArea displayArea;

    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeCallButton;
    private JButton downloadMusicButton;

    public GadgetShop() {
        gadgetList = new ArrayList<Gadget>();

        setTitle("GadgetShop System - Md Mirazul Islam Rahat");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("GadgetShop System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(10, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Gadget Details"));

        inputPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        inputPanel.add(modelField);

        inputPanel.add(new JLabel("Price (£):"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Weight (grams):"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Size:"));
        sizeField = new JTextField();
        inputPanel.add(sizeField);

        inputPanel.add(new JLabel("Initial Calling Credit:"));
        creditField = new JTextField();
        inputPanel.add(creditField);

        inputPanel.add(new JLabel("Initial Available Memory:"));
        memoryField = new JTextField();
        inputPanel.add(memoryField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);

        inputPanel.add(new JLabel("Call Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Download Size:"));
        downloadSizeField = new JTextField();
        inputPanel.add(downloadSizeField);

        inputPanel.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        inputPanel.add(displayNumberField);

        centerPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Buttons"));

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make A Call");
        downloadMusicButton = new JButton("Download Music");

        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);

        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        displayArea = new JTextArea(12, 60);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Display Area"));

        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);

        setVisible(true);
    }

    private String getModel() {
        return modelField.getText().trim();
    }

    private double getPrice() {
        return Double.parseDouble(priceField.getText().trim());
    }

    private int getWeightValue() {
        return Integer.parseInt(weightField.getText().trim());
    }

    private String getSizeValue() {
        return sizeField.getText().trim();
    }

    private int getCredit() {
        return Integer.parseInt(creditField.getText().trim());
    }

    private int getMemory() {
        return Integer.parseInt(memoryField.getText().trim());
    }

    private String getPhoneNumber() {
        return phoneNumberField.getText().trim();
    }

    private int getDuration() {
        return Integer.parseInt(durationField.getText().trim());
    }

    private int getDownloadSize() {
        return Integer.parseInt(downloadSizeField.getText().trim());
    }

    private int getDisplayNumber() {
        int displayNumber = -1;

        try {
            displayNumber = Integer.parseInt(displayNumberField.getText().trim());

            if (displayNumber < 0 || displayNumber >= gadgetList.size()) {
                JOptionPane.showMessageDialog(this,
                    "Display number is out of range. Please enter a valid index number.");
                displayNumber = -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Invalid display number. Please enter a whole number.");
        }

        return displayNumber;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMobileButton) {
            addMobile();
        } else if (e.getSource() == addMP3Button) {
            addMP3();
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == displayAllButton) {
            displayAll();
        } else if (e.getSource() == makeCallButton) {
            makeCall();
        } else if (e.getSource() == downloadMusicButton) {
            downloadMusic();
        }
    }

    private void addMobile() {
        try {
            String model = getModel();
            double price = getPrice();
            int weight = getWeightValue();
            String size = getSizeValue();
            int credit = getCredit();

            if (model.equals("") || size.equals("")) {
                JOptionPane.showMessageDialog(this,
                    "Model and size fields cannot be empty.");
                return;
            }

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgetList.add(mobile);

            JOptionPane.showMessageDialog(this, "Mobile phone added successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Invalid input. Please enter correct numbers for price, weight and credit.");
        }
    }

    private void addMP3() {
        try {
            String model = getModel();
            double price = getPrice();
            int weight = getWeightValue();
            String size = getSizeValue();
            int memory = getMemory();

            if (model.equals("") || size.equals("")) {
                JOptionPane.showMessageDialog(this,
                    "Model and size fields cannot be empty.");
                return;
            }

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgetList.add(mp3);

            JOptionPane.showMessageDialog(this, "MP3 player added successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Invalid input. Please enter correct numbers for price, weight and memory.");
        }
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
        displayArea.setText("");
    }

    private void displayAll() {
        displayArea.setText("");

        if (gadgetList.size() == 0) {
            displayArea.setText("No gadgets have been added yet.");
        } else {
            for (int i = 0; i < gadgetList.size(); i++) {
                displayArea.append("Display Number: " + i + "\n");
                displayArea.append(gadgetList.get(i).toString() + "\n");
                displayArea.append("----------------------------------------\n");
            }
        }
    }

    private void makeCall() {
        int displayNumber = getDisplayNumber();

        if (displayNumber != -1) {
            try {
                Gadget gadget = gadgetList.get(displayNumber);
                Mobile mobile = (Mobile) gadget;

                String phoneNumber = getPhoneNumber();
                int duration = getDuration();

                if (phoneNumber.equals("")) {
                    JOptionPane.showMessageDialog(this,
                        "Please enter a phone number.");
                    return;
                }

                mobile.makeCall(phoneNumber, duration);

                JOptionPane.showMessageDialog(this, "Call process completed.");
                displayAll();
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this,
                    "The selected gadget is not a mobile phone.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                    "Invalid duration. Please enter a whole number.");
            }
        }
    }

    private void downloadMusic() {
        int displayNumber = getDisplayNumber();

        if (displayNumber != -1) {
            try {
                Gadget gadget = gadgetList.get(displayNumber);
                MP3 mp3 = (MP3) gadget;

                int downloadSize = getDownloadSize();

                if (downloadSize <= 0) {
                    JOptionPane.showMessageDialog(this,
                        "Download size must be a positive number.");
                    return;
                }

                mp3.downloadMusic(downloadSize);

                JOptionPane.showMessageDialog(this, "Download process completed.");
                displayAll();
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this,
                    "The selected gadget is not an MP3 player.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                    "Invalid download size. Please enter a whole number.");
            }
        }
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}
