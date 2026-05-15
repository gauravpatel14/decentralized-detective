package org.chromium.base;

import android.app.Activity;
import defpackage.AbstractC1440sM;
import defpackage.L21;
import defpackage.LP1;
import defpackage.M21;
import defpackage.Pd;
import defpackage.Qd;
import defpackage.Rd;
import defpackage.Sd;
import defpackage.Td;
import defpackage.Ud;
import defpackage.Wd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ApplicationStatus {
    public static final Map a = Collections.synchronizedMap(new HashMap());
    public static final Map b = Collections.synchronizedMap(new HashMap());
    public static int c = 0;
    public static Activity d;
    public static Pd e;
    public static M21 f;
    public static M21 g;
    public static M21 h;
    public static M21 i;

    public static ArrayList a() {
        ArrayList arrayList;
        Map map = a;
        synchronized (map) {
            arrayList = new ArrayList(map.keySet());
        }
        return arrayList;
    }

    public static int b(Activity activity) {
        Rd rd;
        if (activity == null || (rd = (Rd) a.get(activity)) == null) {
            return 6;
        }
        return rd.a;
    }

    public static int c(Activity activity) {
        LP1 lp1C = LP1.c();
        try {
            boolean z = AbstractC1440sM.a.getBoolean("cache_activity_taskid_enabled", false);
            lp1C.close();
            if (!z) {
                return activity.getTaskId();
            }
            Map map = b;
            if (!map.containsKey(activity)) {
                synchronized (map) {
                    map.put(activity, Integer.valueOf(activity.getTaskId()));
                }
            }
            return ((Integer) map.get(activity)).intValue();
        } catch (Throwable th) {
            try {
                lp1C.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static boolean d() {
        boolean z;
        synchronized (a) {
            z = c != 0;
        }
        return z;
    }

    public static boolean e(int i2) {
        int i3;
        for (Map.Entry entry : a.entrySet()) {
            if (c((Activity) entry.getKey()) == i2 && ((i3 = ((Rd) entry.getValue()).a) == 3 || i3 == 4)) {
                return true;
            }
        }
        return false;
    }

    public static void f(Activity activity, int i2) {
        Rd rd;
        M21 m21;
        M21 m212;
        int i3 = 2;
        if (d == null || i2 == 1 || i2 == 3 || i2 == 2) {
            d = activity;
        }
        int stateForApplication = getStateForApplication();
        boolean zE = e(c(activity));
        Map map = a;
        synchronized (map) {
            if (i2 == 1) {
                try {
                    Rd rd2 = new Rd();
                    rd2.a = 6;
                    rd2.b = new M21();
                    map.put(activity, rd2);
                } finally {
                }
            }
            rd = (Rd) map.get(activity);
            rd.a = i2;
            if (i2 == 6) {
                map.remove(activity);
                if (activity == d) {
                    d = null;
                }
            }
            Iterator it = map.values().iterator();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (it.hasNext()) {
                    int i4 = ((Rd) it.next()).a;
                    if (i4 != 4 && i4 != 5 && i4 != 6) {
                        i3 = 1;
                        break;
                    } else if (i4 == 4) {
                        z = true;
                    } else if (i4 == 5) {
                        z2 = true;
                    }
                } else if (!z) {
                    i3 = z2 ? 3 : 4;
                }
            }
            c = i3;
        }
        Iterator it2 = rd.b.iterator();
        while (true) {
            L21 l21 = (L21) it2;
            if (!l21.hasNext()) {
                break;
            } else {
                ((Sd) l21.next()).e(activity, i2);
            }
        }
        M21 m213 = f;
        if (m213 != null) {
            Iterator it3 = m213.iterator();
            while (true) {
                L21 l212 = (L21) it3;
                if (!l212.hasNext()) {
                    break;
                } else {
                    ((Sd) l212.next()).e(activity, i2);
                }
            }
        }
        boolean zE2 = e(c(activity));
        if (zE2 != zE && (m212 = i) != null) {
            Iterator it4 = m212.iterator();
            while (true) {
                L21 l213 = (L21) it4;
                if (!l213.hasNext()) {
                    break;
                } else {
                    ((Ud) l213.next()).a(c(activity), zE2);
                }
            }
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication && (m21 = g) != null) {
            Iterator it5 = m21.iterator();
            while (true) {
                L21 l214 = (L21) it5;
                if (!l214.hasNext()) {
                    break;
                } else {
                    ((Td) l214.next()).q(stateForApplication2);
                }
            }
        }
        Map map2 = b;
        synchronized (map2) {
            if (i2 == 6) {
                try {
                    map2.remove(activity);
                } finally {
                }
            }
        }
    }

    public static void g(Td td) {
        if (g == null) {
            g = new M21();
        }
        g.e(td);
    }

    public static int getStateForApplication() {
        int i2;
        synchronized (a) {
            i2 = c;
        }
        return i2;
    }

    public static void h(Sd sd, Activity activity) {
        ((Rd) a.get(activity)).b.e(sd);
    }

    public static boolean hasVisibleActivities() {
        int stateForApplication = getStateForApplication();
        return stateForApplication == 1 || stateForApplication == 2;
    }

    public static void i(Sd sd) {
        if (f == null) {
            f = new M21();
        }
        f.e(sd);
    }

    public static void j(Wd wd) {
        if (h == null) {
            h = new M21();
        }
        h.e(wd);
    }

    public static void k(Sd sd) {
        M21 m21 = f;
        if (m21 != null) {
            m21.g(sd);
        }
        Map map = a;
        synchronized (map) {
            try {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((Rd) it.next()).b.g(sd);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void l(Td td) {
        M21 m21 = g;
        if (m21 == null) {
            return;
        }
        m21.g(td);
    }

    public static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.e(new Qd());
    }
}
