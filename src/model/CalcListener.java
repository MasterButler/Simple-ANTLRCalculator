// Generated from /Users/Winfred Villaluna/Documents/SE Workspace/CMPILER Calculatr/src/model/Calc.g4 by ANTLR 4.7
package model;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(CalcParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(CalcParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code val}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void enterVal(CalcParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code val}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void exitVal(CalcParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(CalcParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(CalcParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operationExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void enterOperationExpr(CalcParser.OperationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operationExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void exitOperationExpr(CalcParser.OperationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CalcParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CalcParser.ValueContext ctx);
}