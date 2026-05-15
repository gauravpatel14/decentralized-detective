package defpackage;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: fh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0664fh0 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ C0599eh0 d;
    public final /* synthetic */ int e;

    public /* synthetic */ CallableC0664fh0(String str, Context context, C0599eh0 c0599eh0, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = context;
        this.d = c0599eh0;
        this.e = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.a) {
            case 0:
                return AbstractC0861ih0.a(this.b, this.c, this.d, this.e);
            default:
                try {
                    return AbstractC0861ih0.a(this.b, this.c, this.d, this.e);
                } catch (Throwable unused) {
                    return new C0795hh0(-3);
                }
        }
    }
}
