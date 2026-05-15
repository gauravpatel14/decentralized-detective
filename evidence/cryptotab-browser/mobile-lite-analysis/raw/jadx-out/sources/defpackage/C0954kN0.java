package defpackage;

import android.media.MediaDrm;
import java.util.List;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: renamed from: kN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0954kN0 implements MediaDrm.OnKeyStatusChangeListener {
    public final /* synthetic */ MediaDrmBridge a;

    public C0954kN0(MediaDrmBridge mediaDrmBridge) {
        this.a = mediaDrmBridge;
    }

    @Override // android.media.MediaDrm.OnKeyStatusChangeListener
    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
        MediaDrmBridge mediaDrmBridge = this.a;
        C1382rN0 c1382rN0B = MediaDrmBridge.b(mediaDrmBridge, bArr);
        MediaDrmBridge.a(mediaDrmBridge, c1382rN0B, new RunnableC0893jN0(this, c1382rN0B, bArr, z, list));
    }
}
