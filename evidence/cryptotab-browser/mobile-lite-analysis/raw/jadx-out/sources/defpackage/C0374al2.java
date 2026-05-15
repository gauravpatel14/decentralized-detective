package defpackage;

import android.app.Activity;
import android.util.Log;
import com.google.android.play.core.install.InstallException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: al2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0374al2 {
    public static final long c = TimeUnit.MINUTES.toMillis(5);
    public static int d = 1;
    public static long e;
    public static LQ2 f;
    public Jd a;
    public Zk2 b;

    public final void a(Activity activity, int i, int i2) {
        if (i == 9100 && f != null) {
            long j = c;
            if (i2 == -1) {
                int i3 = AbstractC1872zv.a;
                LQ2 lq2 = f;
                String packageName = lq2.b.getPackageName();
                F13 f13 = lq2.a;
                n33 n33Var = f13.a;
                if (n33Var == null) {
                    Object[] objArr = {-9};
                    C1224oY2 c1224oY2 = F13.e;
                    c1224oY2.getClass();
                    if (Log.isLoggable("PlayCore", 6)) {
                        Log.e("PlayCore", C1224oY2.c(c1224oY2.a, "onError(%d)", objArr));
                    }
                    Y62.d(new InstallException(-9));
                } else {
                    F13.e.b("completeUpdate(%s)", packageName);
                    H62 h62 = new H62();
                    n33Var.a().post(new C0748h13(n33Var, h62, h62, new TY2(h62, h62, packageName, f13)));
                }
                d = 3;
                e = System.currentTimeMillis() + j;
                return;
            }
            if (i2 != 0) {
                d = 3;
                e = System.currentTimeMillis() + j;
                return;
            }
            Jd jd = lQ.a;
            Jd jd2 = this.a;
            if (jd2 == null) {
                jd.getClass();
            } else {
                int[] iArr = jd.a;
                int length = iArr.length;
                if (iArr.length == jd2.a.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        int iCompare = Integer.compare(jd.a[i4], jd2.a[i4]);
                        if (iCompare == 0) {
                            i4++;
                        } else if (iCompare < 0) {
                            int i5 = AbstractC1872zv.a;
                            b(activity);
                            return;
                        }
                    }
                }
            }
            int i6 = AbstractC1872zv.a;
            d = 3;
            e = System.currentTimeMillis() + j;
        }
    }

    public final void b(final Activity activity) {
        C0939k33 c0939k33D;
        this.b = null;
        LQ2 lq2 = f;
        String packageName = lq2.b.getPackageName();
        F13 f13 = lq2.a;
        n33 n33Var = f13.a;
        if (n33Var == null) {
            Object[] objArr = {-9};
            C1224oY2 c1224oY2 = F13.e;
            c1224oY2.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", C1224oY2.c(c1224oY2.a, "onError(%d)", objArr));
            }
            c0939k33D = Y62.d(new InstallException(-9));
        } else {
            F13.e.b("requestUpdateInfo(%s)", packageName);
            H62 h62 = new H62();
            n33Var.a().post(new C0748h13(n33Var, h62, h62, new C1158nY2(h62, h62, packageName, f13)));
            c0939k33D = h62.a;
        }
        c0939k33D.d(new U41() { // from class: Wk2
            @Override // defpackage.U41
            public final void a(Object obj) {
                Gd gd = (Gd) obj;
                C0374al2 c0374al2 = this.a;
                c0374al2.getClass();
                int i = gd.a;
                int i2 = AbstractC1872zv.a;
                if (i != 2 && i != 3) {
                    C0374al2.d = 1;
                    return;
                }
                Zk2 zk2 = new Zk2(c0374al2, gd, activity);
                c0374al2.b = zk2;
                if (c0374al2.a != null) {
                    zk2.run();
                }
            }
        });
    }
}
