package it.polito.tdp.alien;
import java.util.*;

public class AlienDictionary {
	
	private List<Word> dizionario = new ArrayList<Word>();
	
	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation);
		dizionario.add(w);
	}

	public String translateWord(String alienWord) {
		String s = "";
		for(Word w: dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				s=w.getTranslation();
		}
		return s;
	}
	public boolean checkWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation);
		boolean b = false;
		for(Word p: dizionario) {
			if(w.equals(p))
				b = true;
		}
		return b;
	}

	public String findWord(String s1, String s2) {
		String s = "";
		for(Word w: dizionario) {
			if(w.getAlienWord().length() == (s1.length()+s2.length()+1)) {
				if(w.getAlienWord().indexOf(s1)!=-1 && w.getAlienWord().indexOf(s2)!=-1) {
					s += w.getTranslation() + "\n";
					}
			}
		}
		return s.trim();
	}
}
