package org.chromium.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ElidedUrlTextView extends AppCompatTextView {
    public Integer A;
    public boolean B;
    public int C;
    public int D;
    public Integer z;

    public ElidedUrlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = true;
        this.C = -1;
        this.D = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        setMaxLines(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        super.onMeasure(i, i2);
        String string = getText().toString();
        int i3 = this.C;
        Layout layout = getLayout();
        int i4 = 0;
        int i5 = 0;
        while (i5 < layout.getLineCount() && layout.getLineEnd(i5) < i3) {
            i5++;
        }
        this.z = Integer.valueOf(i5 + 2);
        int iIndexOf = string.indexOf(35);
        if (iIndexOf == -1) {
            iIndexOf = string.length();
        }
        Layout layout2 = getLayout();
        while (i4 < layout2.getLineCount() && layout2.getLineEnd(i4) < iIndexOf) {
            i4++;
        }
        int i6 = i4 + 2;
        this.A = Integer.valueOf(i6);
        if (i6 < this.z.intValue()) {
            this.z = this.A;
        }
        int iIntValue = this.A.intValue();
        if (this.B) {
            iIntValue = this.z.intValue();
        }
        if (iIntValue != this.D) {
            setMaxLines(iIntValue);
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView
    public final void setMaxLines(int i) {
        super.setMaxLines(i);
        this.D = i;
    }
}
