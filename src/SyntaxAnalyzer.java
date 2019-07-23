package compilers_phase2;

import java.io.IOException;
import java.text.CollationElementIterator;
import java.util.Queue;

public class SyntaxAnalyzer {
	Queue<Token> tokens;
	
	public SyntaxAnalyzer(String fileName) throws IOException{
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(fileName);
		this.tokens = lexicalAnalyzer.analyze();
	}
	
	public program parse(){
		return program();
	}
//	public start start(){
//		program program = program();
//		if(program != null){
//			return new start1(program);
//		}
//		stmt_list stmt_list = stmt_list();
//		if(stmt_list != null){
//			return new start2(stmt_list);
//		}
//		System.out.println("SYNTAX ERROR, start shouldn't be null");
//		return null;
//	}
	public program program(){
		decl_list decl_list = decl_list();
		
		if(decl_list == null){
			System.out.println("SYNTAX ERROR, decl list shouldn't be null");
			return null;
		}
		
		return new program(decl_list);
	}
	
	public decl_list decl_list(){
		decl_1 decl = decl();
		if(decl == null){
			System.out.println("SYNTAX ERROR, decl shouldn't be null");
			return null;
		}
		
		if(tokens.isEmpty())
			return new decl_list(decl, null);
		
		lr_decl_list lr_decl_list = lr_decl_list();
		
		return new decl_list(decl, lr_decl_list);
	}
	
	public lr_decl_list lr_decl_list(){
		decl_1 decl = decl();
		
		if(decl != null){
			lr_decl_list lr_decl_list = lr_decl_list();
			
			return new lr_decl_list(decl, lr_decl_list);
		}
		
		return null;
	}
	
	public decl_1 decl(){
//		var_decl var_decl = var_decl();
//
//		if(var_decl != null)
//			return new decl_1(var_decl);
//
//		fun_decl fun_decl = fun_decl();
//		if(fun_decl == null){
//			System.out.println("SYNTAX ERROR, fun_decl or var_decl shouldn't be null");
//			return null;
//		}
//		return new decl_2(fun_decl);
		type_spec type_spec = type_spec();
		if(type_spec == null){
			System.out.println("SYNTAX ERROR, type_spec shouldn't be null");
			return null;
		}

		if(tokens.isEmpty()) return null;

		Token token_1 = tokens.peek();
		if(!token_1.getType().equals("ID")){
			System.out.println("SYNTAX ERROR, identefier should exist");
			return null;
		}
		tokens.poll();
		lf_decl lf_decl = lf_decl();
		if(lf_decl == null){
			System.out.println("SYNTAX ERROR, lf_decl cannot be null");
			return null;
		}
		return new decl_1(type_spec, token_1, lf_decl);
	}
	
	public lf_decl lf_decl(){
		lf_var_decl lf_var_decl = lf_var_decl();
		if(lf_var_decl != null){
			return new lf_decl_1(lf_var_decl);
		}
		if(tokens.isEmpty()) return null;

		Token token_2 = tokens.peek();
		if(!token_2.getType().equals("LEFT_ROUND_B")){
			System.out.println("SYNTAX ERROR, left round bracket should exist");
			return null;
		}
		tokens.poll();

		params params = params();
		if(params == null){
			System.out.println("SYNTAX ERROR, params shouldn't be null");
			return null;
		}

		if(tokens.isEmpty()) return null;

		Token token_3 = tokens.peek();
		if(!token_3.getType().equals("RIGHT_ROUND_B")){
			System.out.println("SYNTAX ERROR, right round bracket should exist");
			return null;
		}
		tokens.poll();

		compound_stmt compound_stmt = compound_stmt();
		if(compound_stmt == null){
			System.out.println("SYNTAX ERROR, compound_stmt shouldn't be null");
			return null;
		}
		return new lf_decl_2(token_2, params, token_3, compound_stmt);
	}
	public var_decl var_decl(){
		type_spec type_spec = type_spec();
		if(type_spec == null){
			System.out.println("SYNTAX ERROR, type_spec shouldn't be null");
			return null;
		}
		
		if(tokens.isEmpty())
			return null;
		
		Token IDENT = tokens.peek();
		if(!IDENT.getType().equals("ID")){
			System.out.println("SYNTAX ERROR, ID should exist");
			return null;
		}
		tokens.poll();
		
		lf_var_decl lf_var_decl = lf_var_decl();
		if(lf_var_decl == null){
			System.out.println("SYNTAX ERROR, lf_var_decl shouldn't be null");
			return null;
		}
		
		return new var_decl(type_spec, IDENT, lf_var_decl);
	}
	
