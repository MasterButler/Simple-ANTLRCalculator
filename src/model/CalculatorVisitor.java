package model;

import java.util.Arrays;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.tree.ParseTree;

import model.CalcParser.CodeContext;
import model.CalcParser.OperationExprContext;
import model.CalcParser.ParExprContext;
import model.CalcParser.ValContext;
import model.CalcParser.ValueContext;

public class CalculatorVisitor extends CalcBaseVisitor<Float>{
	
	private CalcLexer lexer;
	private CommonTokenStream tokens;
	private ANTLRErrorStrategy defaultStrat;
	private CalcParser parser;
	private ParseTree tree;
	
	public Float solve(String expression) {
		Float output = Float.valueOf(0);
		
		lexer = new CalcLexer(CharStreams.fromString(expression));
        
        tokens = new CommonTokenStream(lexer);
        
        defaultStrat = new DefaultErrorStrategy();
        
        parser = new CalcParser(tokens);
        parser.setErrorHandler(defaultStrat);
        
        tree = parser.code();
        
		return visit(tree);
	}

	@Override
	public Float visitCode(CodeContext ctx) {
		return this.visit(ctx.mExpression());
	}
	
	@Override
	public Float visitOperationExpr(OperationExprContext ctx) {
		if(ctx.op != null) {
			System.out.println();
			System.out.println();
			System.out.println("MY LEFT	 IS:" + ctx.left.getText() );
			System.out.println("MY OP	 IS:" + ctx.op.getText() );
			System.out.println("MY RIGHT IS:" + ctx.right.getText() );
			Float theSolved = CalculatorUtil.solve(visit(ctx.left), ctx.op.getText().charAt(0), visit(ctx.right));
			System.out.println();
			System.out.println();
			System.out.println("LEFT: " + ctx.left.getText());
			System.out.println("OP: " + ctx.op.getText());
			System.out.println("RIGHT: " + ctx.right.getText());
			System.out.println("THE OUTPUT SOLVED IS : " + theSolved);
			return theSolved;
		}
		return super.visitOperationExpr(ctx);		
	}	

	@Override
	public Float visitParExpr(ParExprContext ctx) {
		return this.visit(ctx.solvableExpr);
	}
	
	@Override
	public Float visitVal(ValContext ctx) {
		return Float.valueOf(ctx.getText());
	}
	
	@Override
	public Float visitValue(ValueContext ctx) {
		return Float.valueOf(ctx.getText());
	}
}
