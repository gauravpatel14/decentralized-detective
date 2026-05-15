package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PZ2 extends FF2 implements InterfaceC1509tS2 {
    public final C1224oY2 t;
    public final H62 u;
    public final /* synthetic */ F13 v;

    public PZ2(F13 f13, C1224oY2 c1224oY2, H62 h62) {
        this.v = f13;
        attachInterface(this, "com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
        this.t = c1224oY2;
        this.u = h62;
    }

    @Override // defpackage.InterfaceC1509tS2
    public void b(Bundle bundle) {
        this.v.a.c(this.u);
        this.t.b("onRequestInfo", new Object[0]);
    }

    public void zzb(Bundle bundle) {
        this.v.a.c(this.u);
        this.t.b("onCompleteUpdate", new Object[0]);
    }
}
