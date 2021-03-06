/*
Program to write the full path of *ALL* sound files (.mp3/.wav) to a .txt file on secondary storage. Multi-threaded version.

*/

/**
 *
 * @author Anurag
 */
 
 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Stack;
import java.io.File;
import java.lang.Enum.*;
import java.util.ArrayList;
    class DataStructStack {
        public ArrayList<String> aList;
        private Stack s;
        private long count;
        public byte exit;
        public DataStructStack(){
            exit=0;
            count =0;
            s = new Stack();
            aList = new ArrayList();
        }
        public synchronized void addToList(String path){
            aList.add(path);
            
        }
        public synchronized void push(String path) {
            
            s.push(path);
            notifyAll();
            
        }
        
        public synchronized void increment(){
            count++;
        }
        public synchronized String peek(){
           if(!s.empty()){
            String path=(String)s.peek();
            s.pop();
            return path;
           }
           return "";
        }
        public synchronized boolean isEmpty(){
                while(s.isEmpty())
                {
                    try{
                        wait();
                    }
                    
                    
                    catch(InterruptedException e){
                        if(exit==1)
                            return true;
                        }
                }
                return false;
        }
        public synchronized long showCount(){
        return count;
    }
    }



    class Execute implements Runnable{
        
        private DataStructStack d; 
        
        Execute(DataStructStack d){
            this.d = d;
        }
        
        public void run(){
            File obj;
        while(!d.isEmpty())
        {   
        String str = (String)d.peek();
        if(str!="")
        {obj = new File(str);
        
        if(obj.exists())
        {
           
         
         
        
        String fils[] = obj.list();
        
        if(fils!=null){
        for(int  i=0;i<fils.length;i++) {
           
        File temp = new File(obj.getAbsolutePath() + "/" + fils[i]); 
         
         if(temp.isDirectory())
         d.push(temp.getAbsolutePath());
         else if(temp.isFile())
         {if(temp.getName().endsWith(".mp3") || temp.getName().endsWith(".wav"))
         {d.increment();
         d.addToList(temp.getAbsolutePath());
         }
         }
            }
        }   
        
         
        }
        
        }
        }
                
        }
          
        }
        
        
        
        
        
    


public class test {

    /**
     * @param args the command line arguments
     */

    
    
    public static void main(String[] args) {
     DataStructStack d = new DataStructStack();                 
     File [] f = File.listRoots();
         
        

     Thread t1 = new Thread(new Execute(d));
     
     Thread t2 = new Thread(new Execute(d));
     Thread t3 = new Thread(new Execute(d));
     t1.start();
     t2.start();
     t3.start();
     for(File i: f)
            d.push(i.getAbsolutePath());
     do
     {
         
     }while(t1.getState()!=Thread.State.WAITING || t2.getState()!=Thread.State.WAITING || t3.getState()!=Thread.State.WAITING);
     d.exit=1;
     t1.interrupt();
     t2.interrupt();
     t3.interrupt();
     System.out.println("Number of sound files on secondary storage = " + d.showCount());
     
     try{
        FileWriter toprint = new FileWriter("songs-multithreaded-version.txt");
        BufferedWriter fd = new BufferedWriter(toprint);
        for(String i : d.aList)
        {fd.write(i);
        fd.newLine();
        }
        fd.close();
        }
        
        catch(Exception e){
            System.out.println("Error!!\n");
            e.printStackTrace();
        }
        
   
    }
    
}
