package defpackage;

import android.os.Looper;

/* JADX INFO: renamed from: gW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0714gW0 extends AbstractC1493tH0 {
    @Override // defpackage.AbstractC1493tH0
    public void h(Object obj) {
        AbstractC1493tH0.a("setValue");
        this.g++;
        this.e = obj;
        c(null);
    }

    public final void i(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == AbstractC1493tH0.k;
            this.f = obj;
        }
        if (z) {
            le leVarA = le.a();
            RunnableC1261pH0 runnableC1261pH0 = this.j;
            C1566uW c1566uW = leVarA.a;
            if (c1566uW.c == null) {
                synchronized (c1566uW.a) {
                    try {
                        if (c1566uW.c == null) {
                            c1566uW.c = C1566uW.a(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            c1566uW.c.post(runnableC1261pH0);
        }
    }
}
