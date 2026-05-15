package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Wy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0280Wy2 implements GoogleApiClient.ConnectionCallbacks {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ StatusPendingResult u;
    public final /* synthetic */ zabe v;

    public C0280Wy2(zabe zabeVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.v = zabeVar;
        this.t = atomicReference;
        this.u = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.v.zam((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.t.get()), this.u, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
