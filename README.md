# GadgetShop System

## Student Details

Name: Md Mirazul Islam Rahat  
Student ID: 221LM2590025  
Module: CS4001 / CC4001 Programming  
Component: 001  

## Project Description

This repository contains my CS4001 / CC4001 Programming coursework project. The project is a Java-based GadgetShop system that stores details of gadgets in a shop using a graphical user interface.

The program uses object-oriented programming concepts such as inheritance, subclasses, method overriding, constructors, accessor methods, input validation and an ArrayList.

## Classes Included

The project contains four Java classes:

1. Gadget.java  
2. Mobile.java  
3. MP3.java  
4. GadgetShop.java  

## Class Summary

Gadget is the superclass. It stores common details of all gadgets, including model, price, weight and size.

Mobile is a subclass of Gadget. It stores calling credit and includes methods for adding credit and making a phone call.

MP3 is a subclass of Gadget. It stores available memory and includes methods for downloading and deleting music.

GadgetShop is the GUI class. It stores gadgets in an ArrayList and allows the user to add mobiles, add MP3 players, clear fields, display all gadgets, make a phone call and download music.

## Main Features

- Add a mobile phone
- Add an MP3 player
- Clear all input fields
- Display all gadgets
- Make a phone call
- Download music to an MP3 player
- Input validation using try/catch
- Dialog boxes for error messages
- ArrayList used to store Gadget objects

## How to Compile and Run

Open Command Prompt in the folder containing the Java files.

To compile the program, type:

```bash
javac *.java
