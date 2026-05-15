package org.chromium.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC1167nj2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TextViewWithLeading extends AppCompatTextView {
    public TextViewWithLeading(Context context, AttributeSet attributeSet) {
        Float fValueOf;
        int resourceId;
        super(context, attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.TextViewWithLeading, 0, 0);
        int i = AbstractC0305Yp1.TextViewWithLeading_leading;
        int i2 = AbstractC0305Yp1.TextViewWithLeading_android_textAppearance;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(i, 0.0f));
        } else if (!typedArrayObtainStyledAttributes.hasValue(i2) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0)) == 0) {
            fValueOf = null;
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, AbstractC0305Yp1.TextViewWithLeading);
            Float fValueOf2 = typedArrayObtainStyledAttributes2.hasValue(AbstractC0305Yp1.TextViewWithLeading_leading) ? Float.valueOf(typedArrayObtainStyledAttributes2.getDimension(AbstractC0305Yp1.TextViewWithLeading_leading, 0.0f)) : null;
            typedArrayObtainStyledAttributes2.recycle();
            fValueOf = fValueOf2;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (AbstractC1167nj2.a.a()) {
            setLineSpacing(fValueOf.floatValue() - getPaint().getFontMetrics(null), 1.0f);
        } else if (fValueOf != null) {
            setLineSpacing(fValueOf.floatValue() - getPaint().getFontMetrics(null), 1.0f);
        }
    }
}
