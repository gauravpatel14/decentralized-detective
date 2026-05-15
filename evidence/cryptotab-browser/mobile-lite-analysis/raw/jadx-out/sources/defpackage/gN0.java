package defpackage;

import android.media.MediaDrm;
import android.util.Log;
import java.util.Locale;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gN0 implements MediaDrm.OnEventListener {
    public final /* synthetic */ MediaDrmBridge a;

    public gN0(MediaDrmBridge mediaDrmBridge) {
        this.a = mediaDrmBridge;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        if (bArr == null) {
            if (i != 1) {
                Log.e("cr_media", "EventListener: No session for event " + i + ".");
                return;
            }
            return;
        }
        MediaDrmBridge mediaDrmBridge = this.a;
        C1382rN0 c1382rN0B = MediaDrmBridge.b(mediaDrmBridge, bArr);
        if (c1382rN0B == null) {
            Log.w("cr_media", "EventListener: Invalid session " + C1382rN0.a(bArr));
            return;
        }
        C1442sN0 c1442sN0A = mediaDrmBridge.g.a(c1382rN0B);
        if (c1442sN0A == null) {
            Log.w("cr_media", "EventListener: No info for session " + c1382rN0B);
            return;
        }
        if (i == 2) {
            int i3 = AbstractC1872zv.a;
            MediaDrm.KeyRequest keyRequestF = this.a.f(c1382rN0B, bArr2, c1442sN0A.b, c1442sN0A.c, null);
            if (keyRequestF != null) {
                mediaDrmBridge.o(c1382rN0B, keyRequestF);
                return;
            } else {
                Log.e("cr_media", "EventListener: getKeyRequest failed.");
                return;
            }
        }
        if (i == 3) {
            int i4 = AbstractC1872zv.a;
            return;
        }
        if (i != 4) {
            Log.w("cr_media", String.format(Locale.US, AbstractC1214oR1.a(i, "Ignoring MediaDrm event %d for session %s"), c1382rN0B));
            return;
        }
        int i5 = AbstractC1872zv.a;
        MediaDrm.KeyRequest keyRequestF2 = this.a.f(c1382rN0B, bArr2, c1442sN0A.b, c1442sN0A.c, null);
        if (keyRequestF2 != null) {
            mediaDrmBridge.o(c1382rN0B, keyRequestF2);
        } else {
            Log.e("cr_media", "EventListener: getKeyRequest failed.");
        }
    }
}
