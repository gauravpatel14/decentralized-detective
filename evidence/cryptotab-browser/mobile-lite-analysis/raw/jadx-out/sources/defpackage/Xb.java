package defpackage;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Constructor;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Xb {
    public static final Class[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {R.attr.onClick};
    public static final int[] d = {R.attr.accessibilityHeading};
    public static final int[] e = {R.attr.accessibilityPaneTitle};
    public static final int[] f = {R.attr.screenReaderFocusable};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};
    public static final UJ1 h = new UJ1(0);
    public final Object[] a = new Object[2];

    public Ga a(Context context, AttributeSet attributeSet) {
        return new Ga(context, attributeSet, Ep1.autoCompleteTextViewStyle);
    }

    public Ia b(Context context, AttributeSet attributeSet) {
        return new Ia(context, attributeSet, Ep1.buttonStyle);
    }

    public Ka c(Context context, AttributeSet attributeSet) {
        return new Ka(context, attributeSet, Ep1.checkboxStyle);
    }

    public C1572ub d(Context context, AttributeSet attributeSet) {
        return new C1572ub(context, attributeSet, Ep1.radioButtonStyle);
    }

    public AppCompatTextView e(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public final View f(View view, String str, Context context, AttributeSet attributeSet) {
        Context c1264pM;
        View c1628vb;
        View view2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.View, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.View_theme, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        c1264pM = (resourceId == 0 || ((context instanceof C1264pM) && ((C1264pM) context).a == resourceId)) ? context : new C1264pM(resourceId, context);
        str.getClass();
        View view3 = null;
        switch (str) {
            case "RatingBar":
                c1628vb = new C1628vb(c1264pM, attributeSet);
                break;
            case "CheckedTextView":
                c1628vb = new La(c1264pM, attributeSet);
                break;
            case "MultiAutoCompleteTextView":
                c1628vb = new C1401rb(c1264pM, attributeSet);
                break;
            case "TextView":
                c1628vb = e(c1264pM, attributeSet);
                break;
            case "ImageButton":
                c1628vb = new C1285pb(c1264pM, attributeSet);
                break;
            case "SeekBar":
                c1628vb = new C1744xb(c1264pM, attributeSet, Ep1.seekBarStyle);
                break;
            case "Spinner":
                c1628vb = new AppCompatSpinner(c1264pM, attributeSet);
                break;
            case "RadioButton":
                c1628vb = d(c1264pM, attributeSet);
                break;
            case "ToggleButton":
                c1628vb = new Vb(c1264pM, attributeSet);
                break;
            case "ImageView":
                c1628vb = new AppCompatImageView(c1264pM, attributeSet);
                break;
            case "AutoCompleteTextView":
                c1628vb = a(c1264pM, attributeSet);
                break;
            case "CheckBox":
                c1628vb = c(c1264pM, attributeSet);
                break;
            case "EditText":
                c1628vb = new C1038lb(c1264pM, attributeSet);
                break;
            case "Button":
                c1628vb = b(c1264pM, attributeSet);
                break;
            default:
                c1628vb = null;
                break;
        }
        if (c1628vb != null || context == c1264pM) {
            view2 = c1628vb;
        } else {
            Object[] objArr = this.a;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = c1264pM;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i = 0;
                    while (true) {
                        String[] strArr = g;
                        if (i < 3) {
                            View viewG = g(c1264pM, str, strArr[i]);
                            if (viewG != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view3 = viewG;
                            } else {
                                i++;
                            }
                        }
                    }
                } else {
                    View viewG2 = g(c1264pM, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view3 = viewG2;
                }
            } catch (Exception unused) {
            } finally {
                objArr[0] = null;
                objArr[1] = null;
            }
            view2 = view3;
        }
        if (view2 != null) {
            Context context2 = view2.getContext();
            if ((context2 instanceof ContextWrapper) && view2.hasOnClickListeners()) {
                TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, c);
                String string = typedArrayObtainStyledAttributes2.getString(0);
                if (string != null) {
                    view2.setOnClickListener(new Wb(view2, string));
                }
                typedArrayObtainStyledAttributes2.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes3 = c1264pM.obtainStyledAttributes(attributeSet, d);
                if (typedArrayObtainStyledAttributes3.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes3.getBoolean(0, false);
                    WeakHashMap weakHashMap = AbstractC0604eo2.a;
                    new C0273Wn2(AbstractC0132Lp1.tag_accessibility_heading, Boolean.class, 0, 28, 3).a(view2, Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes3.recycle();
                TypedArray typedArrayObtainStyledAttributes4 = c1264pM.obtainStyledAttributes(attributeSet, e);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    AbstractC0604eo2.p(typedArrayObtainStyledAttributes4.getString(0), view2);
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = c1264pM.obtainStyledAttributes(attributeSet, f);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes5.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
                    new C0273Wn2(AbstractC0132Lp1.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).a(view2, Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes5.recycle();
            }
        }
        return view2;
    }

    public final View g(Context context, String str, String str2) {
        String strConcat;
        UJ1 uj1 = h;
        Constructor constructor = (Constructor) uj1.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            uj1.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.a);
    }
}
