package defpackage;

import J.N;
import android.util.Log;
import java.util.Locale;
import java.util.UUID;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class hN0 implements Runnable {
    public final /* synthetic */ C1382rN0 t;
    public final /* synthetic */ byte[] u;
    public final /* synthetic */ long v;
    public final /* synthetic */ iN0 w;

    public hN0(iN0 in0, C1382rN0 c1382rN0, byte[] bArr, long j) {
        this.w = in0;
        this.t = c1382rN0;
        this.u = bArr;
        this.v = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1382rN0 c1382rN0 = this.t;
        if (c1382rN0 == null) {
            Log.w("cr_media", "ExpirationUpdate: Unknown session " + C1382rN0.a(this.u));
            return;
        }
        long j = this.v;
        Log.i("cr_media", String.format(Locale.US, "ExpirationUpdate(%s): %tF %tT", c1382rN0, Long.valueOf(j), Long.valueOf(j)));
        MediaDrmBridge mediaDrmBridge = this.w.a;
        UUID uuid = MediaDrmBridge.l;
        if (mediaDrmBridge.j()) {
            N._V_JJOO(7, mediaDrmBridge.c, this.v, mediaDrmBridge, c1382rN0.a);
        }
    }
}
