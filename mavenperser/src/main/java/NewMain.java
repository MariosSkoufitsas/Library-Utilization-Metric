import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.symbolsolver.utils.SymbolSolverCollectionStrategy;
import com.github.javaparser.utils.ProjectRoot;
import com.github.javaparser.utils.SourceRoot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    static ArrayList<String> methodmain = new ArrayList<String>();
    static ArrayList<String> arm = new ArrayList<String>();
    static boolean bolmethee=true;
    static double mainmethod=0;
    
    
    //trexoume sth main kai mas epistrefei ta onomata
    private static class MethodVisitor extends VoidVisitorAdapter
    {

        //afairoume diplotupa apo array list autos o tropos mporei na alaxtei
       public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {

            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }}
    
    
    private static class MethodVisitor2 extends VoidVisitorAdapter<Void>{
        @Override
        public void visit(MethodCallExpr n, Void arg) {
            
        super.visit(n, arg);
        try{
            arm.add(n.resolve().getQualifiedName());
            System.out.println(n.resolve().getQualifiedName());
        }
        catch (Exception e) {
        e.printStackTrace();
        return;}
            
            
        }
    }
 
    public static String[] myBadGlobalArray = new String[10];
    
     //private static final String FILE_PATH = "C:\\Users\\mario\\Desktop\\mavenperser\\src\\main\\java\\NewClass.java";

        //statik metablites stous metrites gia methodous kai bibliothikes
         public  static int i=0,i2=0;
        //metrame to plithos toon methodon kai toon biblhothikon
   
        private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);
        
        if(!bolmethee && md.isPublic()){
            i++;
        }
        
            for(int i=0; i<arm.size(); i++){
                if(arm.get(i).equals(md.resolve().getQualifiedName())){
                    mainmethod=mainmethod+1;
                }
            
        }
        /*if(bolmethee){
            arm.add(md.resolve().getQualifiedName());
        }*/
        System.out.println("Method Name Printed: " + md.resolve().getQualifiedName());
        }          
 }
        //emafanizoume to plhthos ton methodon kai ton bibliothikon
        public static int count(){
            System.out.println("Number of methods: "+i);
            return i;
            
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
    //private static final String FILE_PATH3="C:\\Users\\mario\\Desktop\\testProject  C:\\Users\\mario\\Desktop\\JavaCodeMetricsCalculator-src_code_analyzer";
    private static final String FILE_PATH4="C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib\\sources";
    
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        
        
        Scanner myObj = new Scanner(System.in);
        String userName;
    
        String FILE_PATH3;
        System.out.println("Enter path project"); 
        FILE_PATH3 = myObj.nextLine();

        
        CombinedTypeSolver combinedTypeSolver2 = new CombinedTypeSolver();
        combinedTypeSolver2.add(new ReflectionTypeSolver());
        ParserConfiguration parserConfiguration2 = new ParserConfiguration().setSymbolResolver(new JavaSymbolSolver(combinedTypeSolver2));
        ProjectRoot projectRoot2 = new SymbolSolverCollectionStrategy(parserConfiguration2).collect(Path.of(FILE_PATH3+"\\src\\main"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (SourceRoot sourceRoot : projectRoot2.getSourceRoots()) {
    try {
        sourceRoot.tryToParse();
        List<CompilationUnit> compilationUnits = sourceRoot.getCompilationUnits();
        //System.out.println(compilationUnits);
        for(int x=0; x<compilationUnits.size();x++){
            VoidVisitor<Void> methodNameVisitor2 = new MethodVisitor2();
                methodNameVisitor2.visit(compilationUnits.get(x), null);
        }
    } catch (IOException e) {
        e.printStackTrace();
        return;}}
        bolmethee=false;
        
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
        }

        
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        //combinedTypeSolver.add(new JavaParserTypeSolver(new File("C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib\\sources")));
        combinedTypeSolver.add(new ReflectionTypeSolver());
        ParserConfiguration parserConfiguration = new ParserConfiguration().setSymbolResolver(new JavaSymbolSolver(combinedTypeSolver));
        ProjectRoot projectRoot = new SymbolSolverCollectionStrategy(parserConfiguration).collect(Path.of("C:\\Users\\mario\\Desktop\\mavenperser\\target\\lib\\sources"));
        
         
        for (SourceRoot sourceRoot : projectRoot.getSourceRoots()) {
    try {
        sourceRoot.tryToParse();
        List<CompilationUnit> compilationUnits = sourceRoot.getCompilationUnits();
        //System.out.println(compilationUnits);
        for(int x=0; x<compilationUnits.size();x++){
            
            VoidVisitor<Void> methodNameVisitor = new MethodNamePrinter();
                methodNameVisitor.visit(compilationUnits.get(x), null);
                
        }
    } catch (IOException e) {
        e.printStackTrace();
        return;
    }
   
        System.out.println("oi  methodoi pou brethikan "+mainmethod+" SYNOLIKES METHODOI ");
        int a=count();
        double b=(mainmethod/a)*100;
        System.out.println("Apotelesma "+b+" %");
        
    }
}}