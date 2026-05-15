package defpackage;

/* JADX INFO: renamed from: zC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1822zC2 implements InterfaceC0452cD2 {
    public static final Object c = new Object();
    public volatile InterfaceC0452cD2 a;
    public volatile Object b;

    public static InterfaceC0452cD2 a(InterfaceC0452cD2 interfaceC0452cD2) {
        if (interfaceC0452cD2 instanceof C1822zC2) {
            return interfaceC0452cD2;
        }
        C1822zC2 c1822zC2 = new C1822zC2();
        c1822zC2.b = c;
        c1822zC2.a = interfaceC0452cD2;
        return c1822zC2;
    }

    @Override // defpackage.InterfaceC0452cD2
    public final Object zza() {
        Object objZza = this.b;
        Object obj = c;
        if (objZza == obj) {
            synchronized (this) {
                try {
                    objZza = this.b;
                    if (objZza == obj) {
                        objZza = this.a.zza();
                        Object obj2 = this.b;
                        if (obj2 != obj && obj2 != objZza) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZza + ". This is likely due to a circular dependency.");
                        }
                        this.b = objZza;
                        this.a = null;
                    }
                } finally {
                }
            }
        }
        return objZza;
    }
}
