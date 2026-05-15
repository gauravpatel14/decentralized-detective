package defpackage;

/* JADX INFO: renamed from: uD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1544uD2 implements BI2 {
    public final BI2 a;

    public C1544uD2(BI2 bi2) {
        this.a = bi2;
    }

    @Override // defpackage.BI2
    public final Object zza() {
        C1222oX2 c1222oX2 = (C1222oX2) this.a.zza();
        if (c1222oX2 != null) {
            return c1222oX2;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
