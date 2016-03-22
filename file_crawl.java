    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/*

Program to compute the total number of files on secondary storage.
Using a non-recursive depth-first search to count *ALL* possible files!
*/
    package m_player;

    /**
     *
     * @author Admin
     */
    import java.io.File;
    import java.util.Stack;
    public class M_Player {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
         Stack s = new Stack();
         long count=0;
         File obj;
        File [] f = File.listRoots();
         
        for(File i: f)
            s.push(i.getAbsolutePath());
        
         //File f = new File("E:\\");
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
         {count++;
         
         }
            }
        }   
        
         
        }
        else
        s.pop();
        }
        System.out.println("Number of files on secondary storage = " + count);

        
        }
        

        }


