package defpackage;

import J.N;
import android.media.NotProvisionedException;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.chromium.base.Callback;
import org.chromium.media.MediaDrmBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dN0 implements Callback {
    public final /* synthetic */ int t;
    public final /* synthetic */ long u;
    public final /* synthetic */ MediaDrmBridge v;

    public /* synthetic */ dN0(MediaDrmBridge mediaDrmBridge, long j, int i) {
        this.t = i;
        this.v = mediaDrmBridge;
        this.u = j;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        long j = this.u;
        switch (this.t) {
            case 0:
                C1382rN0 c1382rN0 = (C1382rN0) obj;
                MediaDrmBridge mediaDrmBridge = this.v;
                if (c1382rN0 == null) {
                    UUID uuid = MediaDrmBridge.l;
                    mediaDrmBridge.getClass();
                    byte[] bArr = new byte[0];
                    mediaDrmBridge.n(j, new C1382rN0(bArr, bArr, null));
                } else {
                    long j2 = this.u;
                    UUID uuid2 = MediaDrmBridge.l;
                    mediaDrmBridge.getClass();
                    Log.i("cr_media", "loadSession(" + c1382rN0 + ")");
                    try {
                        byte[] bArrP = mediaDrmBridge.p();
                        if (bArrP != null) {
                            C1502tN0 c1502tN0 = mediaDrmBridge.g;
                            C1442sN0 c1442sN0A = c1502tN0.a(c1382rN0);
                            c1382rN0.b = bArrP;
                            c1502tN0.b.put(ByteBuffer.wrap(bArrP), c1442sN0A);
                            C1442sN0 c1442sN0A2 = mediaDrmBridge.g.a(c1382rN0);
                            if (c1442sN0A2 == null) {
                                mediaDrmBridge.m(j2, 1100002L, "Internal error: No info for session: " + c1382rN0);
                            } else if (c1442sN0A2.c != 3) {
                                mediaDrmBridge.k = new nN0(c1382rN0);
                                mediaDrmBridge.a.restoreKeys(c1382rN0.b, c1382rN0.c);
                                mediaDrmBridge.n(j2, c1382rN0);
                                ArrayList arrayList = mediaDrmBridge.k.b;
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((Runnable) it.next()).run();
                                }
                                arrayList.clear();
                                mediaDrmBridge.k = null;
                            } else {
                                Log.w("cr_media", "Persistent license is waiting for release ack.");
                                mediaDrmBridge.n(j2, c1382rN0);
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new MediaDrmBridge.KeyStatus(1, MediaDrmBridge.m));
                                Object[] array = arrayList2.toArray();
                                if (mediaDrmBridge.j()) {
                                    N._V_ZZJOOO(2, false, true, mediaDrmBridge.c, mediaDrmBridge, c1382rN0.a, array);
                                }
                            }
                        } else {
                            mediaDrmBridge.m(j2, 1100005L, "Failed to open session to load license.");
                        }
                    } catch (NotProvisionedException e) {
                        mediaDrmBridge.l(c1382rN0, j2, e);
                        return;
                    } catch (IllegalStateException e2) {
                        mediaDrmBridge.l(c1382rN0, j2, e2);
                        return;
                    }
                }
                break;
            default:
                if (!((Boolean) obj).booleanValue()) {
                    Log.w("cr_media", "Failed to clear persistent storage for non-exist license");
                }
                UUID uuid3 = MediaDrmBridge.l;
                MediaDrmBridge mediaDrmBridge2 = this.v;
                mediaDrmBridge2.getClass();
                byte[] bArr2 = new byte[0];
                mediaDrmBridge2.n(j, new C1382rN0(bArr2, bArr2, null));
                break;
        }
    }
}
