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
public class Pedone extends Pedina{
    static int i = 0;
    static Character c = 'P';

    public Pedone(Integer x, Integer y, Scacchiera s) {
	super(c, i, x, y, s);
	i++;
    }
    
    @Override
    List<Cella> getMosse(Integer x, Integer y, Scacchiera s) {
	List<Cella> ret = new ArrayList();
	ret.add((Cella) s.standardGetNode(x,y));
	if(y-1 > 0)
	    ret.add((Cella) s.standardGetNode(x, y-1));
	return ret;
    }
    
}
