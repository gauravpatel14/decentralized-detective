package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: mP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1087mP0 {
    public static bm0 c;
    public final Context a;
    public final ArrayList b = new ArrayList();

    public C1087mP0(Context context) {
        this.a = context;
    }

    public static void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    public static bm0 c() {
        bm0 bm0Var = c;
        if (bm0Var != null) {
            return bm0Var;
        }
        throw new IllegalStateException("getGlobalRouter cannot be called when sGlobal is null");
    }

    public static C1087mP0 d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        b();
        if (c == null) {
            c = new bm0(context.getApplicationContext());
        }
        ArrayList arrayList = c.g;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                C1087mP0 c1087mP0 = new C1087mP0(context);
                arrayList.add(new WeakReference(c1087mP0));
                return c1087mP0;
            }
            C1087mP0 c1087mP02 = (C1087mP0) ((WeakReference) arrayList.get(size)).get();
            if (c1087mP02 == null) {
                arrayList.remove(size);
            } else if (c1087mP02.a == context) {
                return c1087mP02;
            }
        }
    }

    public static MediaSessionCompat$Token e() {
        bm0 bm0Var = c;
        if (bm0Var == null) {
            return null;
        }
        Zl0 zl0 = bm0Var.z;
        if (zl0 != null) {
            CP0 cp0 = zl0.a;
            if (cp0 != null) {
                return cp0.a.c;
            }
            return null;
        }
        CP0 cp02 = bm0Var.A;
        if (cp02 != null) {
            return cp02.a.c;
        }
        return null;
    }

    public static ArrayList f() {
        b();
        return c().h;
    }

    public static C0838iP0 g() {
        b();
        return c().e();
    }

    public static void i(C0838iP0 c0838iP0) {
        if (c0838iP0 == null) {
            throw new IllegalArgumentException("route must not be null");
        }
        b();
        c().g(c0838iP0, 3, true);
    }

    public final void a(C0468cP0 c0468cP0, dP0 dp0, int i) {
        eP0 ep0;
        C0468cP0 c0468cP02;
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (dp0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        b();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((eP0) arrayList.get(i2)).b == dp0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            ep0 = new eP0(this, dp0);
            arrayList.add(ep0);
        } else {
            ep0 = (eP0) arrayList.get(i2);
        }
        boolean z2 = true;
        if (i != ep0.d) {
            ep0.d = i;
            z = true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if ((i & 1) != 0) {
            z = true;
        }
        ep0.e = jElapsedRealtime;
        C0468cP0 c0468cP03 = ep0.c;
        c0468cP03.a();
        c0468cP0.a();
        if (c0468cP03.b.containsAll(c0468cP0.b)) {
            z2 = z;
        } else {
            C0468cP0 c0468cP04 = ep0.c;
            if (c0468cP04 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            c0468cP04.a();
            ArrayList<String> arrayList2 = !c0468cP04.b.isEmpty() ? new ArrayList<>(c0468cP04.b) : null;
            ArrayList<String> arrayListC = c0468cP0.c();
            if (!arrayListC.isEmpty()) {
                for (String str : arrayListC) {
                    if (str == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    if (!arrayList2.contains(str)) {
                        arrayList2.add(str);
                    }
                }
            }
            if (arrayList2 == null) {
                c0468cP02 = C0468cP0.c;
            } else {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("controlCategories", arrayList2);
                c0468cP02 = new C0468cP0(bundle, arrayList2);
            }
            ep0.c = c0468cP02;
        }
        if (z2) {
            c().i();
        }
    }

    public final void h(dP0 dp0) {
        if (dp0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        b();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (((eP0) arrayList.get(i)).b == dp0) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            arrayList.remove(i);
            c().i();
        }
    }
}
