package defpackage;

import J.N;
import android.media.MediaDrm;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: renamed from: jN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0893jN0 implements Runnable {
    public final /* synthetic */ C1382rN0 t;
    public final /* synthetic */ byte[] u;
    public final /* synthetic */ boolean v;
    public final /* synthetic */ List w;
    public final /* synthetic */ C0954kN0 x;

    public RunnableC0893jN0(C0954kN0 c0954kN0, C1382rN0 c1382rN0, byte[] bArr, boolean z, List list) {
        this.x = c0954kN0;
        this.t = c1382rN0;
        this.u = bArr;
        this.v = z;
        this.w = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1382rN0 c1382rN0 = this.t;
        if (c1382rN0 == null) {
            Log.w("cr_media", "KeyStatusChange: Unknown session " + C1382rN0.a(this.u));
            return;
        }
        C0954kN0 c0954kN0 = this.x;
        C1442sN0 c1442sN0A = c0954kN0.a.g.a(c1382rN0);
        if (c1442sN0A == null) {
            Log.w("cr_media", "KeyStatusChange: No info for session " + c1382rN0);
            return;
        }
        boolean z = c1442sN0A.c == 3;
        StringBuilder sb = new StringBuilder("KeysStatusChange(");
        sb.append(c1382rN0);
        sb.append("): ");
        boolean z2 = this.v;
        sb.append(z2);
        Log.i("cr_media", sb.toString());
        ArrayList arrayList = new ArrayList();
        for (MediaDrm.KeyStatus keyStatus : this.w) {
            arrayList.add(new MediaDrmBridge.KeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
        }
        Object[] array = arrayList.toArray();
        MediaDrmBridge mediaDrmBridge = c0954kN0.a;
        if (mediaDrmBridge.j()) {
            N._V_ZZJOOO(2, z2, z, mediaDrmBridge.c, mediaDrmBridge, c1382rN0.a, array);
        }
    }
}
