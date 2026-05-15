package defpackage;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Ob extends Nb {
    public final /* synthetic */ AppCompatTextView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ob(AppCompatTextView appCompatTextView) {
        super(appCompatTextView);
        this.b = appCompatTextView;
    }

    @Override // defpackage.Nb
    public final void a(int i) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i);
    }

    @Override // defpackage.Nb
    public final void b(int i) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i);
    }
}
