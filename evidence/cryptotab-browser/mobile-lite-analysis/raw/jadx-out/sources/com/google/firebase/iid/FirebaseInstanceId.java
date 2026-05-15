package com.google.firebase.iid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.firebase.iid.FirebaseInstanceId;
import defpackage.AbstractC0918jf0;
import defpackage.Bu1;
import defpackage.C0001Af0;
import defpackage.C0308Yx0;
import defpackage.C0488cf0;
import defpackage.C0939k33;
import defpackage.C1108mm0;
import defpackage.FP1;
import defpackage.GP1;
import defpackage.InterfaceC0988kn1;
import defpackage.N41;
import defpackage.Y62;
import defpackage.ZS0;
import defpackage.dU1;
import defpackage.nf0;
import defpackage.of0;
import defpackage.rf0;
import defpackage.xN;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FirebaseInstanceId {
    public static GP1 i;
    public static ScheduledThreadPoolExecutor k;
    public final ThreadPoolExecutor a;
    public final C0488cf0 b;
    public final ZS0 c;
    public final C1108mm0 d;
    public final Bu1 e;
    public final of0 f;
    public boolean g;
    public static final long h = TimeUnit.HOURS.toSeconds(8);
    public static final Pattern j = Pattern.compile("\\AA[\\w-]{38}\\z");

    public FirebaseInstanceId(C0488cf0 c0488cf0, InterfaceC0988kn1 interfaceC0988kn1, InterfaceC0988kn1 interfaceC0988kn12, of0 of0Var) {
        c0488cf0.a();
        ZS0 zs0 = new ZS0(c0488cf0.a);
        ThreadPoolExecutor threadPoolExecutorA = AbstractC0918jf0.a();
        ThreadPoolExecutor threadPoolExecutorA2 = AbstractC0918jf0.a();
        this.g = false;
        if (ZS0.b(c0488cf0) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            try {
                if (i == null) {
                    c0488cf0.a();
                    i = new GP1(c0488cf0.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b = c0488cf0;
        this.c = zs0;
        this.d = new C1108mm0(c0488cf0, zs0, interfaceC0988kn1, interfaceC0988kn12, of0Var);
        this.a = threadPoolExecutorA2;
        this.e = new Bu1(threadPoolExecutorA);
        this.f = of0Var;
    }

    public static Object a(C0939k33 c0939k33) throws InterruptedException {
        Preconditions.checkNotNull(c0939k33, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        c0939k33.m(rf0.t, new N41(countDownLatch) { // from class: sf0
            public final CountDownLatch a;

            {
                this.a = countDownLatch;
            }

            @Override // defpackage.N41
            public final void onComplete(G62 g62) {
                GP1 gp1 = FirebaseInstanceId.i;
                this.a.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        if (c0939k33.k()) {
            return c0939k33.h();
        }
        if (c0939k33.d) {
            throw new CancellationException("Task is already canceled");
        }
        if (c0939k33.j()) {
            throw new IllegalStateException(c0939k33.g());
        }
        throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }

    public static void c(C0488cf0 c0488cf0) {
        c0488cf0.a();
        C0001Af0 c0001Af0 = c0488cf0.c;
        Preconditions.checkNotEmpty(c0001Af0.g, "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        c0488cf0.a();
        Preconditions.checkNotEmpty(c0001Af0.b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        c0488cf0.a();
        Preconditions.checkNotEmpty(c0001Af0.a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        c0488cf0.a();
        Preconditions.checkArgument(c0001Af0.b.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        c0488cf0.a();
        Preconditions.checkArgument(j.matcher(c0001Af0.a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public static void d(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            try {
                if (k == null) {
                    k = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
                }
                k.schedule(runnable, j2, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Keep
    public static FirebaseInstanceId getInstance(C0488cf0 c0488cf0) {
        c(c0488cf0);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) c0488cf0.b(FirebaseInstanceId.class);
        Preconditions.checkNotNull(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public final String b() throws IOException {
        String strB = ZS0.b(this.b);
        c(this.b);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        try {
            return ((C0308Yx0) Y62.b(f(strB), 30000L, TimeUnit.MILLISECONDS)).b;
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e);
            }
            if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                synchronized (this) {
                    i.c();
                }
            }
            throw ((IOException) cause);
        }
    }

    public final String e() {
        try {
            i.d(this.b.d());
            return (String) a(((nf0) this.f).c());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public final C0939k33 f(final String str) {
        final String str2 = "*";
        return Y62.e(null).n(this.a, new xN(this, str, str2) { // from class: qf0
            public final FirebaseInstanceId a;
            public final String b;
            public final String c;

            {
                this.a = this;
                this.b = str;
                this.c = str2;
            }

            @Override // defpackage.xN
            public final Object a(G62 g62) {
                final FirebaseInstanceId firebaseInstanceId = this.a;
                final String str3 = this.b;
                final String str4 = this.c;
                final String strE = firebaseInstanceId.e();
                FP1 fp1G = firebaseInstanceId.g(str3, str4);
                if (!firebaseInstanceId.i(fp1G)) {
                    return Y62.e(new C0308Yx0(strE, fp1G.a));
                }
                Bu1 bu1 = firebaseInstanceId.e;
                synchronized (bu1) {
                    Pair pair = new Pair(str3, str4);
                    G62 g622 = (G62) bu1.b.get(pair);
                    if (g622 != null) {
                        return g622;
                    }
                    C1108mm0 c1108mm0 = firebaseInstanceId.d;
                    c1108mm0.getClass();
                    C0939k33 c0939k33F = c1108mm0.a(strE, str3, str4, new Bundle()).f(ExecutorC0857if0.t, new C1047lm0(c1108mm0));
                    InterfaceC1507tR1 interfaceC1507tR1 = new InterfaceC1507tR1(firebaseInstanceId, str3, str4, strE) { // from class: tf0
                        public final FirebaseInstanceId a;
                        public final String b;
                        public final String c;
                        public final String d;

                        {
                            this.a = firebaseInstanceId;
                            this.b = str3;
                            this.c = str4;
                            this.d = strE;
                        }

                        @Override // defpackage.InterfaceC1507tR1
                        public final G62 then(Object obj) {
                            FirebaseInstanceId firebaseInstanceId2 = this.a;
                            String str5 = this.b;
                            String str6 = this.c;
                            String str7 = this.d;
                            String str8 = (String) obj;
                            GP1 gp1 = FirebaseInstanceId.i;
                            C0488cf0 c0488cf0 = firebaseInstanceId2.b;
                            c0488cf0.a();
                            String strD = "[DEFAULT]".equals(c0488cf0.b) ? "" : c0488cf0.d();
                            String strA = firebaseInstanceId2.c.a();
                            synchronized (gp1) {
                                String strA2 = FP1.a(System.currentTimeMillis(), str8, strA);
                                if (strA2 != null) {
                                    SharedPreferences.Editor editorEdit = gp1.a.edit();
                                    editorEdit.putString(GP1.b(strD, str5, str6), strA2);
                                    editorEdit.commit();
                                }
                            }
                            return Y62.e(new C0308Yx0(str7, str8));
                        }
                    };
                    ThreadPoolExecutor threadPoolExecutor = firebaseInstanceId.a;
                    C0939k33 c0939k33 = new C0939k33();
                    c0939k33F.b.a(new D03(threadPoolExecutor, interfaceC1507tR1, c0939k33));
                    c0939k33F.s();
                    C0939k33 c0939k33N = c0939k33.n(bu1.a, new xN(bu1, pair) { // from class: Au1
                        public final Bu1 a;
                        public final Pair b;

                        {
                            this.a = bu1;
                            this.b = pair;
                        }

                        @Override // defpackage.xN
                        public final Object a(G62 g623) {
                            Bu1 bu12 = this.a;
                            Pair pair2 = this.b;
                            synchronized (bu12) {
                                bu12.b.remove(pair2);
                            }
                            return g623;
                        }
                    });
                    bu1.b.put(pair, c0939k33N);
                    return c0939k33N;
                }
            }
        });
    }

    public final FP1 g(String str, String str2) {
        FP1 fp1B;
        GP1 gp1 = i;
        C0488cf0 c0488cf0 = this.b;
        c0488cf0.a();
        String strD = "[DEFAULT]".equals(c0488cf0.b) ? "" : c0488cf0.d();
        synchronized (gp1) {
            fp1B = FP1.b(gp1.a.getString(GP1.b(strD, str, str2), null));
        }
        return fp1B;
    }

    public final synchronized void h(long j2) {
        d(new dU1(this, Math.min(Math.max(30L, j2 + j2), h)), j2);
        this.g = true;
    }

    public final boolean i(FP1 fp1) {
        if (fp1 != null) {
            return System.currentTimeMillis() > fp1.c + FP1.d || !this.c.a().equals(fp1.b);
        }
        return true;
    }
}
