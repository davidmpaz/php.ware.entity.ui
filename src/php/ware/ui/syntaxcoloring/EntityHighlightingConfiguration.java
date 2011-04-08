package php.ware.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class EntityHighlightingConfiguration extends
		DefaultHighlightingConfiguration {

	public static final String GROUPING_ID = "Grouping";
	public static final String CARDINALITY_ID = "Cardinality";
	public final static String CROSS_REF = "CrossReference";
	public final static String EMPTY_ELEMENT = "EmptyElement";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(GROUPING_ID, "Grouping Symbols",
				groupingTextStyle());
		acceptor.acceptDefaultHighlighting(CARDINALITY_ID,
				"Cardinality Symbols", cardinalityTextStyle());
		acceptor.acceptDefaultHighlighting(CROSS_REF, "Cross References",
				crossReferenceTextStyle());
		acceptor.acceptDefaultHighlighting(EMPTY_ELEMENT, "Empty Elements",
				emptyElementTextStyle());
	}

	private TextStyle crossReferenceTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(104, 141, 214));
		return textStyle;
	}

	public TextStyle cardinalityTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(142, 145, 164));
		return textStyle;
	}

	public TextStyle groupingTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		return textStyle;
	}

	public TextStyle emptyElementTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(207, 207, 207));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}
