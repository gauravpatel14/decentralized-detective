package defpackage;

import java.nio.ByteBuffer;
import org.chromium.base.Callback;
import org.chromium.media.MediaDrmStorageBridge$PersistentInfo;

/* JADX INFO: renamed from: qN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1327qN0 implements Callback {
    public final /* synthetic */ dN0 t;
    public final /* synthetic */ C1502tN0 u;

    public C1327qN0(C1502tN0 c1502tN0, dN0 dn0) {
        this.u = c1502tN0;
        this.t = dn0;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        MediaDrmStorageBridge$PersistentInfo mediaDrmStorageBridge$PersistentInfo = (MediaDrmStorageBridge$PersistentInfo) obj;
        dN0 dn0 = this.t;
        if (mediaDrmStorageBridge$PersistentInfo == null) {
            dn0.a0(null);
            return;
        }
        C1382rN0 c1382rN0 = new C1382rN0(mediaDrmStorageBridge$PersistentInfo.emeId(), null, mediaDrmStorageBridge$PersistentInfo.keySetId());
        String strMimeType = mediaDrmStorageBridge$PersistentInfo.mimeType();
        int iKeyType = mediaDrmStorageBridge$PersistentInfo.keyType();
        if (iKeyType != 2 && iKeyType != 3) {
            iKeyType = 2;
        }
        this.u.a.put(ByteBuffer.wrap(mediaDrmStorageBridge$PersistentInfo.emeId()), new C1442sN0(c1382rN0, strMimeType, iKeyType));
        dn0.a0(c1382rN0);
    }
}
