/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchierafinta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class Alfiere extends Pedina{
    static int i = 0;
    static Character c = 'A';

    public Alfiere(Integer x, Integer y, Scacchiera s) {
	super(c, i, x, y, s);
	i++;
    }
    
    @Override
    List<Cella> getMosse(Integer x, Integer y, Scacchiera s) {
	List<Cella> ret = new ArrayList();
	for (int j = 0; j < s.n; j++) {
	    if ((x+j < s.n) && (y+j < s.n)) {
		ret.add((Cella) s.standardGetNode(x+j,y+j));
	    }
	    if ((x-j >= 0) && (y+j < s.n)) {
		ret.add((Cella) s.standardGetNode(x-j,y+j));
	    }
	    if ((x+j < s.n) && (y-j >= 0)) {
		ret.add((Cella) s.standardGetNode(x+j,y-j));
	    }
	    if ((x-j >= 0) && (y-j >= 0)) {
		ret.add((Cella) s.standardGetNode(x-j,y-j));
	    }
	}
	return ret;
    }
    
}
