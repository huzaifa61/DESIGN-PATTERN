import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ques {

    public static  int findd(Set<String> dictionary, String start, String end){
        if(!dictionary.contains(end)){ return 0; }
        Queue<String> q = new LinkedList<String>();
        int level =0;

        Set<String> visited = new HashSet<>();

        q.offer(start);
        while(!q.isEmpty()){
            int size = q.size();
            String curr = q.poll();
            for(int i=0; i<curr.length(); i++){
                // T, O , O, N
                char ch[] = curr.toCharArray();
                for(char c='A'; c<= 'Z'; c++){
                    if(ch[i]==c){continue;}
                    ch[i]=c;
                    String newWord = new String(ch);
                    //if(newWord.equals(end)){ level++;}
                  //  System.out.println(newWord);

                    //   level++;
                       if(newWord.equals(end)){ return  level+1; }
                       // q.offer(newWord);
                        if(dictionary.contains(newWord) && !visited.contains(newWord)){
                            level++;
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                }
            }


        }

        return level;
    }

    public static void main(String[] args) {

       Set<String> Dictionary = new HashSet<>(){};
        Dictionary.add("POON");
        Dictionary.add("PLEA");
        Dictionary.add("SAME");
        Dictionary.add("POIE");
        Dictionary.add("PLEA");
        Dictionary.add("PLIE");
        Dictionary.add("POIN");

        String start = "TOON";
        String end = "PLEA";

        System.out.println(findd(Dictionary,start,end));


    }


}
//Given a dictionary, and two words start and target (both of the same length). Find length of the smallest chain from start
//to target if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a
//valid word i.e., it exists in the dictionary. It may be assumed that the target word exists in the dictionary and the lengths
//of all the dictionary words are equal.
//
//
//
//Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
//start = “TOON”
//target = “PLEA”
//Output: 7
//TOON -> POON –> POIN –> POIE –> PLIE –> PLEE –> PLEA


// "TOON"
//  q -> TOON
//