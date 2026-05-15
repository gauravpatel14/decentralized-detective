package defpackage;

import android.media.MediaDrm;
import android.media.MediaDrm$OnSessionLostStateListener;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: renamed from: pN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1266pN0 implements MediaDrm$OnSessionLostStateListener {
    public final /* synthetic */ MediaDrmBridge a;

    public C1266pN0(MediaDrmBridge mediaDrmBridge) {
        this.a = mediaDrmBridge;
    }

    public final void onSessionLostState(MediaDrm mediaDrm, byte[] bArr) {
        C1382rN0 c1382rN0B = MediaDrmBridge.b(this.a, bArr);
        MediaDrmBridge.a(this.a, c1382rN0B, new RunnableC1206oN0(this, c1382rN0B, bArr));
    }
}
