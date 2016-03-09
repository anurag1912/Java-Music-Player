    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/*

Program to compute the total number of sound files on secondary storage.
Using a non-recursive depth-first search to count *ALL* possible .mp3 and .wav files!
*/
    package m_player;

    /**
     *
     * @author Admin
     */
    import java.io.File;
    import java.io.FileWriter;
    import java.io.BufferedWriter;
    import java.util.Stack;
    import java.util.ArrayList;
    import java.lang.Exception;
    public class M_Player {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
         Stack s = new Stack();
         long count=0;
         ArrayList<String> aList = new ArrayList();
         File obj;
        File [] f = File.listRoots();
         
        for(File i: f)
            s.push(i.getAbsolutePath());
        
         //File f = new File("D:\\Anurag\\Downloads");
         //System.out.println(f.list().length);
         //s.push(f.getAbsolutePath());
         //System.out.println((String)s.peek());
        
        
        
        //Depth first search, non-recursive!
        
        
        
        while(!s.empty()) {
            
        String str = (String)s.peek();
        obj = new File(str);
        if(obj.exists())
        {
           
         s.pop();
         
        
        String fils[] = obj.list();
        
        if(fils!=null){
        for(int  i=0;i<fils.length;i++) {
           
        File temp = new File(obj.getAbsolutePath() + "/" + fils[i]); 
         
         if(temp.isDirectory())
         s.push(temp.getAbsolutePath());
         else if(temp.isFile())
         {  if(temp.getName().endsWith(".mp3") || temp.getName().endsWith(".wav"))
         {count++;
         aList.add(temp.getAbsolutePath());
         }
         }
            }
        }   
        
         
        }
        else
        s.pop();
        }
        System.out.println("Number of sound files on secondary storage = " + count);
        
        try{
        FileWriter toprint = new FileWriter("songs.txt");
        BufferedWriter fd = new BufferedWriter(toprint);
        for(String i : aList)
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


