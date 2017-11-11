// Generated from Calc.g4 by ANTLR 4.4
package model;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code val}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void enterVal(@NotNull CalcParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code val}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void exitVal(@NotNull CalcParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull CalcParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull CalcParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(@NotNull CalcParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(@NotNull CalcParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operationExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void enterOperationExpr(@NotNull CalcParser.OperationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operationExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 */
	void exitOperationExpr(@NotNull CalcParser.OperationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull CalcParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull CalcParser.ValueContext ctx);
}