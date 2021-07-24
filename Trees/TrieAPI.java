import java.util.*;

public class TrieAPI {

static class TrieNode{
    int count = 0;
    TrieNode[] trieNode = new TrieNode[26];
}


static class Trie{
    TrieNode contacts = new TrieNode();
    
    public void add(String contact){
        
        TrieNode temp = contacts;
        temp.count++;
        
        for(char c : contact.toCharArray()){
            
            int index = c - 'a';
            if(temp.trieNode[index] != null){
                temp = temp.trieNode[index];
            }
            else{
                temp.trieNode[index] = new TrieNode();
                temp = temp.trieNode[index];
            }
            temp.count++; 
        }
        
    }
    
    public int find(String contact){
        
        TrieNode temp = contacts;
        
        for(char c : contact.toCharArray()){
            int index = c -'a';
            if(temp.trieNode[index]!=null){
                temp = temp.trieNode[index];
            }
            else{
                return 0;
            }
            
        }
        return temp.count;
    }
}



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Trie trie = new Trie();
        System.out.println("commands : \n 1)add <word> \n 2)find <word> \n 3) exit \n Enter commands:");
        while (true) {
            String[] command = in.nextLine().split(" ");    
            if(command[0].equals("add")){
                trie.add(command[1]);
            }
            if(command[0].equals("find")){
                System.out.println(trie.find(command[1]));
            }
            if (command[0].equals("exit")) {
                break;
            }
        }
    }
}
