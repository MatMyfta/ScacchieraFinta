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
public class Torre extends Pedina{
    static int i = 0;
    static Character c = 'T';

    public Torre(Integer x, Integer y, Scacchiera s) {
	super(c, i, x, y, s);
	i++;
    }
    
    @Override
    List<Cella> getMosse(Integer x, Integer y, Scacchiera s) {
	List<Cella> ret = new ArrayList();
	for(int j = 0; j < s.n; j++) {
	    ret.add((Cella) s.standardGetNode(j,y));
	    ret.add((Cella) s.standardGetNode(x,j));
	}
	return ret;
    }
    
}
