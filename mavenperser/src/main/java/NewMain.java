import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
   
public class NewMain {
    
    //ArrayList<String> soursepath = new ArrayList<String>();
    static ArrayList<String> soursepath = new ArrayList<String>();
    
    
    //methodos pou mas epistrefei ola ta arxeia
    public static void listFilesForFolder(final File folder2) {
    
    for (final File fileEntry : folder2.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            
            if(test(fileEntry.getName(), ".java")){
                soursepath.add(fileEntry.getPath());
                System.out.println(fileEntry.getPath());
            }
            
        }
    }
}
    //krataei kai elegxei ta teleutea 4 psifia tou string kai kaleite sthn proigoumenh methodo
    public static boolean test(String a, String b) {
    if (a.length() > 5) {
        a = a.substring(a.length() - 5);
        if (b.length() > 4) {
            b = b.substring(b.length() - 5);
        }
    }
    return a.equals(b);
}
    
    
    public static String[] myBadGlobalArray = new String[10];
    
     //private static final String FILE_PATH = "C:\\Users\\mario\\Desktop\\mavenperser\\src\\main\\java\\NewClass.java";
    public static void Nul(NodeList<ImportDeclaration> a){
        a.size();
         int sum=0;
        String [] b=new String[a.size()];

        for (int k=0; k<a.size(); k++){
            b[k]=a.get(k).toString();
        }
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.size(); j++ ){
                
                if(a.get(i).equals(a.get(j))&& i!=j){
                    
                    
                    a.get(j).remove();
                    sum=sum+1;
                }
            }
        }
        System.out.println("Diplotupa "+sum+" Megeuos "+a.size());
    }
          
    
        //statik metablites stous metrites gia methodous kai bibliothikes
         public  static int i=0,i2=0;
        //metrame to plithos toon methodon kai toon biblhothikon
   
        private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);
        i++;
        System.out.println("Method Name Printed: " + md.getName()); 
        }
        @Override
        public void visit(ImportDeclaration md, Void arg) {
        super.visit(md, arg);
        i2++;
        System.out.println("Library Name Printed: " + md.getName());
        }            
 }
        //emafanizoume to plhthos ton methodon kai ton bibliothikon
    
        public static void count(){
            System.out.println("Number of methods: "+i);
            System.out.println("Number of libraries: "+i2);
        }
 
     

    
 
    //auth h methodos mas epistrefei apo to pom posa jar arxeia xrhshmopoioyme kai ta emfanizoyme
    public static void printPomDependencies() throws IOException, SAXException, ParserConfigurationException {
    // pom relative to your project directory
    final File pomFile = new File("./pom.xml");

    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
         org.w3c.dom.Document doc = dBuilder.parse(pomFile);
    doc.getDocumentElement().normalize();
    final org.w3c.dom.NodeList dependencyNodes = doc.getElementsByTagName("dependency");

    for (int i = 0; i < dependencyNodes.getLength(); i++) {
        final Node n = dependencyNodes.item(i);

        final org.w3c.dom.NodeList list = n.getChildNodes();

        System.out.println("----------------------------------");
        for (int j = 0; j < list.getLength(); j++) {
            final Node n2 = list.item(j);
            // do not print empty text nodes or others...
            if (n2.getNodeType() != Node.ELEMENT_NODE) continue;


            System.out.println(n2.getNodeName() + ":" + n2.getTextContent());

        }
    }
} 
    
    //einai methodos gia na trexoume cmd entoles
    public static void CMD(String cmd)
    {
        String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                        stdin.println(cmd);
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
    }
    
    
    //pairnei kai emafanizei ta jar apo ta dependences
    public static void printPomDependencies(String File_Path) throws IOException, SAXException, ParserConfigurationException {
    // pom relative to your project directory
    final File pomFile = new File(File_Path+"/pom.xml");

    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(pomFile);
    doc.getDocumentElement().normalize();
    final org.w3c.dom.NodeList dependencyNodes = doc.getElementsByTagName("dependency");

    for (int i = 0; i < dependencyNodes.getLength(); i++) 
    {
        final Node n = dependencyNodes.item(i);

        final org.w3c.dom.NodeList list = n.getChildNodes();
        System.out.println("----------------------------------");
        String name="";
        for (int j = 0; j < list.getLength(); j++) 
        {
            final Node n2 = list.item(j);
            // do not print empty text nodes or others...
            if (n2.getNodeType() != Node.ELEMENT_NODE) continue;
            if(j==3){
                name=n2.getTextContent();               

            }
            if(j==5){
               
                myBadGlobalArray[i]=name+"-"+n2.getTextContent()+".jar";
            }
        }
    }
} 
     
    //pairnoyme ta path pou theloume
    
    private static final String FILE_PATH = "C:\\Users\\mario\\Desktop\\πτυχιακη\\src\\main\\java\\calculator\\Main.java";
  
    private static final String FILE_PATH2="C:\\Users\\mario\\Desktop\\πτυχιακη\\src\\main\\java\\calculator\\Main.java";
    
    //private static final String FILE_PATH3="C:\\Users\\mario\\Desktop\\testProject";
    
    
    private static final String FILE_PATH4="C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib\\sources";
    
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        
        
        Scanner myObj = new Scanner(System.in);
        String userName;
    
        String FILE_PATH3;
        System.out.println("Enter path project"); 
        FILE_PATH3 = myObj.nextLine();
        
        
        /*CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
        System.out.println(cu);
         //VoidVisitor<Void> methodNameVisitor = new MethodNamePrinter();
        // methodNameVisitor.visit(cu, null);
         //count();
         
         NodeList<ImportDeclaration> a=cu.getImports();
         printPomDependencies();
         
         try {

StringBuffer output = new StringBuffer();

Scanner s = new Scanner(System.in);

System.out.println("cd C:\\Users\\mario\\Desktop\\mavenperser");

String command = s.next();

Runtime rt = Runtime.getRuntime();

Process pr = rt.exec(command);

BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));

String line = "";

while ((line = reader.readLine()) != null) {

output.append(line + "\n");

}

System.out.println("Command Output: " + output);

s.close();

} catch (IOException e) {

e.printStackTrace();

}*/
        
                // TODO code application logic here
        /*CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH3));
        CompilationUnit cu1 = StaticJavaParser.parse(new File(FILE_PATH3));
        NodeList<ImportDeclaration> a = cu1.getImports();*/
     
        //Nul(a);
        
        printPomDependencies(FILE_PATH3);
 
        String CWD = System.getProperty("user.dir");
        
        String cmd_Command="cd " + FILE_PATH3 +" & mvn dependency:copy-dependencies -DexcludeTransitive -DoutputDirectory="+CWD+"\\target\\lib";
        
        CMD(cmd_Command);
        
        String cmd2 ="dir /a:-d /s /b "+CWD + "\\target\\lib"+" | find /c \":\" ";
        
        CMD(cmd2);
        
        String cd_Command="cd " + FILE_PATH3+"& mvn dependency:copy-dependencies -Dclassifier=sources  -DexcludeTransitive -DoutputDirectory="+CWD+"\\target\\lib\\sources";
        
        CMD(cd_Command);
        
        File folder = new File("C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib\\sources");
        
        File[] listOfFiles = folder.listFiles();
        
        
        for (int i = 0; i < listOfFiles.length; i++) {
            String cmd3="cd "+FILE_PATH4 +" & jar xf "+listOfFiles[i].getName();;
            CMD(cmd3);
            //
                
        }
        
        
        final File folder2 = new File("C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib\\sources");
        listFilesForFolder(folder2);
        
        System.out.println(soursepath.size()+"******************************************************************");
        
        //System.out.println(soursepath.get(0);
        for (int i=0; i<soursepath.size();i++)
        {
            System.out.println(soursepath.get(i));
            //MAVEN PAIRNOUME OLO TON KODIKA
            CompilationUnit cu = StaticJavaParser.parse(new File(soursepath.get(i)));
            //System.out.println(cu);
            VoidVisitor<Void> methodNameVisitor = new MethodNamePrinter();
            methodNameVisitor.visit(cu, null);
            
        }
        count();
        
        
        
        //String cmd3="";
        //String aaaaaaaaa = CMD(cmd2);
        


         /* for (File file : new java.io.File("C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib").listFiles()) 
            if (!file.isDirectory()) 
            file.delete();
            System.out.println("File " + listOfFiles[i].getName());
        */
         
         
         /*File folder = new File("C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib");
         File[] listOfFiles = folder.listFiles();*/
         
         
        /* for(int k=0; k<10; k++){
             System.out.println("pinakas edw  "+myBadGlobalArray[k]);
         }

         boolean ful;
         for (int i = 0; i < listOfFiles.length; i++) {
             ful=false;
            for(int j=0; j<4; j++){
                if(myBadGlobalArray[j].equals(listOfFiles[i].getName())){
                    System.out.println("brhka onomaaaaaaaaaaaaaaaaaaaaaa xaxa");
                    ful=true;
                }
                
        }
            
        if (ful==false) {
            System.out.println("mphkeeeeeeeeeeee "+i);
                    listOfFiles[i].delete();
                }*/
         
        /*for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println(listOfFiles[i].getName()+"big-math-1.0-beta2.jar");
        if (!"big-math-1.0-beta2.jar".equals(listOfFiles[i].getName()) ) {
             listOfFiles[i].delete();
        }*/
}
         
         
         //Nul(a);
    
    }
    

