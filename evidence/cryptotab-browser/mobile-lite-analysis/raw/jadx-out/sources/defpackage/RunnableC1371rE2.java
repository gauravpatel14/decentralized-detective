package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: rE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1371rE2 implements Runnable {
    public final /* synthetic */ tp t;
    public final /* synthetic */ InterfaceC0866im1 u;

    public /* synthetic */ RunnableC1371rE2(tp tpVar, InterfaceC0866im1 interfaceC0866im1) {
        this.t = tpVar;
        this.u = interfaceC0866im1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tp tpVar = this.t;
        tpVar.getClass();
        Cp cp = MI2.j;
        tpVar.i(CI2.a(24, 7, cp));
        this.u.b(cp, new ArrayList());
    }
}
