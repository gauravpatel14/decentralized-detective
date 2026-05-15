package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CO2 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final /* synthetic */ WO2 d;

    public CO2(WO2 wo2, int i, boolean z, boolean z2) {
        this.d = wo2;
        this.a = i;
        this.b = z;
        this.c = z2;
    }

    public final void a(String str) {
        this.d.r(this.a, this.b, this.c, str, null, null, null);
    }

    public final void b(Object obj, String str) {
        this.d.r(this.a, this.b, this.c, str, obj, null, null);
    }

    public final void c(Object obj, Object obj2, String str) {
        this.d.r(this.a, this.b, this.c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.d.r(this.a, this.b, this.c, str, obj, obj2, obj3);
    }
}
