package defpackage;

import android.app.Activity;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.play.core.splitinstall.SplitInstallException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.BundleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YM1 implements ex0 {
    public static final HashMap c = new HashMap();
    public final ZM1 a;
    public final WM1 b;

    /* JADX WARN: Type inference failed for: r1v0, types: [WM1] */
    public YM1() {
        ZM1 zm1 = new ZM1();
        this.b = new InterfaceC1267pN1() { // from class: WM1
            @Override // defpackage.InterfaceC1267pN1
            public final void a(Object obj) {
                IB2 ib2 = (IB2) obj;
                YM1 ym1 = this.a;
                ym1.getClass();
                List list = ib2.f;
                ArrayList<String> arrayList = list != null ? new ArrayList(list) : new ArrayList();
                int i = ib2.b;
                ZM1 zm12 = ym1.a;
                if (i == 5) {
                    zm12.getClass();
                    if (BundleUtils.e()) {
                        C0975ka2 c0975ka2 = new C0975ka2();
                        try {
                            wO.a();
                            c0975ka2.close();
                        } finally {
                        }
                    }
                }
                for (String str : arrayList) {
                    int i2 = 6;
                    if (i == 5) {
                        ym1.d(str, Boolean.TRUE);
                    } else if (i == 6) {
                        ym1.d(str, Boolean.FALSE);
                        zm12.b.a.getClass();
                        int iA = C0955kN1.a(ib2.c);
                        if (iA == -1) {
                            iA = 19;
                        }
                        C0955kN1.b(iA, str);
                    }
                    C0984kh1 c0984kh1 = zm12.b;
                    c0984kh1.b.getClass();
                    switch (i) {
                        case 1:
                            i2 = 2;
                            break;
                        case 2:
                            i2 = 3;
                            break;
                        case 3:
                            i2 = 4;
                            break;
                        case 4:
                            i2 = 5;
                            break;
                        case 5:
                            break;
                        case 6:
                            i2 = 7;
                            break;
                        case 7:
                            i2 = 9;
                            break;
                        case 8:
                            i2 = 10;
                            break;
                        case ConnectionResult.SERVICE_INVALID /* 9 */:
                            i2 = 8;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    C1328qN1.a(i2, str);
                    C0955kN1 c0955kN1 = c0984kh1.a;
                    if (i == 5) {
                        JM1 jm1 = c0984kh1.c;
                        HashMap map = jm1.a;
                        if (map.containsKey(str)) {
                            ((IM1) map.get(str)).b.put(i, SystemClock.uptimeMillis());
                        }
                        jm1.b(0, 5, str, "");
                        jm1.b(0, 2, str, ".PendingDownload");
                        jm1.b(2, 4, str, ".Download");
                        jm1.b(4, 5, str, ".Installing");
                        c0955kN1.getClass();
                        C0955kN1.b(0, str);
                    } else if (i == 7) {
                        c0955kN1.getClass();
                        C0955kN1.b(3, str);
                    } else if (i == 3) {
                        c0955kN1.getClass();
                        C0955kN1.b(21, str);
                    }
                }
            }
        };
        this.a = zm1;
    }

    @Override // defpackage.ex0
    public final void a(Activity activity) {
        HashSet<String> hashSet;
        StrictMode.ThreadPolicy threadPolicy;
        this.a.getClass();
        NM1 nm1 = (NM1) NM1.e.get();
        if (nm1 == null) {
            if (activity.getApplicationContext() != null) {
                NM1.c(activity.getApplicationContext(), false);
            }
            NM1.c(activity, false);
            return;
        }
        HB2 hb2 = nm1.d;
        synchronized (nm1.c) {
            hashSet = new HashSet(nm1.c);
        }
        synchronized (hb2) {
            try {
                threadPolicy = StrictMode.getThreadPolicy();
            } catch (Exception e) {
                e = e;
                threadPolicy = null;
            }
            try {
                StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
            } catch (Exception e2) {
                e = e2;
                Log.i("SplitCompat", "Unable to set up strict mode.", e);
            }
            try {
                try {
                    HashSet hashSet2 = new HashSet();
                    for (String str : hashSet) {
                        File file = new File(hb2.a.g(), "verified-splits");
                        C0576eN2.e(file);
                        hashSet2.add(C0576eN2.d(file, String.valueOf(str).concat(".apk")));
                    }
                    hb2.a(activity, hashSet2);
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Error installing additional splits", e3);
                    if (threadPolicy != null) {
                    }
                }
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
            } catch (Throwable th) {
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                throw th;
            }
        }
    }

    @Override // defpackage.ex0
    public final void b(final String str, fx0 fx0Var) {
        HashMap map = c;
        List list = (List) map.get(str);
        if (list != null) {
            list.add(fx0Var);
            return;
        }
        int size = map.size();
        ZM1 zm1 = this.a;
        if (size == 0) {
            zm1.a.e(this.b);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(fx0Var);
        map.put(str, arrayList);
        zm1.getClass();
        C1145nN1 c1145nN1 = new C1145nN1();
        c1145nN1.a.add(str);
        zm1.a.g(new C1207oN1(c1145nN1)).b(new Q41() { // from class: XM1
            @Override // defpackage.Q41
            public final void d(Exception exc) {
                int errorCode;
                YM1 ym1 = this.a;
                ym1.getClass();
                boolean z = exc instanceof SplitInstallException;
                ZM1 zm12 = ym1.a;
                if (z) {
                    errorCode = ((SplitInstallException) exc).getErrorCode();
                } else {
                    zm12.b.getClass();
                    errorCode = 20;
                }
                zm12.b.a.getClass();
                int iA = C0955kN1.a(errorCode);
                int i = iA != -1 ? iA : 20;
                String str2 = str;
                C0955kN1.b(i, str2);
                ym1.d(str2, Boolean.FALSE);
            }
        });
        C0984kh1 c0984kh1 = zm1.b;
        c0984kh1.b.getClass();
        C1328qN1.a(1, str);
        JM1 jm1 = c0984kh1.c;
        jm1.getClass();
        jm1.a.put(str, new IM1(JM1.c(str, "key_modules_requested_previously")));
    }

    @Override // defpackage.ex0
    public final void c() {
        ZM1 zm1 = this.a;
        zm1.a.f(Collections.singletonList("stack_unwinder"));
        C0984kh1 c0984kh1 = zm1.b;
        c0984kh1.b.getClass();
        C1328qN1.a(11, "stack_unwinder");
        c0984kh1.c.getClass();
        JM1.c("stack_unwinder", "key_modules_deferred_requested_previously");
    }

    public final void d(String str, Boolean bool) {
        ZM1 zm1;
        HashMap map = c;
        Iterator it = ((List) map.get(str)).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            zm1 = this.a;
            if (!zHasNext) {
                break;
            }
            fx0 fx0Var = (fx0) it.next();
            if (bool.booleanValue()) {
                zm1.getClass();
                if (BundleUtils.e()) {
                    C0975ka2 c0975ka2 = new C0975ka2();
                    try {
                        d4.a();
                        c0975ka2.close();
                    } catch (Throwable th) {
                        try {
                            c0975ka2.close();
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } else {
                    continue;
                }
            }
            fx0Var.a(bool.booleanValue());
        }
        map.remove(str);
        if (map.size() == 0) {
            zm1.a.c(this.b);
        }
    }
}
