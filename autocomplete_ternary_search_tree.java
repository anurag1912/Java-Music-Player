package autocomplete;
import java.io.*;

class Node{
public Node parent=null;
public Node left = null;
public Node right=null;
public Node equal=null;
public char c='\0';
public String s=null;

}

class TST{
private Node root;   
 public TST(){
    root = new Node();
    root.c='\0';
    root.left = null;
    root.right = null;
    root.parent = null;
    root.equal=null;
    root.s=null;
}
 public void print()
 {//System.out.println("In root\n");
 print(root);
 }
 public void print(Node temp){
  if(temp!=null) {
      //System.out.print(temp.c);
      if(temp.s!=null)
          System.out.println(temp.s);
      print(temp.equal);
      print(temp.left);
      print(temp.right);
  }
  
      
 }
 public void autocomplete(String s){
     Node temp = root;
     Node temp1 = temp;
     int i=0;
     while(temp!=null && i<s.length()) {
         
         if(temp.c==s.charAt(i))
         { i++;
         temp1 = temp;
         temp = temp.equal;
         }
         else if(s.charAt(i)<temp.c)
         {
             temp1=temp;
             temp= temp.left;
         }
         else{
             
             temp1=temp;
             temp= temp.right;
         }
     }
         
     if((temp==null && i==s.length()) || i==s.length()) {
             
         if(temp1.s==s)
             System.out.println(temp1.s);
         else
         {
             search(temp1.equal);
         }
         
     }
     else
         System.out.println("No matching strings found for prefx");
 }
 public void search(Node temp){
     
     if(temp!=null){
         
     if(temp.s!=null)
         System.out.println(temp.s);
     search(temp.equal);
     search(temp.left);
     search(temp.right);
         
     }
 }
public void insert(String ch){
    Node temp = root;
    int i=0;
           if(temp.c=='\0')
           {
               while(i<ch.length())
               {
                   temp.c=ch.charAt(i);
                   if(i!=ch.length()-1){
                   temp.equal = new Node();
                   temp.equal.parent = temp;
                   temp = temp.equal;
                   }
                   i++;
               }
           temp.s=ch;
           }
       
           else{
               
               while(i<ch.length())
               {
                   if(temp.c==ch.charAt(i))
                   {
                       i++;
                       if(temp.equal==null)
                       {
                           
                           while(i<ch.length()){
                           temp.equal = new Node();
                           temp.equal.c = ch.charAt(i);
                           temp.equal.parent=temp;
                           if(i!=ch.length()-1)
                           temp = temp.equal;
                           i++;
                           }
                           temp.s = ch;
                       }
                       else
                       temp = temp.equal;
                   }
                   else if(ch.charAt(i)<temp.c){
                      if(temp.left==null) {
                          temp.left = new Node();
                          temp.left.parent = temp;
                          temp.left.c=ch.charAt(i);
                          i++;
                          temp = temp.left;
                          while(i<ch.length()){
                              temp.equal = new Node();
                              temp.equal.c = ch.charAt(i);
                              temp.equal.parent = temp;
                              if(i!=ch.length()-1);
                              temp=temp.equal;
                              i++;
                          }
                      temp.s = ch;
                      } 
                      else 
                          temp = temp.left;
                       
                   }
                   else {
                       if(temp.right == null) {
                           temp.right = new Node();
                          temp.right.parent = temp;
                          temp.right.c=ch.charAt(i);
                          i++;
                          temp = temp.right;
                          while(i<ch.length()){
                              temp.equal = new Node();
                              temp.equal.c = ch.charAt(i);
                              temp.equal.parent = temp;
                              if(i!=ch.length()-1);
                              temp=temp.equal;
                              i++;
                          }
                      temp.s = ch;
                       }
                       else {
                           temp = temp.right;
                       }
                           
                   }
               }
               
               
               
           }
           
        }
       
    
 
}
    

public class Autocomplete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     //   System.out.println("qwefr\n");
        TST t = new TST();
        String s[] = {"ABCD", "ABBA", "BCD"};
        
        for(String a:s)
        {t.insert(a);
       // System.out.println(a);
        }
        t.autocomplete("ABBA");
        
        
        
    }
    
}
