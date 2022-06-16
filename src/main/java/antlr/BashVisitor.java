// Generated from /Users/sigmadt/Desktop/mse/SD/fork-bash/Java-Shell/src/main/java/antlr/Bash.g4 by ANTLR 4.10.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BashParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BashVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code pipe}
	 * labeled alternative in {@link BashParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipe(BashParser.PipeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link BashParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(BashParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multipleCommands}
	 * labeled alternative in {@link BashParser#pipeline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleCommands(BashParser.MultipleCommandsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleCommand}
	 * labeled alternative in {@link BashParser#pipeline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleCommand(BashParser.SingleCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link BashParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(BashParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partWord}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartWord(BashParser.PartWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqstr}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqstr(BashParser.SqstrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dqstr}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDqstr(BashParser.DqstrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partVariable}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartVariable(BashParser.PartVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wordAssignment}
	 * labeled alternative in {@link BashParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordAssignment(BashParser.WordAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableAssignment}
	 * labeled alternative in {@link BashParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(BashParser.VariableAssignmentContext ctx);
}