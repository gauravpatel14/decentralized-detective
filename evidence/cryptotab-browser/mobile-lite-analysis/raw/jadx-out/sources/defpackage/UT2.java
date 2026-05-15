package defpackage;

import java.io.IOException;
import java.util.HashSet;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UT2 implements InterfaceC0967kW2 {
    public final /* synthetic */ HashSet a;
    public final /* synthetic */ GF2 b;
    public final /* synthetic */ VY2 c;

    public UT2(VY2 vy2, HashSet hashSet, GF2 gf2) {
        this.c = vy2;
        this.a = hashSet;
        this.b = gf2;
    }

    @Override // defpackage.InterfaceC0967kW2
    public final void a(ZipFile zipFile, HashSet hashSet) throws IOException {
        HashSet hashSet2 = new HashSet();
        GF2 gf2 = this.b;
        this.c.c(gf2, hashSet, new C0845iV2(hashSet2, gf2, zipFile));
        this.a.addAll(hashSet2);
    }
}
