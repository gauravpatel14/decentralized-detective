package defpackage;

/* JADX INFO: renamed from: hV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0780hV2 implements InterfaceC0452cD2 {
    public final InterfaceC0452cD2 a;

    public C0780hV2(InterfaceC0452cD2 interfaceC0452cD2) {
        this.a = interfaceC0452cD2;
    }

    @Override // defpackage.InterfaceC0452cD2
    public final Object zza() {
        LQ2 lq2 = (LQ2) this.a.zza();
        if (lq2 != null) {
            return lq2;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
