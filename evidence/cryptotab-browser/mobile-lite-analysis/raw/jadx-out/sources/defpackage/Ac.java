package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Ac implements U41, Q41 {
    public final /* synthetic */ C0029Cc a;

    @Override // defpackage.U41
    public void a(Object obj) {
        String str = (String) obj;
        C0029Cc c0029Cc = this.a;
        c0029Cc.getClass();
        Log.i("cr_AppInstanceIdController", "App instance id: " + str);
        c0029Cc.c = str;
        c0029Cc.b.countDown();
    }

    @Override // defpackage.Q41
    public void d(Exception exc) {
        C0029Cc c0029Cc = this.a;
        c0029Cc.getClass();
        Log.w("cr_AppInstanceIdController", "App instance id error", exc);
        c0029Cc.c = null;
        c0029Cc.b.countDown();
    }
}
