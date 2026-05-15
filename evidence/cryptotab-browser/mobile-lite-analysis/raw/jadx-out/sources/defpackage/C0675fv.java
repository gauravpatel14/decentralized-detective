package defpackage;

import android.content.Context;
import org.chromium.content.browser.TracingControllerAndroidImpl;

/* JADX INFO: renamed from: fv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0675fv implements InterfaceC0550dv {
    public final /* synthetic */ RunnableC0741gv a;

    public C0675fv(RunnableC0741gv runnableC0741gv) {
        this.a = runnableC0741gv;
    }

    @Override // defpackage.InterfaceC0550dv
    public final void b() {
        Context context = AbstractC1499tM.a;
        RunnableC0741gv runnableC0741gv = this.a;
        runnableC0741gv.t.k = new TracingControllerAndroidImpl(context);
        TracingControllerAndroidImpl tracingControllerAndroidImpl = runnableC0741gv.t.k;
        context.registerReceiver(tracingControllerAndroidImpl.b, tracingControllerAndroidImpl.c, null, null, 2);
    }

    @Override // defpackage.InterfaceC0550dv
    public final void a() {
    }
}
