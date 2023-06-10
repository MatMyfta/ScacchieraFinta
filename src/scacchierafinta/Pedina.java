/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchierafinta;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author acer
 */
public abstract class Pedina extends StackPane{
    Integer x,y;
    Shape cerchio = new Circle(20);
    Label lPedina = new Label();
    Scacchiera scacchiera;
    
    Pedina(Character c, Integer n, Integer x, Integer y, Scacchiera s) {
	this.lPedina.setText(c + n.toString());
	this.cerchio.setFill(Color.YELLOW);
	this.getChildren().addAll(cerchio,lPedina);
	this.lPedina.setAlignment(Pos.CENTER);
	this.setAlignment(Pos.CENTER);
	this.x = x;
	this.y = y;
	this.scacchiera = s;
	
	addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent event) -> {
	    if (!this.getChildren().isEmpty()) {
		s.cambiaColoreEntrata(this.getMosse(x, y, s));
	    }
	});
	addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent event) -> {
	    if (!this.getChildren().isEmpty()) {
		s.cambiaColoreUscita(this.getMosse(x, y, s));
	    }
	});
    }
    
    abstract List<Cella> getMosse(Integer x, Integer y, Scacchiera s);
}
