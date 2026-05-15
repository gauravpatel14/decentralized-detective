package defpackage;

import J.N;
import android.media.MediaDrm;
import java.util.UUID;
import org.chromium.base.Callback;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: renamed from: eN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0575eN0 implements Callback {
    public final /* synthetic */ long t;
    public final /* synthetic */ C1382rN0 u;
    public final /* synthetic */ C1442sN0 v;
    public final /* synthetic */ MediaDrmBridge w;

    public C0575eN0(MediaDrmBridge mediaDrmBridge, long j, C1382rN0 c1382rN0, C1442sN0 c1442sN0) {
        this.w = mediaDrmBridge;
        this.t = j;
        this.u = c1382rN0;
        this.v = c1442sN0;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            UUID uuid = MediaDrmBridge.l;
            this.w.m(this.t, 1100008L, "Fail to update persistent storage");
            return;
        }
        C1442sN0 c1442sN0 = this.v;
        UUID uuid2 = MediaDrmBridge.l;
        C1382rN0 c1382rN0 = this.u;
        MediaDrmBridge mediaDrmBridge = this.w;
        MediaDrm.KeyRequest keyRequestF = mediaDrmBridge.f(c1382rN0, null, c1442sN0.b, 3, null);
        long j = this.t;
        if (keyRequestF == null) {
            mediaDrmBridge.m(j, 1100011L, "Fail to generate key release request");
            return;
        }
        if (mediaDrmBridge.j()) {
            N._V_JJO(12, mediaDrmBridge.c, j, mediaDrmBridge);
        }
        mediaDrmBridge.o(c1382rN0, keyRequestF);
    }
}
