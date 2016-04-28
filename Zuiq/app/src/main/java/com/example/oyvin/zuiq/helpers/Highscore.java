package com.example.oyvin.zuiq.helpers;

import com.example.oyvin.zuiq.models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Highscore {

	private ArrayList<Player> players;
	

	public Highscore(ArrayList<Player> players){
	    	this.players = players;
	    	doSort();
	}
	
	private void doSort(){
		
		Collections.sort(players, new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				if (p1.getScore() > p2.getScore())
		            return -1;
		        if (p1.getScore() < p2.getScore())
		            return 1;
				return 0;
			}
		});
		
	}

	public String getHighscore(){
		String str = "";
		
		for (int r = 0; r < players.size(); r++) {
			str += players.get(r).getName() + " " + players.get(r).getScore() + " \n";
		}
		return str;
		
	}
}