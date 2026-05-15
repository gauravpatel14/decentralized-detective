package defpackage;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Pb extends Ob {
    public final /* synthetic */ AppCompatTextView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pb(AppCompatTextView appCompatTextView) {
        super(appCompatTextView);
        this.c = appCompatTextView;
    }

    @Override // defpackage.Nb
    public final void c(int i, float f) {
        super/*android.widget.TextView*/.setLineHeight(i, f);
    }
}
