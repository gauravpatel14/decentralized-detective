package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import defpackage.AbstractC0132Lp1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class HelpTextView extends LinearLayout {
    public TextView t;
    public TextView u;

    @Keep
    public HelpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) findViewById(AbstractC0132Lp1.cast_featurehighlight_help_text_header_view);
        textView.getClass();
        this.t = textView;
        TextView textView2 = (TextView) findViewById(AbstractC0132Lp1.cast_featurehighlight_help_text_body_view);
        textView2.getClass();
        this.u = textView2;
    }

    @Keep
    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView = this.t;
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        TextView textView2 = this.u;
        textView2.setText(charSequence2);
        textView2.setVisibility(TextUtils.isEmpty(charSequence2) ? 8 : 0);
    }

    @Keep
    public View asView() {
        return this;
    }
}
