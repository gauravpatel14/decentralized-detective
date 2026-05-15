package defpackage;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.google.android.gms.common.util.ProcessUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AO2 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ String u;
    public final /* synthetic */ Object v;
    public final /* synthetic */ Object w;
    public final /* synthetic */ Object x;
    public final /* synthetic */ WO2 y;

    public AO2(WO2 wo2, int i, String str, Object obj, Object obj2, Object obj3) {
        this.y = wo2;
        this.t = i;
        this.u = str;
        this.v = obj;
        this.w = obj2;
        this.x = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TP2 tp2 = this.y.a.h;
        C1391rR2.i(tp2);
        if (!tp2.b) {
            Log.println(6, this.y.q(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        WO2 wo2 = this.y;
        if (wo2.c == 0) {
            C1009lD2 c1009lD2 = wo2.a.g;
            if (c1009lD2.d == null) {
                synchronized (c1009lD2) {
                    try {
                        if (c1009lD2.d == null) {
                            ApplicationInfo applicationInfo = c1009lD2.a.a.getApplicationInfo();
                            String myProcessName = ProcessUtils.getMyProcessName();
                            if (applicationInfo != null) {
                                String str = applicationInfo.processName;
                                c1009lD2.d = Boolean.valueOf(str != null && str.equals(myProcessName));
                            }
                            if (c1009lD2.d == null) {
                                c1009lD2.d = Boolean.TRUE;
                                WO2 wo22 = c1009lD2.a.i;
                                C1391rR2.k(wo22);
                                wo22.f.a("My process not in the list of running processes");
                            }
                        }
                    } finally {
                    }
                }
            }
            if (c1009lD2.d.booleanValue()) {
                WO2 wo23 = this.y;
                wo23.a.getClass();
                wo23.c = 'C';
            } else {
                WO2 wo24 = this.y;
                wo24.a.getClass();
                wo24.c = 'c';
            }
        }
        WO2 wo25 = this.y;
        if (wo25.d < 0) {
            wo25.a.g.l();
            wo25.d = 64000L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.t);
        WO2 wo26 = this.y;
        char c = wo26.c;
        long j = wo26.d;
        String strO = WO2.o(true, this.u, this.v, this.w, this.x);
        StringBuilder sb = new StringBuilder("2");
        sb.append(cCharAt);
        sb.append(c);
        sb.append(j);
        String strA = S3.a(sb, ":", strO);
        if (strA.length() > 1024) {
            strA = this.u.substring(0, 1024);
        }
        MP2 mp2 = tp2.d;
        if (mp2 != null) {
            TP2 tp22 = mp2.e;
            tp22.g();
            if (mp2.e.k().getLong(mp2.a, 0L) == 0) {
                mp2.a();
            }
            if (strA == null) {
                strA = "";
            }
            SharedPreferences sharedPreferencesK = tp22.k();
            String str2 = mp2.b;
            long j2 = sharedPreferencesK.getLong(str2, 0L);
            String str3 = mp2.c;
            if (j2 <= 0) {
                SharedPreferences.Editor editorEdit = tp22.k().edit();
                editorEdit.putString(str3, strA);
                editorEdit.putLong(str2, 1L);
                editorEdit.apply();
                return;
            }
            C0653fY2 c0653fY2 = tp22.a.l;
            C1391rR2.i(c0653fY2);
            long jNextLong = c0653fY2.o().nextLong();
            long j3 = j2 + 1;
            long j4 = Long.MAX_VALUE / j3;
            SharedPreferences.Editor editorEdit2 = tp22.k().edit();
            if ((Long.MAX_VALUE & jNextLong) < j4) {
                editorEdit2.putString(str3, strA);
            }
            editorEdit2.putLong(str2, j3);
            editorEdit2.apply();
        }
    }
}
