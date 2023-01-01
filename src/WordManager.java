import java.util.ArrayList;
public class WordManager {
    private ArrayList<String> words = new ArrayList();
    private ArrayList<String> usedWords = new ArrayList();
    
    public WordManager() {
        words.add("happy");
    
    }
    
    public WordManager(String filename) {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "/" + filename;
        
        words = FileReaderPlus.readFile(filePath, true);
    }
    
    public void loadWords() {
       
    }
    public String getWord() {
        if (words.size() > 0) {
            int random = (int)(Math.random()*words.size());
            String word = words.get(random);
            usedWords.add(word);
            words.remove(random);
            return word;
        } else {
            reset();
            int random = (int)(Math.random()*words.size());
            String word = words.get(random);
            usedWords.add(word);
            words.remove(random);
            return word;
            
        }
        
    }
    public void reset() {
        for (int i = 0; i < usedWords.size(); i++) {
            words.add(usedWords.get(i));
            usedWords.remove(i);
            
        }
    }
}
