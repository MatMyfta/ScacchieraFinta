/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchierafinta;

import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author acer
 */
public class Scacchiera extends GridPane{
    public Integer n;
	
    Scacchiera(Integer n) {
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		BackgroundFill background_fill = new BackgroundFill((i+j)%2 == 0 ? Color.BLACK : Color.WHITE,  CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(background_fill);
		Cella cell = new Cella(bg, i, j, this);
		this.add(cell,i,j);
	    }
	}
	this.setAlignment(Pos.CENTER);
	this.n = n;
    }
    
    public void reset() {
	for (Node x : this.getChildren()) {
	    ((Cella)x).getChildren().clear();
	}
    }
    
    Node standardGetNode(int x, int y) {
	for (Node i : this.getChildren()) {
	    if (((GridPane.getColumnIndex(i)) == x) && ((GridPane.getRowIndex(i)) == y)) {
		return i;
	    }
	}
	return null;
    }
    
    public void cambiaColoreEntrata(List<Cella> l) {
	for(Cella c : l) {
	    c.setRedBg();
	}
    }
    
    public void cambiaColoreUscita(List<Cella> l) {
	for(Cella c : l) {
	    c.setBackBg();
	}
    }
    
}
