package defpackage;

import android.net.TrafficStats;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nf0 implements of0 {
    public static final Object m = new Object();
    public static final mf0 n = new mf0();
    public final C0488cf0 a;
    public final C0979kf0 b;
    public final Af1 c;
    public final Km2 d;
    public final Js0 e;
    public final nq1 f;
    public final Object g;
    public final ThreadPoolExecutor h;
    public final ThreadPoolExecutor i;
    public String j;
    public final HashSet k;
    public final ArrayList l;

    public nf0(C0488cf0 c0488cf0, InterfaceC0988kn1 interfaceC0988kn1) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        mf0 mf0Var = n;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, timeUnit, linkedBlockingQueue, mf0Var);
        c0488cf0.a();
        C0979kf0 c0979kf0 = new C0979kf0(c0488cf0.a, interfaceC0988kn1);
        Af1 af1 = new Af1(c0488cf0);
        if (C1093mU1.a == null) {
            C1093mU1.a = new C1093mU1();
        }
        C1093mU1 c1093mU1 = C1093mU1.a;
        if (Km2.d == null) {
            Km2.d = new Km2(c1093mU1);
        }
        Km2 km2 = Km2.d;
        Js0 js0 = new Js0(c0488cf0);
        nq1 nq1Var = new nq1();
        this.g = new Object();
        this.k = new HashSet();
        this.l = new ArrayList();
        this.a = c0488cf0;
        this.b = c0979kf0;
        this.c = af1;
        this.d = km2;
        this.e = js0;
        this.f = nq1Var;
        this.h = threadPoolExecutor;
        this.i = new ThreadPoolExecutor(0, 1, 30L, timeUnit, new LinkedBlockingQueue(), mf0Var);
    }

    public static nf0 d() {
        C0488cf0 c0488cf0C = C0488cf0.c();
        Preconditions.checkArgument(true, "Null is not a valid value of FirebaseApp.");
        return (nf0) c0488cf0C.b(of0.class);
    }

    /* JADX WARN: Finally extract failed */
    public final void a() {
        C1631vi c1631viC;
        synchronized (m) {
            try {
                C0488cf0 c0488cf0 = this.a;
                c0488cf0.a();
                WP wpA = WP.a(c0488cf0.a);
                try {
                    c1631viC = this.c.c();
                    int i = c1631viC.b;
                    if (i == 2 || i == 1) {
                        String strG = g(c1631viC);
                        Af1 af1 = this.c;
                        C1575ui c1575uiA = c1631viC.a();
                        c1575uiA.a = strG;
                        c1575uiA.b = 3;
                        c1631viC = c1575uiA.a();
                        af1.b(c1631viC);
                    }
                    if (wpA != null) {
                        wpA.b();
                    }
                } catch (Throwable th) {
                    if (wpA != null) {
                        wpA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        j(c1631viC);
        this.i.execute(new lf0(this, 2));
    }

    public final C1631vi b(C1631vi c1631vi) throws FirebaseInstallationsException {
        int responseCode;
        xi xiVarF;
        C0488cf0 c0488cf0 = this.a;
        c0488cf0.a();
        String str = c0488cf0.c.a;
        String str2 = c1631vi.a;
        C0488cf0 c0488cf02 = this.a;
        c0488cf02.a();
        String str3 = c0488cf02.c.g;
        String str4 = c1631vi.d;
        C0979kf0 c0979kf0 = this.b;
        Ku1 ku1 = c0979kf0.c;
        if (!ku1.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = C0979kf0.a("projects/" + str3 + "/installations/" + str2 + "/authTokens:generate");
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = c0979kf0.c(urlA, str);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    httpURLConnectionC.setDoOutput(true);
                    C0979kf0.h(httpURLConnectionC);
                    responseCode = httpURLConnectionC.getResponseCode();
                    ku1.b(responseCode);
                } catch (Throwable th) {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            } catch (IOException | AssertionError unused) {
            }
            if (responseCode >= 200 && responseCode < 300) {
                xiVarF = C0979kf0.f(httpURLConnectionC);
            } else {
                C0979kf0.b(httpURLConnectionC, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    wi wiVarA = xi.a();
                    wiVarA.c = 3;
                    xiVarF = wiVarA.a();
                } else {
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        wi wiVarA2 = xi.a();
                        wiVarA2.c = 2;
                        xiVarF = wiVarA2.a();
                    }
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            }
            httpURLConnectionC.disconnect();
            TrafficStats.clearThreadStatsTag();
            int iB = aM1.b(xiVarF.c);
            if (iB == 0) {
                Km2 km2 = this.d;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                km2.a.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                C1575ui c1575uiA = c1631vi.a();
                c1575uiA.c = xiVarF.a;
                c1575uiA.e = Long.valueOf(xiVarF.b);
                c1575uiA.f = Long.valueOf(seconds);
                return c1575uiA.a();
            }
            if (iB == 1) {
                C1575ui c1575uiA2 = c1631vi.a();
                c1575uiA2.g = "BAD CONFIG";
                c1575uiA2.b = 5;
                return c1575uiA2.a();
            }
            if (iB != 2) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
            }
            synchronized (this) {
                this.j = null;
            }
            C1575ui c1575uiA3 = c1631vi.a();
            c1575uiA3.b = 2;
            return c1575uiA3.a();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final C0939k33 c() {
        String str;
        f();
        synchronized (this) {
            str = this.j;
        }
        if (str != null) {
            return Y62.e(str);
        }
        H62 h62 = new H62();
        Ql0 ql0 = new Ql0(h62);
        synchronized (this.g) {
            this.l.add(ql0);
        }
        C0939k33 c0939k33 = h62.a;
        this.h.execute(new lf0(this, 0));
        return c0939k33;
    }

    public final C0939k33 e() {
        f();
        H62 h62 = new H62();
        Nl0 nl0 = new Nl0(this.d, h62);
        synchronized (this.g) {
            this.l.add(nl0);
        }
        this.h.execute(new lf0(this, 1));
        return h62.a;
    }

    public final void f() {
        C0488cf0 c0488cf0 = this.a;
        c0488cf0.a();
        Preconditions.checkNotEmpty(c0488cf0.c.b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        c0488cf0.a();
        Preconditions.checkNotEmpty(c0488cf0.c.g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        c0488cf0.a();
        Preconditions.checkNotEmpty(c0488cf0.c.a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        c0488cf0.a();
        String str = c0488cf0.c.b;
        Pattern pattern = Km2.c;
        Preconditions.checkArgument(str.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        c0488cf0.a();
        Preconditions.checkArgument(Km2.c.matcher(c0488cf0.c.a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String g(defpackage.C1631vi r6) {
        /*
            r5 = this;
            cf0 r0 = r5.a
            r0.a()
            java.lang.String r0 = r0.b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            cf0 r0 = r5.a
            r0.a()
            java.lang.String r1 = "[DEFAULT]"
            java.lang.String r0 = r0.b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L55
        L1e:
            r0 = 1
            int r6 = r6.b
            if (r6 != r0) goto L55
            Js0 r6 = r5.e
            android.content.SharedPreferences r0 = r6.a
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r6.a     // Catch: java.lang.Throwable -> L39
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L39
            android.content.SharedPreferences r2 = r6.a     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = "|S|id"
            r4 = 0
            java.lang.String r2 = r2.getString(r3, r4)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L3b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            goto L40
        L39:
            r6 = move-exception
            goto L53
        L3b:
            java.lang.String r2 = r6.a()     // Catch: java.lang.Throwable -> L39
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
        L40:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L4f
            nq1 r6 = r5.f
            r6.getClass()
            java.lang.String r2 = defpackage.nq1.a()
        L4f:
            return r2
        L50:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            throw r6     // Catch: java.lang.Throwable -> L39
        L53:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            throw r6
        L55:
            nq1 r6 = r5.f
            r6.getClass()
            java.lang.String r6 = defpackage.nq1.a()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf0.g(vi):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [kf0] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [ri] */
    public final C1631vi h(C1631vi c1631vi) throws FirebaseInstallationsException {
        int responseCode;
        String str = c1631vi.a;
        int i = 0;
        String string = null;
        if (str != null && str.length() == 11) {
            Js0 js0 = this.e;
            synchronized (js0.a) {
                try {
                    String[] strArr = Js0.c;
                    int i2 = 0;
                    while (true) {
                        if (i2 < 4) {
                            String str2 = strArr[i2];
                            String string2 = js0.a.getString("|T|" + js0.b + "|" + str2, null);
                            if (string2 == null || string2.isEmpty()) {
                                i2++;
                            } else if (string2.startsWith("{")) {
                                try {
                                    string = new JSONObject(string2).getString("token");
                                } catch (JSONException unused) {
                                }
                            } else {
                                string = string2;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        C0979kf0 c0979kf0 = this.b;
        C0488cf0 c0488cf0 = this.a;
        c0488cf0.a();
        String str3 = c0488cf0.c.a;
        String str4 = c1631vi.a;
        C0488cf0 c0488cf02 = this.a;
        c0488cf02.a();
        String str5 = c0488cf02.c.g;
        C0488cf0 c0488cf03 = this.a;
        c0488cf03.a();
        String str6 = c0488cf03.c.b;
        Ku1 ku1 = c0979kf0.c;
        if (!ku1.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = C0979kf0.a("projects/" + str5 + "/installations");
        C1403ri c1403ri = c0979kf0;
        while (i <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = c1403ri.c(urlA, str3);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    C0979kf0.g(httpURLConnectionC, str4, str6);
                    responseCode = httpURLConnectionC.getResponseCode();
                    ku1.b(responseCode);
                } finally {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused2) {
            }
            if (responseCode < 200 || responseCode >= 300) {
                try {
                    C0979kf0.b(httpURLConnectionC, str6, str3, str5);
                } catch (IOException | AssertionError unused3) {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
                if (responseCode == 429) {
                    throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                }
                if (responseCode < 500 || responseCode >= 600) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    C1403ri c1403ri2 = new C1403ri(null, null, null, null, 2);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    c1403ri = c1403ri2;
                } else {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i++;
                    c1403ri = c1403ri;
                }
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
                i++;
                c1403ri = c1403ri;
            } else {
                C1403ri c1403riE = C0979kf0.e(httpURLConnectionC);
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
                c1403ri = c1403riE;
            }
            int iB = aM1.b(c1403ri.e);
            if (iB != 0) {
                if (iB != 1) {
                    throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
                }
                C1575ui c1575uiA = c1631vi.a();
                c1575uiA.g = "BAD CONFIG";
                c1575uiA.b = 5;
                return c1575uiA.a();
            }
            String str7 = c1403ri.b;
            String str8 = c1403ri.c;
            Km2 km2 = this.d;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            km2.a.getClass();
            long seconds = timeUnit.toSeconds(System.currentTimeMillis());
            xi xiVar = c1403ri.d;
            String str9 = xiVar.a;
            long j = xiVar.b;
            C1575ui c1575uiA2 = c1631vi.a();
            c1575uiA2.a = str7;
            c1575uiA2.b = 4;
            c1575uiA2.c = str9;
            c1575uiA2.d = str8;
            c1575uiA2.e = Long.valueOf(j);
            c1575uiA2.f = Long.valueOf(seconds);
            return c1575uiA2.a();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void i(Exception exc) {
        synchronized (this.g) {
            try {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC1269pO1) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(C1631vi c1631vi) {
        synchronized (this.g) {
            try {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC1269pO1) it.next()).b(c1631vi)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
