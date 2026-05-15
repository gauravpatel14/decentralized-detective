package defpackage;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: z41, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1815z41 {
    public boolean a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public Ik0 c;

    public AbstractC1815z41(boolean z) {
        this.a = z;
    }

    public abstract void b();

    /* JADX WARN: Type inference failed for: r1v1, types: [Ik0, hk0] */
    public final void e(boolean z) {
        this.a = z;
        ?? r1 = this.c;
        if (r1 != 0) {
            r1.c();
        }
    }

    public void a() {
    }

    public void c(C0375am c0375am) {
    }

    public void d(C0375am c0375am) {
    }
}
