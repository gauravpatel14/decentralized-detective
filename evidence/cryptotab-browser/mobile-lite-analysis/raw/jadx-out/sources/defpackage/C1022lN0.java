package defpackage;

import J.N;
import android.util.Log;
import java.util.UUID;
import org.chromium.base.Callback;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: renamed from: lN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1022lN0 implements Callback {
    public final C1382rN0 t;
    public final long u;
    public final boolean v;
    public final /* synthetic */ MediaDrmBridge w;

    public C1022lN0(MediaDrmBridge mediaDrmBridge, C1382rN0 c1382rN0, long j, boolean z) {
        this.w = mediaDrmBridge;
        this.t = c1382rN0;
        this.u = j;
        this.v = z;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void a0(Boolean bool) {
        if (!bool.booleanValue()) {
            UUID uuid = MediaDrmBridge.l;
            this.w.m(this.u, 1100010L, "failed to update key after response accepted");
            return;
        }
        Log.i("cr_media", "Key successfully " + (this.v ? "released" : "added") + " for session " + this.t);
        UUID uuid2 = MediaDrmBridge.l;
        MediaDrmBridge mediaDrmBridge = this.w;
        if (mediaDrmBridge.j()) {
            N._V_JJO(12, mediaDrmBridge.c, this.u, mediaDrmBridge);
        }
    }
}
