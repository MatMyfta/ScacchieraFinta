/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchierafinta;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class ScacchieraFinta extends Application {
    
    static Button pedoneBtn = new Button("Pedone");
    static Button torreBtn = new Button("Torre");
    static Button alfiereBtn = new Button("Alfiere");
    
    static Integer n;
    
    @Override
    public void start(Stage primaryStage) {
	
	do {
	    TextInputDialog dialog = new TextInputDialog();
	    String s = dialog.showAndWait().get();
	    try {
		n = Integer.valueOf(s);
	    } catch (Exception e) {
		System.err.print(s + " - type error");
	    }
	} while(n<5 || n>9);
	
	Scacchiera scacchiera = new Scacchiera(n);
	
	Button resetBtn = new Button("Reset");
	
	Label selectedL = new Label("Selected = none");
	
	TilePane botBtn = new TilePane();
	botBtn.setAlignment(Pos.CENTER);
	botBtn.getChildren().addAll(resetBtn,pedoneBtn,torreBtn,alfiereBtn);
	
	HBox botHbox = new HBox();
	botHbox.getChildren().addAll(botBtn,selectedL);
	botHbox.setAlignment(Pos.CENTER);
	
	resetBtn.setOnAction((e) -> {
	    Pedone.i = 0;
	    Torre.i = 0;
	    Alfiere.i = 0;
	    scacchiera.reset();
	});
	pedoneBtn.setOnAction((e) -> {
	    pedoneBtn.setDisable(true);
	    torreBtn.setDisable(false);
	    alfiereBtn.setDisable(false);
	    selectedL.setText("Selected = Pedone");
	});
	torreBtn.setOnAction((e) -> {
	    pedoneBtn.setDisable(false);
	    torreBtn.setDisable(true);
	    alfiereBtn.setDisable(false);
	    selectedL.setText("Selected = Torre");
	});
	alfiereBtn.setOnAction((e) -> {
	    pedoneBtn.setDisable(false);
	    torreBtn.setDisable(false);
	    alfiereBtn.setDisable(true);
	    selectedL.setText("Selected = Alfiere");
	});
	
	BorderPane root = new BorderPane();
	root.setBottom(botHbox);
	root.setCenter(scacchiera);
	
	Scene scene = new Scene(root, 650, 600);
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }
    
}
