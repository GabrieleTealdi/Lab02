package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	public Word() {
		
	}
	
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	@Override
	public boolean equals(Object obj) {
		Word w = new Word();
		if(obj instanceof Word)
			w = (Word)obj;
		if(this.alienWord.compareTo(w.getAlienWord())==0)
			return true;
		return false;
		
	}
	
	
	
	
}
