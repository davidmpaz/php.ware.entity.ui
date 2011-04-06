package php.ware.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class EntityHighlightingConfiguration extends
        DefaultHighlightingConfiguration {

    public static final String GROUPING_ID = "grouping";
    public static final String CARDINALITY_ID = "cardinality";

    private final FontData defaultFont = new FontData("Bookman Old Style", 12,
            SWT.NORMAL);
    private final FontData italicFont = new FontData("Bookman Old Style", 12,
            SWT.ITALIC);

    @Override
    public void configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor);
        acceptor.acceptDefaultHighlighting(GROUPING_ID, "Grouping Symbols",
                groupingTextStyle());
        acceptor.acceptDefaultHighlighting(CARDINALITY_ID, "Cardinality",
                cardinalityTextStyle());
    }

    @Override
    public TextStyle defaultTextStyle() {
        TextStyle textStyle = super.defaultTextStyle();
        textStyle.setFontData(defaultFont);
        return textStyle;
    }

    @Override
    public TextStyle errorTextStyle() {
        TextStyle textStyle = super.errorTextStyle();
        textStyle.setFontData(defaultFont);
        return textStyle;
    }

    @Override
    public TextStyle numberTextStyle() {
        TextStyle textStyle = super.numberTextStyle();
        textStyle.setFontData(italicFont);
        return textStyle;
    }

    @Override
    public TextStyle stringTextStyle() {
        TextStyle textStyle = super.stringTextStyle();
        textStyle.setFontData(italicFont);
        return textStyle;
    }

    @Override
    public TextStyle commentTextStyle() {
        TextStyle textStyle = super.commentTextStyle();
        textStyle.setFontData(italicFont);
        return textStyle;
    }

    @Override
    public TextStyle keywordTextStyle() {
        TextStyle textStyle = super.keywordTextStyle();
        textStyle.setFontData(defaultFont);
        return textStyle;
    }

    @Override
    public TextStyle punctuationTextStyle() {
        TextStyle textStyle = super.punctuationTextStyle();
        textStyle.setFontData(defaultFont);
        return textStyle;
    }

    public TextStyle groupingTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(127, 0, 85));
        textStyle.setFontData(defaultFont);
        return textStyle;
    }

    public TextStyle cardinalityTextStyle() {
        TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(142, 145, 164));
        textStyle.setFontData(defaultFont);
        return textStyle;
    }
}
