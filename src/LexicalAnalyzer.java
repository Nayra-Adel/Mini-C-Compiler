package compilers_phase2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
	private String fileName;
	
	public LexicalAnalyzer(String fileName) {
		this.fileName = fileName;
		this.fileName = "C:\\Users\\Aya Essam\\Desktop\\Y4T2\\Compilers\\compilers_phase2-2\\input.txt";
	}
	
	public Queue<Token> analyze() throws IOException {
		
		List<Token> tokens = new ArrayList<Token>();
		List<RegularExpressions> regularExpressions = new ArrayList<RegularExpressions>();
		
		File file = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));


		regularExpressions.add(new RegularExpressions("MULTI_COMMENT", "/\\*.*\\*/"));
//		regularExpressions.add(new RegularExpressions("OPENCOMMENT", "/\\*"));
//		regularExpressions.add(new RegularExpressions("CLOSEDCOMMENT", "\\*/"));
		regularExpressions.add(new RegularExpressions("SINGLE_COMMENT", "//.*"));
		
		regularExpressions.add(new RegularExpressions("STRING_LITERAL", "\".*\""));

		
		regularExpressions.add(new RegularExpressions("ENUM", "\\benum\\b"));
		regularExpressions.add(new RegularExpressions("STRUCT", "\\bstruct\\b"));
		regularExpressions.add(new RegularExpressions("UNION", "\\bunion\\b"));
		regularExpressions.add(new RegularExpressions("VOID", "\\bvoid\\b"));
		regularExpressions.add(new RegularExpressions("NEW", "\\bnew\\b"));
		regularExpressions.add(new RegularExpressions("TYPEDEF", "\\btypedef\\b"));


		regularExpressions.add(new RegularExpressions("DO", "\\bdo\\b"));
		regularExpressions.add(new RegularExpressions("FOR", "\\bfor\\b"));
		regularExpressions.add(new RegularExpressions("WHILE", "\\bwhile\\b"));
		regularExpressions.add(new RegularExpressions("BREAK", "\\bbreak\\b"));
		regularExpressions.add(new RegularExpressions("CONTINUE", "\\bcontinue\\b"));

		regularExpressions.add(new RegularExpressions("IF", "\\bif\\b"));
		regularExpressions.add(new RegularExpressions("ELSE", "\\belse\\b"));
		regularExpressions.add(new RegularExpressions("GOTO", "\\bgoto\\b"));
		regularExpressions.add(new RegularExpressions("RETURN", "\\breturn\\b"));
		
		regularExpressions.add(new RegularExpressions("TRUE", "\\btrue\\b"));
		regularExpressions.add(new RegularExpressions("FALSE", "\\bfalse\\b"));
		
		regularExpressions.add(new RegularExpressions("STATIC", "\\bstatic\\b"));
		regularExpressions.add(new RegularExpressions("CONST", "\\bconst\\b"));

		
		regularExpressions.add(new RegularExpressions("SIGNED", "\\bsigned\\b"));
		regularExpressions.add(new RegularExpressions("UNSIGNED", "\\bunsigned\\b"));
		
		regularExpressions.add(new RegularExpressions("LONG", "\\blong\\b"));
		regularExpressions.add(new RegularExpressions("SHORT", "\\bshort\\b"));

		regularExpressions.add(new RegularExpressions("BOOL", "\\bbool\\b"));
		regularExpressions.add(new RegularExpressions("DOUBLE", "\\bdouble\\b"));
		regularExpressions.add(new RegularExpressions("INT", "\\bint\\b"));
		//regularExpressions.add(new RegularExpressions("STRING", "\\bstring\\b"));
		regularExpressions.add(new RegularExpressions("CHAR", "\\bchar\\b"));
		regularExpressions.add(new RegularExpressions("FLOAT", "\\bfloat\\b"));
		
		regularExpressions.add(new RegularExpressions("LESS_EQ", "=>"));
		regularExpressions.add(new RegularExpressions("GREAT_EQ", "=<"));
		regularExpressions.add(new RegularExpressions("EQUAL", "=="));
		regularExpressions.add(new RegularExpressions("NOT_EQUAL", "!="));

		regularExpressions.add(new RegularExpressions("NOT", "!"));

		
		regularExpressions.add(new RegularExpressions("AND", "&&"));
		regularExpressions.add(new RegularExpressions("OR", "\\|\\|"));

		regularExpressions.add(new RegularExpressions("BITWISE_AND", "&"));
		regularExpressions.add(new RegularExpressions("BITWISE_OR", "\\|"));
		
		regularExpressions.add(new RegularExpressions("LEFT_SHIFT", ">>"));
		regularExpressions.add(new RegularExpressions("RIGHT_SHIFT", "<<"));
		
		regularExpressions.add(new RegularExpressions("ASSIGN_OPERATOR", "="));
		regularExpressions.add(new RegularExpressions("MINUS", "-"));
		regularExpressions.add(new RegularExpressions("PLUS", "\\+"));
		regularExpressions.add(new RegularExpressions("ASTERICK", "\\*"));
		regularExpressions.add(new RegularExpressions("DIVIDE", "/"));
		regularExpressions.add(new RegularExpressions("MOD", "%"));
		regularExpressions.add(new RegularExpressions("SEMICOLON", ";"));
		regularExpressions.add(new RegularExpressions("LESSTHAN", ">"));
		regularExpressions.add(new RegularExpressions("GREATERTHAN", "<"));
		
		regularExpressions.add(new RegularExpressions("SIZEOF", "\\bsizeof\\b"));
		regularExpressions.add(new RegularExpressions("CHAR_LITERAL", "\'\\w\'"));
		regularExpressions.add(new RegularExpressions("FLOAT_LITERAL", "\\b(\\+|-)?\\d+\\.\\d+\\b"));
		regularExpressions.add(new RegularExpressions("INTEGRAL_LITERAL", "\\b\\d+\\b"));
		
		regularExpressions.add(new RegularExpressions("COMMA", ","));
		regularExpressions.add(new RegularExpressions("DOT", "\\."));
		regularExpressions.add(new RegularExpressions("PREPROCESSOR", "#"));
		regularExpressions.add(new RegularExpressions("BACKWARD_SLASH", "\\\\"));
		regularExpressions.add(new RegularExpressions("BITWISE_XOR", "\\^"));
		regularExpressions.add(new RegularExpressions("BITWISE_NOT", "~"));
	
		regularExpressions.add(new RegularExpressions("AUTO", "\\bauto\\b"));
		regularExpressions.add(new RegularExpressions("EOF", "\\b0\\b"));
		regularExpressions.add(new RegularExpressions("EXTERN", "\\bextern\\b"));
		regularExpressions.add(new RegularExpressions("REGISTER", "\\bregister\\b"));
		regularExpressions.add(new RegularExpressions("VOLATILE", "\\bvolatile\\b"));

		regularExpressions.add(new RegularExpressions("SWITCH", "\\bswitch\\b"));
		regularExpressions.add(new RegularExpressions("CASE", "\\bcase\\b"));
		regularExpressions.add(new RegularExpressions("DEFAULT", "\\bdefault\\b"));
		
		regularExpressions.add(new RegularExpressions("LEFT_CURLY_B", "\\{"));
		regularExpressions.add(new RegularExpressions("RIGHT_CURLY_B", "\\}"));
		regularExpressions.add(new RegularExpressions("LEFT_SQUARE_B", "\\["));
		regularExpressions.add(new RegularExpressions("RIGHT_SQUARE_B", "\\]"));
		regularExpressions.add(new RegularExpressions("LEFT_ROUND_B", "\\("));
		regularExpressions.add(new RegularExpressions("RIGHT_ROUND_B", "\\)"));
		
		regularExpressions.add(new RegularExpressions("ID", "\\b[a-zA-z_]+(\\$|\\w)*\\b"));
			
		
		
		String input, st, allFile = "";
		Pattern pattern;
		Matcher matcher;
		List<String> errors = new ArrayList<String>();
		List<Token> line_toknes = new ArrayList<Token>();
		
		while((input =  bufferedReader.readLine()) != null){
			allFile += input + "\n";
		}
			for (RegularExpressions regularExpression : regularExpressions){
				pattern = Pattern.compile(regularExpression.re, Pattern.DOTALL);
				matcher = pattern.matcher(allFile);

				while(matcher.find()){
					Token token = new Token(regularExpression.label, matcher.group(), matcher.start());
					line_toknes.add(token);
					
					st = String.format("%1$"+matcher.group().length()+ "s", "");
					
					allFile = allFile.substring(0,matcher.start()) + st + allFile.substring(matcher.end(),allFile.length());

				}
			}
			pattern = Pattern.compile("\\S");
			matcher = pattern.matcher(allFile);
			if(matcher.find()){
				errors.add(allFile);
			}
			
			Collections.sort(line_toknes);
			tokens.addAll(line_toknes);
			line_toknes = new ArrayList<Token>();
			Queue<Token> tokensQueue = new LinkedList<Token>();
		
		System.out.println("List Of errors:\n");
		for (String error : errors){
			System.out.println(error);
		}
		
		System.out.println("\nList Of Tokens:\n");
		for (Token token : tokens){
			System.out.print("<" + token.getType() + "> : ");
			System.out.println(token.getValue());
			tokensQueue.add(token);
		}
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Aya Essam\\Desktop\\Y4T2\\Compilers\\compilers_phase2-2\\output.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("List Of errors:\n");
		for (String error : errors){
			printWriter.println(error);
		}

		printWriter.println("\nList Of Tokens:\n");
		for (Token token : tokens){
			printWriter.println("<" + token.getType() + "> : ");
			printWriter.println(token.getValue());
		}
		printWriter.close();
		return tokensQueue;
	}
	
}
