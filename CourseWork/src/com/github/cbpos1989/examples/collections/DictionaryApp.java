/**
 * 
 */
package com.github.cbpos1989.examples.collections;

/**
 * @author User1
 *
 */
public class DictionaryApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> dictionary

	}

}

class Word {
	private String word;
	private String definition;
	
	public Word(){
		this("unknown","unknown");
	}
	
	public Word(String word, String definition){
		setWord(word);
		setDefinition(definition);
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		
		if(o instanceof Word){
			if(this.word.equals(((Word)o).getWord())){
				return true;
			}
		}
		return false;
	}
}
