package defpackage;

import java.io.File;

/* JADX INFO: renamed from: o23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1187o23 implements BI2 {
    public final AC2 a;
    public final BI2 b;
    public final BI2 c;
    public final UC2 d;

    public C1187o23(AC2 ac2, BI2 bi2, BI2 bi22, UC2 uc2) {
        this.a = ac2;
        this.b = bi2;
        this.c = bi22;
        this.d = uc2;
    }

    @Override // defpackage.BI2
    public final Object zza() {
        return new C0219Sa0(this.a.a.a, (File) this.b.zza(), (Z13) this.c.zza(), QH2.a(this.d));
    }
}
