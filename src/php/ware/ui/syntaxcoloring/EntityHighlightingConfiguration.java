package php.ware.ui.syntaxcoloring;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class EntityHighlightingConfiguration extends
        DefaultHighlightingConfiguration {

    public static final String GROUPING_ID = "grouping";
    public static final String CARDINALITY_ID = "cardinality";

    @Override
    public void configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor);
        acceptor.acceptDefaultHighlighting(GROUPING_ID, "Grouping Symbols",
                groupingTextStyle());
        acceptor.acceptDefaultHighlighting(CARDINALITY_ID, "Cardinality",
                cardinalityTextStyle());
    }

    public TextStyle groupingTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(127, 0, 85));
        return textStyle;
    }

    public TextStyle cardinalityTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(142, 145, 164));
        return textStyle;
    }
}