	public lf_var_decl lf_var_decl(){
		if(tokens.isEmpty())
			return null;
		
		Token semicolon = tokens.peek();
		if(semicolon.getType().equals("SEMICOLON")){
			tokens.poll();
			return new lf_var_decl_1(semicolon);
		}
		
		if(tokens.isEmpty())
			return null;
		
		Token open_sb = tokens.peek();
		if(!open_sb.getType().equals("LEFT_SQUARE_B")){
			System.out.println("SYNTAX ERROR, open squar bracket should exist");
			return null;
		}
		tokens.poll();
		
		if(tokens.isEmpty())
			return null;
		
		Token close_sb = tokens.peek();
		if(!open_sb.getType().equals("RIGHT_SQUARE_B")){
			System.out.println("SYNTAX ERROR, close square bracket should exist");
			return null;
		}
		tokens.poll();
		
		if(tokens.isEmpty())
			return null;
		
		semicolon = tokens.peek();
		if(!open_sb.getType().equals("SEMICOLON")){
			System.out.println("SYNTAX ERROR, semicolon should exist");
			return null;
		}
		tokens.poll();
		
		return new lf_var_decl_2(semicolon, close_sb, open_sb);
	}
	
	public type_spec type_spec(){
		if(tokens.isEmpty())
			return null;
		
		Token token = tokens.peek();

		if(token.getType().equals("VOID")){
			tokens.poll();
			return new type_spec_1(token);
		}
		else if(token.getType().equals("BOOL")){
			tokens.poll();
			return new type_spec_2(token);
		}
		else if(token.getType().equals("INT")){
			tokens.poll();
			return new type_spec_3(token);
		}
		else if(token.getType().equals("FLOAT")){
			tokens.poll();
			return new type_spec_4(token);
		}
		else{
			System.out.println("SYNTAX ERROR, type_spec should exist");
			return null;
		}
	}
	
	public fun_decl fun_decl() {

		type_spec type_spec = type_spec();
		if(type_spec == null){
			System.out.println("SYNTAX ERROR, type_spec shouldn't be null");
			return null;
		}
		
		if(tokens.isEmpty()) return null;
		
		Token token_1 = tokens.peek();
		if(!token_1.getType().equals("ID")){
			System.out.println("SYNTAX ERROR, identefier should exist");
			return null;
		}
		tokens.poll();
		
		if(tokens.isEmpty()) return null;
		
		Token token_2 = tokens.peek();
		if(!token_2.getType().equals("LEFT_ROUND_B")){
			System.out.println("SYNTAX ERROR, left round bracket should exist");
			return null;
		}
		tokens.poll();
		
		params params = params();
		if(params == null){
			System.out.println("SYNTAX ERROR, params shouldn't be null");
			return null;
		}
		
		if(tokens.isEmpty()) return null;
		
		Token token_3 = tokens.peek();
		if(!token_3.getType().equals("RIGHT_ROUND_B")){
			System.out.println("SYNTAX ERROR, right round bracket should exist");
			return null;
		}
		tokens.poll();
		
		compound_stmt compound_stmt = compound_stmt();
		if(compound_stmt == null){
			System.out.println("SYNTAX ERROR, compound_stmt shouldn't be null");
			return null;
		}
		
		return new fun_decl(type_spec, token_1, token_2, params, token_3, compound_stmt);
	}
	
