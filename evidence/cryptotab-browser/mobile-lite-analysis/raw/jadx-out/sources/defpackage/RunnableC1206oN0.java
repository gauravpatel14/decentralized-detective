package defpackage;

import J.N;
import android.util.Log;
import java.util.Objects;
import java.util.UUID;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: renamed from: oN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1206oN0 implements Runnable {
    public final /* synthetic */ C1382rN0 t;
    public final /* synthetic */ byte[] u;
    public final /* synthetic */ C1266pN0 v;

    public RunnableC1206oN0(C1266pN0 c1266pN0, C1382rN0 c1382rN0, byte[] bArr) {
        this.v = c1266pN0;
        this.t = c1382rN0;
        this.u = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1382rN0 c1382rN0 = this.t;
        if (c1382rN0 == null) {
            Log.w("cr_media", "SessionLost: Unknown session " + C1382rN0.a(this.u));
            return;
        }
        Objects.toString(c1382rN0);
        int i = AbstractC1872zv.a;
        MediaDrmBridge mediaDrmBridge = this.v.a;
        UUID uuid = MediaDrmBridge.l;
        if (mediaDrmBridge.j()) {
            N._V_JOO(113, mediaDrmBridge.c, mediaDrmBridge, c1382rN0.a);
        }
    }
}
