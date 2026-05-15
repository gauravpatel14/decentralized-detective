package defpackage;

import java.io.File;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AQ2 implements InterfaceC1157nX2 {
    public final /* synthetic */ C1561uS2 a;

    public AQ2(C1561uS2 c1561uS2) {
        this.a = c1561uS2;
    }

    @Override // defpackage.InterfaceC1157nX2
    public final void a(C1281pY2 c1281pY2, File file, boolean z) {
        C1561uS2 c1561uS2 = this.a;
        c1561uS2.b.add(file);
        if (z) {
            return;
        }
        c1561uS2.c.set(false);
    }
}
