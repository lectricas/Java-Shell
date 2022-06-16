// Generated from /Users/sigmadt/Desktop/mse/SD/fork-bash/Java-Shell/src/main/java/antlr/Bash.g4 by ANTLR 4.10.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BashParser}.
 */
public interface BashListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code pipe}
	 * labeled alternative in {@link BashParser#start}.
	 * @param ctx the parse tree
	 */
	void enterPipe(BashParser.PipeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pipe}
	 * labeled alternative in {@link BashParser#start}.
	 * @param ctx the parse tree
	 */
	void exitPipe(BashParser.PipeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link BashParser#start}.
	 * @param ctx the parse tree
	 */
	void enterAssign(BashParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link BashParser#start}.
	 * @param ctx the parse tree
	 */
	void exitAssign(BashParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multipleCommands}
	 * labeled alternative in {@link BashParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void enterMultipleCommands(BashParser.MultipleCommandsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multipleCommands}
	 * labeled alternative in {@link BashParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void exitMultipleCommands(BashParser.MultipleCommandsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleCommand}
	 * labeled alternative in {@link BashParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void enterSingleCommand(BashParser.SingleCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleCommand}
	 * labeled alternative in {@link BashParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void exitSingleCommand(BashParser.SingleCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BashParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(BashParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BashParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(BashParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code partWord}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPartWord(BashParser.PartWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code partWord}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPartWord(BashParser.PartWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sqstr}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void enterSqstr(BashParser.SqstrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sqstr}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void exitSqstr(BashParser.SqstrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dqstr}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void enterDqstr(BashParser.DqstrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dqstr}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void exitDqstr(BashParser.DqstrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code partVariable}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPartVariable(BashParser.PartVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code partVariable}
	 * labeled alternative in {@link BashParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPartVariable(BashParser.PartVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wordAssignment}
	 * labeled alternative in {@link BashParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterWordAssignment(BashParser.WordAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wordAssignment}
	 * labeled alternative in {@link BashParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitWordAssignment(BashParser.WordAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableAssignment}
	 * labeled alternative in {@link BashParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(BashParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableAssignment}
	 * labeled alternative in {@link BashParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(BashParser.VariableAssignmentContext ctx);
}