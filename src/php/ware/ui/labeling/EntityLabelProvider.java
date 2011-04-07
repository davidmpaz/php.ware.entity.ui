/*
 * generated by Xtext
 */
package php.ware.ui.labeling;

import java.util.Iterator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.StylerFactory;

import php.ware.entity.Attribute;
import php.ware.entity.DataType;
import php.ware.entity.Entity;
import php.ware.entity.Import;
import php.ware.entity.Operation;
import php.ware.entity.PackageDeclaration;
import php.ware.entity.Parameter;
import php.ware.entity.Reference;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class EntityLabelProvider extends DefaultEObjectLabelProvider {

    @Inject
    public EntityLabelProvider(AdapterFactoryLabelProvider delegate) {
        super(delegate);
    }

    public StyledString text(Import ele) {
        return new StyledString(ele.getImportedNamespace(),
                StyledString.QUALIFIER_STYLER);
    }

    public String image(Import ele) {
        return ele.eClass().getName() + ".gif";
    }

    public StyledString text(PackageDeclaration ele) {
        return new StyledString(ele.getName(), StyledString.QUALIFIER_STYLER);
    }

    public String image(PackageDeclaration ele) {
        return ele.eClass().getName() + ".gif";
    }

    public StyledString text(Entity ele) {
        StyledString ss = new StyledString();

        // is abstract?
        if (ele.isIsAbstract()) {
            if (ele.getFeatures().size() == 0) {
                ss.append(ele.getName(), this.getEmptyEntityStyler());
                return ss;
            }
            ss.append(ele.getName(), StyledString.COUNTER_STYLER);
            return ss;
        }

        if (ele.getFeatures().size() == 0) {
            ss.append(ele.getName(), this.getEmptyEntityStyler());
            return ss;
        }

        // inherits from another entity
        if (ele.getSuperType() != null) {
            ss.append(ele.getName()).append(" -> ",
                    StyledString.DECORATIONS_STYLER);
            ss.append(this.text(ele.getSuperType()));
            return ss;
        }

        return ss.append(ele.getName());
    }

    public String image(Entity ele) {
        return (ele.isIsAbstract()) ? "Abstract.gif" : ele.eClass().getName()
                + ".gif";
    }

    public StyledString text(DataType ele) {
        return new StyledString(ele.getName());
    }

    public String image(DataType ele) {
        return ele.eClass().getName() + ".gif";
    }

    public StyledString text(Reference ele) {

        StyledString ss = new StyledString();

        if (ele.getType().isComp()) {
            ss.append(ele.getName(), this.getComposedOfStyler())
                    .append(" : ", this.getKeysStyler())
                    .append(ele.getType().getReferenced().getName(),
                            StyledString.DECORATIONS_STYLER);
        } else {
            ss.append(ele.getName())
                    .append(" : ", this.getKeysStyler())
                    .append(ele.getType().getReferenced().getName(),
                            StyledString.DECORATIONS_STYLER);
        }

        if (ele.getType().isMulti()) {
            ss.append("[] ", this.getKeysStyler());
        }

        if (ele.getOpposite() != null) {
            ss.append("<=> ", StyledString.DECORATIONS_STYLER)
                    .append(ele.getType().getReferenced().getName(),
                            StyledString.DECORATIONS_STYLER)
                    .append(" :: ", this.getKeysStyler())
                    .append(ele.getOpposite().getName());
        }

        return ss;
    }

    public String image(Reference ele) {
        return ele.eClass().getName() + ".gif";
    }

    public StyledString text(Attribute ele) {
        StyledString ss = new StyledString();

        if (ele.getType().isComp()) {
            ss.append(ele.getName(), this.getComposedOfStyler())
                    .append(" : ", this.getKeysStyler())
                    .append(ele.getType().getReferenced().getName(),
                            StyledString.DECORATIONS_STYLER);
        } else {
            ss.append(ele.getName())
                    .append(" : ", this.getKeysStyler())
                    .append(ele.getType().getReferenced().getName(),
                            StyledString.DECORATIONS_STYLER);
        }

        if (ele.getType().isMulti()) {
            ss.append("[] ", this.getKeysStyler());
        }

        return ss;
    }

    public String image(Attribute ele) {
        return ele.eClass().getName() + ".gif";
    }

    public StyledString text(Operation ele) {

        StyledString ss = new StyledString(ele.getName());
        ss.append(" ( ", this.getKeysStyler());

        Iterator<Parameter> it = ele.getParams().iterator();
        while (it.hasNext()) {
            Parameter param = it.next();
            ss.append(param.getType().getReferenced().getName());
            if (it.hasNext())
                ss.append(" , ", this.getKeysStyler());
        }
        ss.append(" )", this.getKeysStyler())
                .append(" : ", StyledString.DECORATIONS_STYLER)
                .append(ele.getType().getReferenced().getName(),
                        StyledString.DECORATIONS_STYLER);

        return ss;
    }

    public String image(Operation ele) {
        switch (ele.getVisibility()) {
        case PRIVATE:
            return "Private" + ele.eClass().getName() + ".gif";
        case PROTECTED:
            return "Protected" + ele.eClass().getName() + ".gif";
        default:
            return "Public" + ele.eClass().getName() + ".gif";
        }
    }

    public StyledString text(Parameter ele) {
        StyledString ss = new StyledString(ele.getName());
        ss.append(" : ", this.getKeysStyler()).append(
                ele.getType().getReferenced().getName(),
                StyledString.DECORATIONS_STYLER);
        return ss;
    }

    public String image(Parameter ele) {
        return ele.eClass().getName() + ".gif";
    }

    /**
     * Return {@link Styler} object for styling composed of attributes and
     * references
     * 
     * @return {@link Styler}
     */
    protected Styler getComposedOfStyler() {

        StylerFactory sf = new StylerFactory();
        TextStyle ts = new TextStyle();

        ts.setStyle(SWT.NORMAL);
        ts.setColor(new RGB(200, 0, 0));
        ts.setBackgroundColor(new RGB(255, 255, 255));

        return sf.createXtextStyleAdapterStyler(ts);
    }

    /**
     * Return {@link Styler} object for styling some symbols.
     * 
     * @return {@link Styler}
     */
    protected Styler getKeysStyler() {

        StylerFactory sf = new StylerFactory();
        TextStyle ts = new TextStyle();

        ts.setStyle(SWT.NORMAL);
        ts.setColor(new RGB(255, 168, 35));
        ts.setBackgroundColor(new RGB(255, 255, 255));

        return sf.createXtextStyleAdapterStyler(ts);
    }

    /**
     * Return {@link Styler} object for styling some symbols.
     * 
     * @return {@link Styler}
     */
    protected Styler getEmptyEntityStyler() {

        StylerFactory sf = new StylerFactory();
        TextStyle ts = new TextStyle();

        ts.setStyle(SWT.NORMAL);
        ts.setColor(new RGB(207, 207, 207));
        ts.setBackgroundColor(new RGB(255, 255, 255));

        return sf.createXtextStyleAdapterStyler(ts);
    }
}
