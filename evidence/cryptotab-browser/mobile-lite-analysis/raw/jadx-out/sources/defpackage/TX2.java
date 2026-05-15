package defpackage;

import android.app.Service;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TX2 {
    public final Context a;

    public TX2(Service service) {
        Preconditions.checkNotNull(service);
        Context applicationContext = service.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.a = applicationContext;
    }
}
