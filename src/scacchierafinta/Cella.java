/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchierafinta;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author acer
 */
public class Cella extends StackPane {
    
    BackgroundFill redBg = new BackgroundFill(Color.RED,  CornerRadii.EMPTY, Insets.EMPTY);
    BackgroundFill blackBg = new BackgroundFill(Color.BLACK,  CornerRadii.EMPTY, Insets.EMPTY);
    BackgroundFill whiteBg = new BackgroundFill(Color.WHITE,  CornerRadii.EMPTY, Insets.EMPTY);
    
    static boolean select = false;
    Background prev_bg;
    
    public int n;
    
    Integer x,y;
    Scacchiera s;
    boolean hasPedina = false;
    
    Cella(Background bg, Integer x, Integer y, Scacchiera s) {
	this.setMinSize(50, 50);
	this.setBackground(bg);
	prev_bg = bg;
	this.x = x;
	this.y = y;
	this.s = s;
	
	addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
	    if (!this.hasPedina) {
		if (ScacchieraFinta.alfiereBtn.isDisabled())
		    setPedina(new Alfiere(x,y,s));
		else if (ScacchieraFinta.pedoneBtn.isDisabled())
		    setPedina(new Pedone(x,y,s));
		else if (ScacchieraFinta.torreBtn.isDisabled())
		    setPedina(new Torre(x,y,s));
	    }
	    this.hasPedina = true;
	});
    }
    
    public void setPedina(Pedina p) {
	if (this.getChildren().isEmpty()) {
	    this.getChildren().add(p);
	}
    }
    
    public void setRedBg() {
	this.setBackground(new Background(redBg));
    }
    
    public void setBackBg() {
	this.setBackground(prev_bg);
    }
}
