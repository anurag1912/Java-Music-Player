    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package m_player;

    /**
     *
     * @author Admin
     */
    import java.io.File;
    import java.io.FilenameFilter;
    import java.util.Stack;
    public class M_Player {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
         Stack s = new Stack();
         long files=0;
        File [] f = File.listRoots();
        for(File i: f)
            s.push(i.toString());

        String str = (String)s.peek();
        File obj = f[f.length-1];
        File fils[] = obj.listFiles(); 

        System.out.println(obj.toString());
        }
        /*for(int i=0;i<f.length;i++)
            System.out.println(f[i].toString());
          */  

        }


