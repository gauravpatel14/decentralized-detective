package defpackage;

/* JADX INFO: renamed from: sS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1449sS2 implements InterfaceC0452cD2 {
    public final InterfaceC0452cD2 a;
    public final InterfaceC0452cD2 b;
    public final C0905jW2 c;

    public C1449sS2(InterfaceC0452cD2 interfaceC0452cD2, InterfaceC0452cD2 interfaceC0452cD22, C0905jW2 c0905jW2) {
        this.a = interfaceC0452cD2;
        this.b = interfaceC0452cD22;
        this.c = c0905jW2;
    }

    @Override // defpackage.InterfaceC0452cD2
    public final Object zza() {
        Object objZza = this.a.zza();
        return new LQ2((F13) objZza, this.c.a.a);
    }
}
