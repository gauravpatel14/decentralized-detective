package defpackage;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: uS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1561uS2 implements InterfaceC0967kW2 {
    public final /* synthetic */ GF2 a;
    public final /* synthetic */ HashSet b;
    public final /* synthetic */ AtomicBoolean c;
    public final /* synthetic */ VY2 d;

    public C1561uS2(VY2 vy2, GF2 gf2, HashSet hashSet, AtomicBoolean atomicBoolean) {
        this.d = vy2;
        this.a = gf2;
        this.b = hashSet;
        this.c = atomicBoolean;
    }

    @Override // defpackage.InterfaceC0967kW2
    public final void a(ZipFile zipFile, HashSet hashSet) throws IOException {
        this.d.c(this.a, hashSet, new AQ2(this));
    }
}
