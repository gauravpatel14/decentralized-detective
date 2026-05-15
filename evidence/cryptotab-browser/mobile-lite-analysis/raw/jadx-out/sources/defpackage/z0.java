package defpackage;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import org.chromium.base.ThreadUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends ContentObserver {
    public final Runnable a;

    public z0(Handler handler, Runnable runnable) {
        super(handler);
        this.a = runnable;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        onChange(z, null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        ThreadUtils.b().post(this.a);
    }
}