	public params params(){
		param param = param();
		if(param != null){
			lr_param_list lr_param_list = lr_param_list();
			return new params_1(param, lr_param_list);
		}
		
		if(tokens.isEmpty()) return null;
		
		Token token = tokens.peek();
		if(!token.getType().equals("VOID")){
			System.out.println("SYNTAX ERROR, void should exist");
			return null;
		}
		tokens.poll();
		
		return new params_2(token);
	}
	
	public lr_param_list lr_param_list(){
		
		if(tokens.isEmpty()) return null;
		
		Token token = tokens.peek();
		if(token.getType().equals("COMMA")){
			tokens.poll();
			param param = param();
			if(param == null){
				System.out.println("SYNTAX ERROR, param shouldn't be null");
				return null;
			}
			lr_param_list lr_param_list = lr_param_list();
			
			return new lr_param_list(token, param, lr_param_list);
		}
		
		return null;
	}

	public param param(){
		type_spec type_spec = type_spec();
		if(type_spec == null){
			System.out.println("SYNTAX ERROR, type_spec shouldn't be null");
			return null;
		}
		if(tokens.isEmpty()) return null;
		Token token = tokens.peek();
		if(!token.getType().equals("ID")){
				System.out.println("SYNTAX ERROR, ID shouldn't be null");
				return null;
		}
		tokens.poll();
		lf_param lf_param = lf_param();
		return new param(type_spec, token, lf_param);

	}

