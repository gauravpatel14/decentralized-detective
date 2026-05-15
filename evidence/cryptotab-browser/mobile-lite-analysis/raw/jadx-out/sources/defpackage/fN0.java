package defpackage;

import android.util.Log;
import java.util.UUID;
import org.chromium.base.Callback;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class fN0 implements Callback {
    public final /* synthetic */ MediaDrmBridge t;

    public fN0(MediaDrmBridge mediaDrmBridge) {
        this.t = mediaDrmBridge;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        MediaDrmBridge mediaDrmBridge = this.t;
        if (zBooleanValue) {
            UUID uuid = MediaDrmBridge.l;
            mediaDrmBridge.d();
        } else {
            Log.e("cr_media", "Failed to initialize storage for origin");
            UUID uuid2 = MediaDrmBridge.l;
            mediaDrmBridge.r();
        }
    }
}
