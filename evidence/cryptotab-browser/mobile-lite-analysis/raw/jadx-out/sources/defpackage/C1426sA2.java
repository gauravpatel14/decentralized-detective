package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: sA2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1426sA2 {
    public final int a;
    public final ConnectionResult b;

    public C1426sA2(ConnectionResult connectionResult, int i) {
        Preconditions.checkNotNull(connectionResult);
        this.b = connectionResult;
        this.a = i;
    }
}
