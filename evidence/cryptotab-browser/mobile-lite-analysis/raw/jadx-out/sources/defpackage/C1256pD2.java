package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ReconnectionService;

/* JADX INFO: renamed from: pD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1256pD2 {
    public final Context a;
    public final CastOptions b;
    public final HandlerC0957kO2 c;
    public final LD2 d;

    /* JADX WARN: Type inference failed for: r1v2, types: [LD2] */
    public C1256pD2(Context context, CastOptions castOptions, V23 v23) {
        this.a = context;
        this.b = castOptions;
        new C1538u33(context);
        new C1538u33(context);
        this.c = new HandlerC0957kO2(Looper.getMainLooper());
        this.d = new Runnable(this) { // from class: LD2
            public final C1256pD2 t;

            {
                this.t = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C1256pD2 c1256pD2 = this.t;
                if (c1256pD2.b.y) {
                    c1256pD2.c.removeCallbacks(c1256pD2.d);
                    Context context2 = c1256pD2.a;
                    Intent intent = new Intent(context2, (Class<?>) ReconnectionService.class);
                    intent.setPackage(context2.getPackageName());
                    try {
                        context2.startService(intent);
                    } catch (IllegalStateException unused) {
                    }
                }
            }
        };
    }
}
