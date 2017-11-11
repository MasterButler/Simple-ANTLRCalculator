// Generated from /Users/Winfred Villaluna/Documents/SE Workspace/CMPILER Calculatr/src/model/Calc.g4 by ANTLR 4.7
package model;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(CalcParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code val}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(CalcParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(CalcParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operationExpr}
	 * labeled alternative in {@link CalcParser#mExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationExpr(CalcParser.OperationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CalcParser.ValueContext ctx);
}