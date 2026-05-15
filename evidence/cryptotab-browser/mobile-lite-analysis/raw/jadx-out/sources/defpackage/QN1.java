package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QN1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ SN1 t;

    public QN1(SN1 sn1) {
        this.t = sn1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        SN1 sn1 = this.t;
        if (sn1.q()) {
            RQ0 rq0 = sn1.A;
            if (rq0.R) {
                return;
            }
            View view = sn1.F;
            if (view == null || !view.isShown()) {
                sn1.dismiss();
            } else {
                rq0.a();
            }
        }
    }
}
