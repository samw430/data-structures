import java.util.LinkedList;

public class Trie{

	boolean endOfWord;
	LinkedList<Trie> characters;
	char letter;

	public Trie(char let){
		endOfWord = false;
		characters = new LinkedList<Trie>();
		letter = let;
	}

	public void endOfWord(){
		endOfWord = true;
	}

	public boolean isEndOfWord(){
		return endOfWord;
	}

	public Trie getNode(char letter){
//		System.out.println(characters.contains(new Trie(letter)));
		for(int i=0;i<characters.size();i++){
			if(characters.get(i).letter == letter){
				return characters.get(i);
			}
		}
		return null;
	}

	public void addWord(String word){
		if(!word.equals("")){
			char first = word.charAt(0);
			if(this.getNode(first) == null){
				characters.add(new Trie(first));
			}
			this.getNode(first).addWord(word.substring(1));
		}else{
			this.endOfWord();
		}
	}

	public void printDict(String wordSoFar){
		wordSoFar = wordSoFar + letter;
		if(endOfWord){
			System.out.println(wordSoFar);
		}
		if(!characters.isEmpty()){
			for(int i=0;i<characters.size();i++){
				characters.get(i).printDict(wordSoFar);
			}
		}
	}

	public static void main(String[] args){
		Trie root = new Trie('\0');
		root.addWord("hello");
		root.addWord("hey");
		root.addWord("sup");
		root.addWord("supper");

		root.printDict("");
	}

}