	public lf_param lf_param(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(token1.getType().equals("LEFT_SQUARE_B")){
			tokens.poll();
			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("RIGHT_SQUARE_B")){
				System.out.println("SYNTAX ERROR, ] not found");
				return null;
			}
			tokens.poll();
			return new lf_param(token2, token1);
		}
		return null;
	}

	public stmt_list  stmt_list(){
		stmt stmt = stmt();
		if(stmt != null){
			stmt_list stmt_list = stmt_list();
			return new stmt_list(stmt, stmt_list);
		}
		return null;
	}

	public stmt stmt(){
		expr_stmt expr_stmt = expr_stmt();
		if(expr_stmt != null){
			return new stmt_1(expr_stmt);
		}
		compound_stmt compound_stmt = compound_stmt();
		if(compound_stmt != null){
			return new stmt_2(compound_stmt);
		}
		if_stmt if_stmt = if_stmt();
		if(if_stmt != null){
			return new stmt_3(if_stmt);
		}
		while_stmt while_stmt = while_stmt();
		if(while_stmt != null){
			return new stmt_4(while_stmt);
		}
		return_stmt return_stmt = return_stmt();
		if(return_stmt != null){
			return new stmt_5(return_stmt);
		}
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(token1.getType().equals("BREAK")){
			tokens.poll();
			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(token2.getType().equals("SEMICOLON")){
				tokens.poll();
				return new stmt_6(token1, token2);
			}
			System.out.println("SYNTAX ERROR, ; not found");
			return null;
		}

		System.out.println("SYNTAX ERROR, stmt shouldn't be null");
		return null;
	}

	public expr_stmt expr_stmt(){
		expr expr = expr();
		if(expr != null){
			if(tokens.isEmpty()) return null;
			Token token = tokens.peek();
			if(token.getType().equals("SEMICOLON")){
				tokens.poll();
				return new expr_stmt_1(expr, token);
			}
		}
		if(tokens.isEmpty()) return null;
		Token token = tokens.peek();
		if(token.getType().equals("SEMICOLON")){
			tokens.poll();
			return new expr_stmt_2(token);
		}
		System.out.println("SYNTAX ERROR, expr_stmt shouldn't be null");
		return null;
	}

	public while_stmt while_stmt(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(!token1.getType().equals("WHILE")){
			System.out.println("SYNTAX ERROR, while not found");
			return null;
		}
		tokens.poll();

		if(tokens.isEmpty()) return null;
		Token token2 = tokens.peek();
		if(!token2.getType().equals("LEFT_ROUND_B")){
			System.out.println("SYNTAX ERROR, ( not found");
			return null;
		}
		tokens.poll();
		expr expr = expr();
		if(expr ==  null){
			System.out.println("SYNTAX ERROR, expr cannot be null");
			return null;
		}
		if(tokens.isEmpty()) return null;
		Token token3 = tokens.peek();
		if(!token3.getType().equals("RIGHT_ROUND_B")){
			System.out.println("SYNTAX ERROR, ) not found");
			return null;
		}
		tokens.poll();

		stmt stmt = stmt();
		if(stmt ==  null){
			System.out.println("SYNTAX ERROR, stmt cannot be null");
			return null;
		}
		return new while_stmt(token1, token2, expr, token3, stmt);
	}

	public compound_stmt compound_stmt(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(!token1.getType().equals("LEFT_CURLY_B")){
			System.out.println("SYNTAX ERROR, { not found");
			return null;
		}
		tokens.poll();

		local_decls local_decls = local_decls();

		stmt_list stmt_list = stmt_list();

		if(tokens.isEmpty()) return null;
		Token token2 = tokens.peek();
		if(!token2.getType().equals("RIGHT_CURLY_B")){
			System.out.println("SYNTAX ERROR, } not found");
			return null;
		}
		tokens.poll();
		return new compound_stmt(token1, local_decls, stmt_list, token2);
	}

	public local_decls local_decls(){
		var_decl var_decl = var_decl();
		if(var_decl != null){
			local_decls local_decls = local_decls();
			return new local_decls(var_decl, local_decls);
		}
		return null;
	}

	public if_stmt if_stmt(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(!token1.getType().equals("IF")){
			System.out.println("SYNTAX ERROR, 'if' not found");
			return null;
		}
		tokens.poll();

		if(tokens.isEmpty()) return null;
		Token token2 = tokens.peek();
		if(!token2.getType().equals("LEFT_ROUND_B")){
			System.out.println("SYNTAX ERROR, ( not found");
			return null;
		}
		tokens.poll();
		expr expr = expr();
		if(expr ==  null){
			System.out.println("SYNTAX ERROR, expr cannot be null");
			return null;
		}
		if(tokens.isEmpty()) return null;
		Token token3 = tokens.peek();
		if(!token3.getType().equals("RIGHT_ROUND_B")){
			System.out.println("SYNTAX ERROR, ) not found");
			return null;
		}
		tokens.poll();

		stmt stmt = stmt();
		if(stmt == null){
			System.out.println("SYNTAX ERROR, stmt cannot be null");
			return null;
		}

		lf_if_stmt lf_if_stmt = lf_if_stmt();

		return new if_stmt(token1, token2, expr, token3, stmt, lf_if_stmt);
	}

	public lf_if_stmt lf_if_stmt(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(token1.getType().equals("ELSE")){
			tokens.poll();
			stmt stmt = stmt();
			if(stmt == null){
				System.out.println("SYNTAX ERROR, stmt cannot be null");
				return null;
			}
			return new lf_if_stmt(token1, stmt);
		}
		return null;
	}

	public return_stmt return_stmt(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(!token1.getType().equals("RETURN")){
			System.out.println("SYNTAX ERROR, 'return' not found");
			return null;
		}
		tokens.poll();
		lf_return_stmt lf_return_stmt = lf_return_stmt();
		if(lf_return_stmt == null){
			System.out.println("SYNTAX ERROR, lf_return_stmt cannot be null");
			return null;
		}
		return new return_stmt(token1, lf_return_stmt);
	}

	public lf_return_stmt lf_return_stmt(){
		expr expr = expr();
		if(expr != null){
			if(tokens.isEmpty()) return null;
			Token token1 = tokens.peek();
			if(!token1.getType().equals("SEMICOLON")){
				System.out.println("SYNTAX ERROR, ; not found");
				return null;
			}
			return new lf_return_stmt_2(expr, token1);
		}
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(!token1.getType().equals("SEMICOLON")){
			System.out.println("SYNTAX ERROR, ; not found");
			return null;
		}
		return new lf_return_stmt_1(token1);
	}

	public expr expr(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(token1.getType().equals("ID")){
			tokens.poll();
			lf_expr_IDENT lf_expr_ident = lf_expr_IDENT();
			lr_expr lr_expr = lr_expr();
			return new expr_1(token1, lf_expr_ident, lr_expr);
		}
		if(token1.getType().equals("NOT")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			lr_expr lr_expr = lr_expr();
			return new expr_2(token1, expr, lr_expr);
		}
		if(token1.getType().equals("MINUS")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			lr_expr lr_expr = lr_expr();
			return new expr_3(token1, expr, lr_expr);
		}
		if(token1.getType().equals("PLUS")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			lr_expr lr_expr = lr_expr();
			return new expr_4(token1, expr, lr_expr);
		}
		if(token1.getType().equals("LEFT_ROUND_B")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("RIGHT_ROUND_B")){
				System.out.println("SYNTAX ERROR, ) not found");
				return null;
			}
			tokens.poll();
			lr_expr lr_expr = lr_expr();
			return new expr_5(token1, expr, token2, lr_expr);
		}
		if(token1.getType().equals("TRUE") || token1.getType().equals("FALSE") ){
			tokens.poll();
			lr_expr lr_expr = lr_expr();
			return new expr_6(token1, lr_expr);
		}
		if(token1.getType().equals("INTEGRAL_LITERAL")){
			tokens.poll();
			lr_expr lr_expr = lr_expr();
			return new expr_7(token1, lr_expr);
		}
		if(token1.getType().equals("FLOAT_LITERAL")){
			tokens.poll();
			lr_expr lr_expr = lr_expr();
			return new expr_8(token1, lr_expr);
		}
		if(token1.getType().equals("NEW")){
			tokens.poll();
			type_spec type_spec = type_spec();
			if(type_spec == null){
				System.out.println("SYNTAX ERROR, type_spec cannot be null");
				return null;
			}
			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("LEFT_SQUARE_B")){
				System.out.println("SYNTAX ERROR, ) not found");
				return null;
			}
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			if(tokens.isEmpty()) return null;
			Token token3 = tokens.peek();
			if(!token3.getType().equals("RIGHT_SQUARE_B")){
				System.out.println("SYNTAX ERROR, ) not found");
				return null;
			}
			tokens.poll();
			lr_expr lr_expr = lr_expr();
			return new expr_9(token1, type_spec, token2, expr, token3, lr_expr);
		}
		System.out.println("SYNTAX ERROR, expr cannot be null");
		return null;
	}

	public lr_expr lr_expr(){
		lf_expr_expr lf_expr_expr = lf_expr_expr();
		if(lf_expr_expr != null){
			lr_expr lr_expr = lr_expr();
			return new lr_expr(lf_expr_expr, lr_expr);
		}
		return null;
	}

	public lf_expr_IDENT lf_expr_IDENT(){
		if(tokens.isEmpty()) return null;
		Token token1 = tokens.peek();
		if(token1.getType().equals("ASSIGN_OPERATOR")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_IDENT_1(token1, expr);
		}
		if(token1.getType().equals("LEFT_SQUARE_B")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("RIGHT_SQUARE_B")){
				System.out.println("SYNTAX ERROR, ) not found");
				return null;
			}
			tokens.poll();
			if(tokens.isEmpty()) return null;
			Token token3 = tokens.peek();
			if(!token3.getType().equals("ASSIGN_OPERATOR")){
				System.out.println("SYNTAX ERROR, ) not found");
				return null;
			}
			tokens.poll();
			expr expr1 = expr();
			if(expr1 == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_IDENT_2(token1, expr, token2, token3, expr1);
		}
		if(token1.getType().equals("LEFT_SQUARE_B")){
			tokens.poll();
			expr expr = expr();
			if(expr == null){
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("RIGHT_SQUARE_B")){
				System.out.println("SYNTAX ERROR, ] not found");
				return null;
			}
			tokens.poll();
			return new lf_expr_IDENT_3(token1, expr, token2);
		}
		if(token1.getType().equals("LEFT_ROUND_B")){
			tokens.poll();

			args args = args();

			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("RIGHT_ROUND_B")){
				System.out.println("SYNTAX ERROR, ) not found");
				return null;
			}
			tokens.poll();
			return new lf_expr_IDENT_4(token1, args, token2);
		}
		if(token1.getType().equals("DOT")){
			tokens.poll();

			if(tokens.isEmpty()) return null;
			Token token2 = tokens.peek();
			if(!token2.getType().equals("SIZE")){
				System.out.println("SYNTAX ERROR, 'size' not found");
				return null;
			}
			tokens.poll();
			return new lf_expr_IDENT_5(token1, token2);
		}
		return null;
	}

	public lf_expr_expr lf_expr_expr() {
		if (tokens.isEmpty()) return null;
		Token token = tokens.peek();
		if (token.getType().equals("OR")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_1(token, expr);
		}
		if (token.getType().equals("EQUAL")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_2(token, expr);
		}
		if (token.getType().equals("NOT_EQUAL")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_3(token, expr);
		}
		if (token.getType().equals("LESS_EQ")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_4(token, expr);
		}
		if (token.getType().equals("GREATERTHAN")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_5(token, expr);
		}
		if (token.getType().equals("GREAT_EQ")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_6(token, expr);
		}
		if (token.getType().equals("LESSTHAN")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_7(token, expr);
		}
		if (token.getType().equals("AND")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_8(token, expr);
		}
		if (token.getType().equals("PLUS")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_9(token, expr);
		}
		if (token.getType().equals("MINUS")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_10(token, expr);
		}
		if (token.getType().equals("ASTERICK")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_11(token, expr);
		}
		if (token.getType().equals("DIVIDE")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_12(token, expr);
		}
		if (token.getType().equals("MOD")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			return new lf_expr_expr_13(token, expr);
		}

		System.out.println("SYNTAX ERROR, lf_expr_expr cannot be null");
		return null;
	}

	public arg_list arg_list(){
		expr expr = expr();
		if (expr == null) {
			System.out.println("SYNTAX ERROR, expr cannot be null");
			return null;
		}
		lr_arg_list lr_arg_list = lr_arg_list();
		return new arg_list(expr, lr_arg_list);
	}

	public lr_arg_list lr_arg_list(){
		if (tokens.isEmpty()) return null;
		Token token = tokens.peek();
		if (token.getType().equals("COMMA")) {
			tokens.poll();
			expr expr = expr();
			if (expr == null) {
				System.out.println("SYNTAX ERROR, expr cannot be null");
				return null;
			}
			lr_arg_list lr_arg_list = lr_arg_list();
			return new lr_arg_list(expr, lr_arg_list, token);
		}
		return null;
	}

	public args args(){
		arg_list arg_list = arg_list();
		if(arg_list != null){
			return new args(arg_list);
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		SyntaxAnalyzer syntaxAnalyzer= new SyntaxAnalyzer("C:\\Users\\Aya Essam\\Desktop\\Y4T2\\Compilers\\compilers_phase2-2\\input.txt");
		
		program p = syntaxAnalyzer.parse();
		p.printNode();
	}
	
}
