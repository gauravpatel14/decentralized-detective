package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: rq2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1411rq2 {
    public File a = null;
    public final /* synthetic */ Context b;

    public C1411rq2(Context context) {
        this.b = context;
    }

    public final File a() {
        if (this.a == null) {
            this.a = new File(this.b.getCacheDir(), "volley");
        }
        return this.a;
    }
}
