package php.ware.ui.syntaxcoloring;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.DefaultAntlrTokenToAttributeIdMapper;

import com.google.inject.Singleton;

@Singleton
public class EntityAntlrTokenToAttributeIdMapper extends
        DefaultAntlrTokenToAttributeIdMapper {

    private static final Pattern GROUPING = Pattern
            .compile("('\\['|'\\]'|'\\)'|'\\('|'\\{'|'\\}')");

    private static final Pattern CARDINALITY = Pattern
            .compile("('\\[\\]'|'\\+')");

    @Override
    protected String calculateId(String tokenName, int tokenType) {

        if (CARDINALITY.matcher(tokenName).matches()) {
            return EntityHighlightingConfiguration.CARDINALITY_ID;
        }

        if (GROUPING.matcher(tokenName).matches()) {
            return EntityHighlightingConfiguration.GROUPING_ID;
        }

        return super.calculateId(tokenName, tokenType);
    }
}
