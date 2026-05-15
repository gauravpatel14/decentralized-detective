package defpackage;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: renamed from: gJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0698gJ2 extends BaseImplementation.ApiMethodImpl {
    public AbstractC0698gJ2(GoogleApiClient googleApiClient) {
        super(AbstractC1874zy.a, googleApiClient);
    }

    public final void a() {
        setResult(createFailedResult(new Status(2001)));
    }
}
