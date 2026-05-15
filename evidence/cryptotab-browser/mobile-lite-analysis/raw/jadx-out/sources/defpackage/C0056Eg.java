package defpackage;

/* JADX INFO: renamed from: Eg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0056Eg {
    public final Object a = new Object();
    public int b = -1;
    public final /* synthetic */ AbstractC0066Fg c;

    public C0056Eg(AbstractC0066Fg abstractC0066Fg) {
        this.c = abstractC0066Fg;
    }

    public final void a(int i, boolean z) {
        if (i < 0 || i > 4) {
            return;
        }
        synchronized (this.a) {
            this.c.h(i, z);
        }
    }
}
