package defpackage;

import android.media.MediaDrm;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class iN0 implements MediaDrm.OnExpirationUpdateListener {
    public final /* synthetic */ MediaDrmBridge a;

    public iN0(MediaDrmBridge mediaDrmBridge) {
        this.a = mediaDrmBridge;
    }

    @Override // android.media.MediaDrm.OnExpirationUpdateListener
    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j) {
        MediaDrmBridge mediaDrmBridge = this.a;
        C1382rN0 c1382rN0B = MediaDrmBridge.b(mediaDrmBridge, bArr);
        MediaDrmBridge.a(mediaDrmBridge, c1382rN0B, new hN0(this, c1382rN0B, bArr, j));
    }
}
