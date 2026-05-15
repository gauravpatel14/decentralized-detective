package defpackage;

/* JADX INFO: renamed from: mD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1071mD2 implements BI2 {
    public final C1715xC2 a;

    public C1071mD2(C1715xC2 c1715xC2) {
        this.a = c1715xC2;
    }

    @Override // defpackage.BI2
    public final Object zza() {
        C1189o33 c1189o33B = C1189o33.b(this.a.a);
        if (c1189o33B != null) {
            return c1189o33B;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
