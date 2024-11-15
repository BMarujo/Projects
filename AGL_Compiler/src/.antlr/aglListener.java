// Generated from /home/marujo/agl-gg11/src/agl.g4 by ANTLR 4.13.1
import type.*;
         import symbol.*;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link aglParser}.
 */
public interface aglListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link aglParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(aglParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(aglParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#importSmt}.
	 * @param ctx the parse tree
	 */
	void enterImportSmt(aglParser.ImportSmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#importSmt}.
	 * @param ctx the parse tree
	 */
	void exitImportSmt(aglParser.ImportSmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(aglParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(aglParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(aglParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(aglParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#wait_command}.
	 * @param ctx the parse tree
	 */
	void enterWait_command(aglParser.Wait_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#wait_command}.
	 * @param ctx the parse tree
	 */
	void exitWait_command(aglParser.Wait_commandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprComparison}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprComparison(aglParser.ExprComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprComparison}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprComparison(aglParser.ExprComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exprpoint}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprpoint(aglParser.ExprpointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exprpoint}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprpoint(aglParser.ExprpointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprString(aglParser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprString(aglParser.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(aglParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(aglParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInt}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInt(aglParser.ExprIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInt}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInt(aglParser.ExprIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(aglParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(aglParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(aglParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(aglParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(aglParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(aglParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLogical(aglParser.ExprLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLogical(aglParser.ExprLogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(aglParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(aglParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exprtime}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprtime(aglParser.ExprtimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exprtime}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprtime(aglParser.ExprtimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exprvector}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprvector(aglParser.ExprvectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exprvector}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprvector(aglParser.ExprvectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exprnumber}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprnumber(aglParser.ExprnumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exprnumber}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprnumber(aglParser.ExprnumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBool(aglParser.ExprBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBool(aglParser.ExprBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(aglParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(aglParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(aglParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(aglParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardefault}
	 * labeled alternative in {@link aglParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVardefault(aglParser.VardefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardefault}
	 * labeled alternative in {@link aglParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVardefault(aglParser.VardefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vartype}
	 * labeled alternative in {@link aglParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVartype(aglParser.VartypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vartype}
	 * labeled alternative in {@link aglParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVartype(aglParser.VartypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varfigure}
	 * labeled alternative in {@link aglParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVarfigure(aglParser.VarfigureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varfigure}
	 * labeled alternative in {@link aglParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVarfigure(aglParser.VarfigureContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#variable_parameters}.
	 * @param ctx the parse tree
	 */
	void enterVariable_parameters(aglParser.Variable_parametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#variable_parameters}.
	 * @param ctx the parse tree
	 */
	void exitVariable_parameters(aglParser.Variable_parametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(aglParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(aglParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(aglParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(aglParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code figures_expr}
	 * labeled alternative in {@link aglParser#figures}.
	 * @param ctx the parse tree
	 */
	void enterFigures_expr(aglParser.Figures_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code figures_expr}
	 * labeled alternative in {@link aglParser#figures}.
	 * @param ctx the parse tree
	 */
	void exitFigures_expr(aglParser.Figures_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code figures_expr_with}
	 * labeled alternative in {@link aglParser#figures}.
	 * @param ctx the parse tree
	 */
	void enterFigures_expr_with(aglParser.Figures_expr_withContext ctx);
	/**
	 * Exit a parse tree produced by the {@code figures_expr_with}
	 * labeled alternative in {@link aglParser#figures}.
	 * @param ctx the parse tree
	 */
	void exitFigures_expr_with(aglParser.Figures_expr_withContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#figure}.
	 * @param ctx the parse tree
	 */
	void enterFigure(aglParser.FigureContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#figure}.
	 * @param ctx the parse tree
	 */
	void exitFigure(aglParser.FigureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code figures_params_length}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void enterFigures_params_length(aglParser.Figures_params_lengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code figures_params_length}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void exitFigures_params_length(aglParser.Figures_params_lengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code figures_params_angles}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void enterFigures_params_angles(aglParser.Figures_params_anglesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code figures_params_angles}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void exitFigures_params_angles(aglParser.Figures_params_anglesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code figures_params_colors}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void enterFigures_params_colors(aglParser.Figures_params_colorsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code figures_params_colors}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void exitFigures_params_colors(aglParser.Figures_params_colorsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code figures_params_text}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void enterFigures_params_text(aglParser.Figures_params_textContext ctx);
	/**
	 * Exit a parse tree produced by the {@code figures_params_text}
	 * labeled alternative in {@link aglParser#figures_params}.
	 * @param ctx the parse tree
	 */
	void exitFigures_params_text(aglParser.Figures_params_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#figure_angles}.
	 * @param ctx the parse tree
	 */
	void enterFigure_angles(aglParser.Figure_anglesContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#figure_angles}.
	 * @param ctx the parse tree
	 */
	void exitFigure_angles(aglParser.Figure_anglesContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#figure_colors}.
	 * @param ctx the parse tree
	 */
	void enterFigure_colors(aglParser.Figure_colorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#figure_colors}.
	 * @param ctx the parse tree
	 */
	void exitFigure_colors(aglParser.Figure_colorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#length}.
	 * @param ctx the parse tree
	 */
	void enterLength(aglParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#length}.
	 * @param ctx the parse tree
	 */
	void exitLength(aglParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(aglParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(aglParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_action_refresh}
	 * labeled alternative in {@link aglParser#view_actions}.
	 * @param ctx the parse tree
	 */
	void enterView_action_refresh(aglParser.View_action_refreshContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_action_refresh}
	 * labeled alternative in {@link aglParser#view_actions}.
	 * @param ctx the parse tree
	 */
	void exitView_action_refresh(aglParser.View_action_refreshContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_action_close}
	 * labeled alternative in {@link aglParser#view_actions}.
	 * @param ctx the parse tree
	 */
	void enterView_action_close(aglParser.View_action_closeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_action_close}
	 * labeled alternative in {@link aglParser#view_actions}.
	 * @param ctx the parse tree
	 */
	void exitView_action_close(aglParser.View_action_closeContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#close}.
	 * @param ctx the parse tree
	 */
	void enterClose(aglParser.CloseContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#close}.
	 * @param ctx the parse tree
	 */
	void exitClose(aglParser.CloseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code movevar}
	 * labeled alternative in {@link aglParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMovevar(aglParser.MovevarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code movevar}
	 * labeled alternative in {@link aglParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMovevar(aglParser.MovevarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moveview}
	 * labeled alternative in {@link aglParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMoveview(aglParser.MoveviewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moveview}
	 * labeled alternative in {@link aglParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMoveview(aglParser.MoveviewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code movefigure}
	 * labeled alternative in {@link aglParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMovefigure(aglParser.MovefigureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code movefigure}
	 * labeled alternative in {@link aglParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMovefigure(aglParser.MovefigureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refresh_aftertime}
	 * labeled alternative in {@link aglParser#refresh}.
	 * @param ctx the parse tree
	 */
	void enterRefresh_aftertime(aglParser.Refresh_aftertimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refresh_aftertime}
	 * labeled alternative in {@link aglParser#refresh}.
	 * @param ctx the parse tree
	 */
	void exitRefresh_aftertime(aglParser.Refresh_aftertimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refresh_default}
	 * labeled alternative in {@link aglParser#refresh}.
	 * @param ctx the parse tree
	 */
	void enterRefresh_default(aglParser.Refresh_defaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refresh_default}
	 * labeled alternative in {@link aglParser#refresh}.
	 * @param ctx the parse tree
	 */
	void exitRefresh_default(aglParser.Refresh_defaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_with_operator}
	 * labeled alternative in {@link aglParser#view}.
	 * @param ctx the parse tree
	 */
	void enterView_with_operator(aglParser.View_with_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_with_operator}
	 * labeled alternative in {@link aglParser#view}.
	 * @param ctx the parse tree
	 */
	void exitView_with_operator(aglParser.View_with_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code viewdefault}
	 * labeled alternative in {@link aglParser#view}.
	 * @param ctx the parse tree
	 */
	void enterViewdefault(aglParser.ViewdefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code viewdefault}
	 * labeled alternative in {@link aglParser#view}.
	 * @param ctx the parse tree
	 */
	void exitViewdefault(aglParser.ViewdefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with_figureparams}
	 * labeled alternative in {@link aglParser#with}.
	 * @param ctx the parse tree
	 */
	void enterWith_figureparams(aglParser.With_figureparamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with_figureparams}
	 * labeled alternative in {@link aglParser#with}.
	 * @param ctx the parse tree
	 */
	void exitWith_figureparams(aglParser.With_figureparamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with_viewparams}
	 * labeled alternative in {@link aglParser#with}.
	 * @param ctx the parse tree
	 */
	void enterWith_viewparams(aglParser.With_viewparamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with_viewparams}
	 * labeled alternative in {@link aglParser#with}.
	 * @param ctx the parse tree
	 */
	void exitWith_viewparams(aglParser.With_viewparamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with_operator_figure}
	 * labeled alternative in {@link aglParser#with_operator}.
	 * @param ctx the parse tree
	 */
	void enterWith_operator_figure(aglParser.With_operator_figureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with_operator_figure}
	 * labeled alternative in {@link aglParser#with_operator}.
	 * @param ctx the parse tree
	 */
	void exitWith_operator_figure(aglParser.With_operator_figureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with_operator_view}
	 * labeled alternative in {@link aglParser#with_operator}.
	 * @param ctx the parse tree
	 */
	void enterWith_operator_view(aglParser.With_operator_viewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with_operator_view}
	 * labeled alternative in {@link aglParser#with_operator}.
	 * @param ctx the parse tree
	 */
	void exitWith_operator_view(aglParser.With_operator_viewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_params_axis}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void enterView_params_axis(aglParser.View_params_axisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_params_axis}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void exitView_params_axis(aglParser.View_params_axisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_params_measures}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void enterView_params_measures(aglParser.View_params_measuresContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_params_measures}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void exitView_params_measures(aglParser.View_params_measuresContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_params_title}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void enterView_params_title(aglParser.View_params_titleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_params_title}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void exitView_params_title(aglParser.View_params_titleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_params_background}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void enterView_params_background(aglParser.View_params_backgroundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_params_background}
	 * labeled alternative in {@link aglParser#view_params}.
	 * @param ctx the parse tree
	 */
	void exitView_params_background(aglParser.View_params_backgroundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_measures_width}
	 * labeled alternative in {@link aglParser#view_measures}.
	 * @param ctx the parse tree
	 */
	void enterView_measures_width(aglParser.View_measures_widthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_measures_width}
	 * labeled alternative in {@link aglParser#view_measures}.
	 * @param ctx the parse tree
	 */
	void exitView_measures_width(aglParser.View_measures_widthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_measures_height}
	 * labeled alternative in {@link aglParser#view_measures}.
	 * @param ctx the parse tree
	 */
	void enterView_measures_height(aglParser.View_measures_heightContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_measures_height}
	 * labeled alternative in {@link aglParser#view_measures}.
	 * @param ctx the parse tree
	 */
	void exitView_measures_height(aglParser.View_measures_heightContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_axis_x}
	 * labeled alternative in {@link aglParser#view_axis}.
	 * @param ctx the parse tree
	 */
	void enterView_axis_x(aglParser.View_axis_xContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_axis_x}
	 * labeled alternative in {@link aglParser#view_axis}.
	 * @param ctx the parse tree
	 */
	void exitView_axis_x(aglParser.View_axis_xContext ctx);
	/**
	 * Enter a parse tree produced by the {@code view_axis_y}
	 * labeled alternative in {@link aglParser#view_axis}.
	 * @param ctx the parse tree
	 */
	void enterView_axis_y(aglParser.View_axis_yContext ctx);
	/**
	 * Exit a parse tree produced by the {@code view_axis_y}
	 * labeled alternative in {@link aglParser#view_axis}.
	 * @param ctx the parse tree
	 */
	void exitView_axis_y(aglParser.View_axis_yContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(aglParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(aglParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#background}.
	 * @param ctx the parse tree
	 */
	void enterBackground(aglParser.BackgroundContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#background}.
	 * @param ctx the parse tree
	 */
	void exitBackground(aglParser.BackgroundContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(aglParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(aglParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(aglParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(aglParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(aglParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(aglParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(aglParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(aglParser.VectorContext ctx);
}