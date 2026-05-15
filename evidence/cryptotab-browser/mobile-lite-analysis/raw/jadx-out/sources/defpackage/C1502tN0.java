package defpackage;

import J.N;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.chromium.media.MediaDrmStorageBridge$PersistentInfo;

/* JADX INFO: renamed from: tN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1502tN0 {
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final C1557uN0 c;

    public C1502tN0(C1557uN0 c1557uN0) {
        this.c = c1557uN0;
    }

    public final C1442sN0 a(C1382rN0 c1382rN0) {
        return (C1442sN0) this.a.get(ByteBuffer.wrap(c1382rN0.a));
    }

    public final void b(C1382rN0 c1382rN0, byte[] bArr, C1022lN0 c1022lN0) {
        c1382rN0.c = bArr;
        C1442sN0 c1442sN0A = a(c1382rN0);
        C1382rN0 c1382rN02 = c1442sN0A.a;
        MediaDrmStorageBridge$PersistentInfo mediaDrmStorageBridge$PersistentInfo = new MediaDrmStorageBridge$PersistentInfo(c1382rN02.a, c1382rN02.c, c1442sN0A.b, c1442sN0A.c);
        C1557uN0 c1557uN0 = this.c;
        if (c1557uN0.a()) {
            N._V_JOOO(55, c1557uN0.a, c1557uN0, mediaDrmStorageBridge$PersistentInfo, c1022lN0);
        } else {
            c1022lN0.a0(Boolean.FALSE);
        }
    }
}
