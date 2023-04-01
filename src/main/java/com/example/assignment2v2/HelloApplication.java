package com.example.assignment2v2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HelloApplication extends Application {

    // Casey Hsu 101376814
    // Lukas Canji 101329428

    public static String[][] readFile() throws IOException {
        // Reading Test Questions
        FileReader fileReader = new FileReader("exams.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Storing inside an Array List
        ArrayList<String[]> lines = new ArrayList<>();

        // Assigning a variable to each line read and checking for null
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {

            // Adding to ArrayList
            lines.add(line.split(","));
        }
        Collections.shuffle(lines);
        return lines.toArray(new String[lines.size()][]);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // 2D Array holding each line in second array index
        String[][] questionsList = readFile();

        // Components
        HBox nameBox = new HBox();
        Label candidateName = new Label("Enter Your Name:");
        TextField candidateNameField = new TextField();
        nameBox.getChildren().addAll(candidateName, candidateNameField);
        nameBox.setAlignment(Pos.CENTER);

        // Questions 1-5 and Options 25 Containers
        VBox questionBox1 = new VBox();
        Label examLabel = new Label("Questions:");
        VBox questionBox2 = new VBox();
        VBox questionBox3 = new VBox();
        VBox questionBox4 = new VBox();
        VBox questionBox5 = new VBox();

        // Choice Grouping 1-5
        ToggleGroup tGroupOne = new ToggleGroup();
        ToggleGroup tGroupTwo = new ToggleGroup();
        ToggleGroup tGroupThree = new ToggleGroup();
        ToggleGroup tGroupFour = new ToggleGroup();
        ToggleGroup tGroupFive = new ToggleGroup();


        // Questions 1-5
        Text question1 = new Text(questionsList[0][0]);
        Text question2 = new Text(questionsList[1][0]);
        Text question3 = new Text(questionsList[2][0]);
        Text question4 = new Text(questionsList[3][0]);
        Text question5 = new Text(questionsList[4][0]);

        // Choices One
        RadioButton choice1 = new RadioButton(questionsList[0][1]);
        RadioButton choice2 = new RadioButton(questionsList[0][2]);
        RadioButton choice3 = new RadioButton(questionsList[0][3]);
        RadioButton choice4 = new RadioButton(questionsList[0][4]);

        // Choices Two
        RadioButton choice5 = new RadioButton(questionsList[1][1]);
        RadioButton choice6 = new RadioButton(questionsList[1][2]);
        RadioButton choice7 = new RadioButton(questionsList[1][3]);
        RadioButton choice8 = new RadioButton(questionsList[1][4]);

        // Choices Three
        RadioButton choice9 = new RadioButton(questionsList[2][1]);
        RadioButton choice10 = new RadioButton(questionsList[2][2]);
        RadioButton choice11 = new RadioButton(questionsList[2][3]);
        RadioButton choice12 = new RadioButton(questionsList[2][4]);

        // Choices Four
        RadioButton choice13 = new RadioButton(questionsList[3][1]);
        RadioButton choice14 = new RadioButton(questionsList[3][2]);
        RadioButton choice15 = new RadioButton(questionsList[3][3]);
        RadioButton choice16 = new RadioButton(questionsList[3][4]);

        // Choices Five
        RadioButton choice17 = new RadioButton(questionsList[4][1]);
        RadioButton choice18 = new RadioButton(questionsList[4][2]);
        RadioButton choice19 = new RadioButton(questionsList[4][3]);
        RadioButton choice20 = new RadioButton(questionsList[4][4]);

        // Setting Group 1
        choice1.setToggleGroup(tGroupOne);
        choice2.setToggleGroup(tGroupOne);
        choice3.setToggleGroup(tGroupOne);
        choice4.setToggleGroup(tGroupOne);

        // Setting Group 2
        choice5.setToggleGroup(tGroupTwo);
        choice6.setToggleGroup(tGroupTwo);
        choice7.setToggleGroup(tGroupTwo);
        choice8.setToggleGroup(tGroupTwo);

        // Setting Group 3
        choice9.setToggleGroup(tGroupThree);
        choice10.setToggleGroup(tGroupThree);
        choice11.setToggleGroup(tGroupThree);
        choice12.setToggleGroup(tGroupThree);

        // Setting Group 4
        choice13.setToggleGroup(tGroupFour);
        choice14.setToggleGroup(tGroupFour);
        choice15.setToggleGroup(tGroupFour);
        choice16.setToggleGroup(tGroupFour);

        // Setting Group 5
        choice17.setToggleGroup(tGroupFive);
        choice18.setToggleGroup(tGroupFive);
        choice19.setToggleGroup(tGroupFive);
        choice20.setToggleGroup(tGroupFive);

        // Adding Questions to Containers
        questionBox1.getChildren().add(examLabel);
        questionBox1.getChildren().add(question1);
        questionBox2.getChildren().add(question2);
        questionBox3.getChildren().add(question3);
        questionBox4.getChildren().add(question4);
        questionBox5.getChildren().add(question5);

        // Adding Options to Containers
        questionBox1.getChildren().addAll(choice1,choice2,choice3,choice4);
        questionBox2.getChildren().addAll(choice5,choice6,choice7,choice8);
        questionBox3.getChildren().addAll(choice9,choice10,choice11,choice12);
        questionBox4.getChildren().addAll(choice13,choice14,choice15,choice16);
        questionBox5.getChildren().addAll(choice17,choice18,choice19,choice20);

        // Buttons
        Button submit = new Button("Submit");
        Button calculateGrade = new Button("Calculate Grade");

        // Results Output
        VBox resultBox = new VBox();
        Label resultLabel = new Label("Score Results: ");
        Text results = new Text();
        resultBox.getChildren().addAll(resultLabel, results);
        resultBox.setAlignment(Pos.CENTER);


        // Layout
        GridPane pane = new GridPane();

        // Window Layout
        pane.setAlignment(Pos.CENTER);

        // Node Layout
        pane.add(nameBox, 0, 0);
        pane.add(questionBox1, 0, 1);
        pane.add(questionBox2, 0, 2);
        pane.add(questionBox3, 0, 3);
        pane.add(questionBox4, 0, 4);
        pane.add(questionBox5, 0, 5);
        pane.add(submit, 0, 6);
        pane.add(calculateGrade, 1, 6);
        pane.add(resultBox, 0, 8);

        // Button Handling

        submit.setOnAction( submitEvent -> {
            try {
            String name = candidateNameField.getText();

            int score = 0;

            RadioButton radioButton1 = (RadioButton) tGroupOne.getSelectedToggle();
            RadioButton radioButton2 = (RadioButton) tGroupTwo.getSelectedToggle();
            RadioButton radioButton3 = (RadioButton) tGroupThree.getSelectedToggle();
            RadioButton radioButton4 = (RadioButton) tGroupFour.getSelectedToggle();
            RadioButton radioButton5 = (RadioButton) tGroupFive.getSelectedToggle();

            if(radioButton1 == null){
                radioButton1 = (RadioButton) tGroupOne.getUserData();
            }

            char value1 = radioButton1.getText().charAt(0);
            char value2 = radioButton2.getText().charAt(0);
            char value3 = radioButton3.getText().charAt(0);
            char value4 = radioButton4.getText().charAt(0);
            char value5 = radioButton5.getText().charAt(0);

            char answer1 = questionsList[0][5].charAt(0);
            char answer2 = questionsList[1][5].charAt(0);
            char answer3 = questionsList[2][5].charAt(0);
            char answer4 = questionsList[3][5].charAt(0);
            char answer5 = questionsList[4][5].charAt(0);

            if(answer1 == value1){
                score += 20;
            } else {
                score -= 5;
            }

            if(answer2 == value2){
                score += 20;
            } else {
                score -= 5;
            }

            if(answer3 == value3){

                score += 20;
            } else {
                score -= 5;
            }

            if(answer4 == value4){
                score += 20;
            } else {
                score -= 5;
            }

            if(answer5 == value5){
                score += 20;
            } else {
                score -= 5;
            }

            if(score < 0){
                score = 0;
            }

            results.setText("Thanks for playing " + name +
                    " your selections were: " + value1 + value2 + value3 + value4 + value5 +
                    " and your final Score was: " + score);



                FileWriter fileWriter = new FileWriter("results.txt",true);
                fileWriter.write(name + "," + value1 + "," + value2 + "," + value3 + ","
                        + value4 + "," + value5 + "," + score + "\n");
                fileWriter.close();

            } catch (Exception e) {

                System.out.println("Please enter all the fields to save results.");

            }

        });

        calculateGrade.setOnAction( calculateEvent -> {


            int score = 0;
            String name = candidateNameField.getText();

            if (tGroupOne.hasProperties()){
                System.out.println("hello = ");
            }

            RadioButton radioButton1 = (RadioButton) tGroupOne.getSelectedToggle();
            RadioButton radioButton2 = (RadioButton) tGroupTwo.getSelectedToggle();
            RadioButton radioButton3 = (RadioButton) tGroupThree.getSelectedToggle();
            RadioButton radioButton4 = (RadioButton) tGroupFour.getSelectedToggle();
            RadioButton radioButton5 = (RadioButton) tGroupFive.getSelectedToggle();

            char value1 = radioButton1.getText().charAt(0);
            char value2 = radioButton2.getText().charAt(0);
            char value3 = radioButton3.getText().charAt(0);
            char value4 = radioButton4.getText().charAt(0);
            char value5 = radioButton5.getText().charAt(0);

            char answer1 = questionsList[0][5].charAt(0);
            char answer2 = questionsList[1][5].charAt(0);
            char answer3 = questionsList[2][5].charAt(0);
            char answer4 = questionsList[3][5].charAt(0);
            char answer5 = questionsList[4][5].charAt(0);



            if(answer1 == value1){
                score += 20;
            } else {
                score -= 5;
            }

            if(answer2 == value2){
                score += 20;
            } else {
                score -= 5;
            }

            if(answer3 == value3){

                score += 20;
            } else {
                score -= 5;
            }

            if(answer4 == value4){
                score += 20;
            } else {
                score -= 5;
            }

            if(answer5 == value5){
                score += 20;
            } else {
                score -= 5;
            }

            if(score < 0){
                score = 0;

            }

            results.setText("Thanks for playing " + name +
                    " your selections were: " + value1 + value2 + value3 + value4 + value5 +
                    " and your final Score was: " + score);

        });

        // Adding Nodes to Scene Window
        Scene scene = new Scene(pane);

        // Initiating the scene
        stage.setScene(scene);
        stage.setHeight(650);
        stage.setWidth(700);
        stage.setResizable(false);
        stage.setTitle("Java Quiz");
        stage.show();
    }

    public static void main(String[] args) throws Exception {

        launch();
    }
}