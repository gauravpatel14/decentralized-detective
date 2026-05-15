package defpackage;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: j01, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0874j01 extends ClickableSpan {
    public final int t;
    public final Callback u;

    public C0874j01(Context context, Callback callback) {
        this.t = AbstractC1688wg.b(context.getTheme(), Ep1.globalClickableSpanColor, AbstractC0084Gp1.default_text_color_link_baseline);
        this.u = callback;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        this.u.a0(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.t);
    }

    public C0874j01(Context context, int i, Callback callback) {
        this.t = context.getColor(i);
        this.u = callback;
    }
}
