package defpackage;

import android.content.Context;
import android.os.UserManager;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RV implements Kn0, Ln0 {
    public static final OV f = new OV();
    public final PV a;
    public final Context b;
    public final InterfaceC0988kn1 c;
    public final Set d;
    public final ThreadPoolExecutor e;

    public RV(Context context, String str, Set set, InterfaceC0988kn1 interfaceC0988kn1) {
        PV pv = new PV(context, str);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f);
        this.a = pv;
        this.d = set;
        this.e = threadPoolExecutor;
        this.c = interfaceC0988kn1;
        this.b = context;
    }

    public final C0939k33 a() {
        if (!((UserManager) this.b.getSystemService(UserManager.class)).isUserUnlocked()) {
            return Y62.e("");
        }
        return Y62.c(this.e, new QV(this, 1));
    }

    public final void b() {
        if (this.d.size() <= 0) {
            Y62.e(null);
        } else if (!((UserManager) this.b.getSystemService(UserManager.class)).isUserUnlocked()) {
            Y62.e(null);
        } else {
            Y62.c(this.e, new QV(this, 0));
        }
    }
}
