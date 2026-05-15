package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oD0 implements U41, Q41 {
    public final /* synthetic */ qD0 a;

    @Override // defpackage.U41
    public void a(Object obj) {
        qD0 qd0 = this.a;
        qd0.getClass();
        qd0.d = ((Integer) obj).intValue();
    }

    @Override // defpackage.Q41
    public void d(Exception exc) {
        qD0 qd0 = this.a;
        Log.i("cr_LanguageInstaller", "Language Split Failure:", exc);
        qd0.b.a(false);
        qd0.c.c(qd0.a);
        qd0.b = null;
        qd0.d = 0;
        qd0.e = false;
    }
}
