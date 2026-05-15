package defpackage;

import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zb extends AbstractViewOnTouchListenerC0044Dh0 {
    public final /* synthetic */ Fb C;
    public final /* synthetic */ AppCompatSpinner D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zb(AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, Fb fb) {
        super(appCompatSpinner2);
        this.D = appCompatSpinner;
        this.C = fb;
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final nI1 b() {
        return this.C;
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final boolean c() {
        AppCompatSpinner appCompatSpinner = this.D;
        if (appCompatSpinner.y.q()) {
            return true;
        }
        appCompatSpinner.y.p(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
        return true;
    }
}
