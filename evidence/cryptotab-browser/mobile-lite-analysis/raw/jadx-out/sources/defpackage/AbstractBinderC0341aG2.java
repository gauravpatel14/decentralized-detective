package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: aG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0341aG2 extends AbstractBinderC1280pX2 implements InterfaceC1262pH2 {
    public final H62 t;
    public final /* synthetic */ C0765hG2 u;

    public AbstractBinderC0341aG2(C0765hG2 c0765hG2, H62 h62) {
        this.u = c0765hG2;
        attachInterface(this, "com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
        this.t = h62;
    }

    public void B(int i, Bundle bundle) {
        this.u.b.d(this.t);
        C0765hG2.c.c("onStartInstall(%d)", Integer.valueOf(i));
    }

    public void b(Bundle bundle) {
        this.u.b.d(this.t);
        C0765hG2.c.c("onDeferredInstall", new Object[0]);
    }

    public void e(Bundle bundle) {
        this.u.b.d(this.t);
        C0765hG2.c.c("onDeferredLanguageInstall", new Object[0]);
    }
}
