package defpackage;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: Fz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0078Fz2 implements xN {
    @Override // defpackage.xN
    public final /* bridge */ /* synthetic */ Object a(G62 g62) throws ApiException {
        if (((Boolean) g62.h()).booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }
}
