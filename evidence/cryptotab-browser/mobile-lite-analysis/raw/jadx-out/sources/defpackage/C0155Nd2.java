package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: Nd2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0155Nd2 {
    public static final long i = TimeUnit.HOURS.toSeconds(8);
    public static final /* synthetic */ int j = 0;
    public final FirebaseInstanceId a;
    public final Context b;
    public final ZS0 c;
    public final C1108mm0 d;
    public final ScheduledThreadPoolExecutor f;
    public final C0126Ld2 h;
    public final gf e = new gf(0);
    public boolean g = false;

    public C0155Nd2(FirebaseInstanceId firebaseInstanceId, ZS0 zs0, C0126Ld2 c0126Ld2, C1108mm0 c1108mm0, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.a = firebaseInstanceId;
        this.c = zs0;
        this.h = c0126Ld2;
        this.d = c1108mm0;
        this.b = context;
        this.f = scheduledThreadPoolExecutor;
    }

    public static Object a(C0939k33 c0939k33) throws IOException {
        try {
            return Y62.b(c0939k33, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public final void b(String str) throws IOException {
        FirebaseInstanceId firebaseInstanceId = this.a;
        C0488cf0 c0488cf0 = firebaseInstanceId.b;
        FirebaseInstanceId.c(c0488cf0);
        C0308Yx0 c0308Yx0 = (C0308Yx0) a(firebaseInstanceId.f(ZS0.b(c0488cf0)));
        String str2 = c0308Yx0.a;
        C1108mm0 c1108mm0 = this.d;
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        String strValueOf2 = String.valueOf(str);
        a(c1108mm0.a(str2, c0308Yx0.b, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle).f(ExecutorC0857if0.t, new C1047lm0(c1108mm0)));
    }

    public final void c(String str) throws IOException {
        FirebaseInstanceId firebaseInstanceId = this.a;
        C0488cf0 c0488cf0 = firebaseInstanceId.b;
        FirebaseInstanceId.c(c0488cf0);
        C0308Yx0 c0308Yx0 = (C0308Yx0) a(firebaseInstanceId.f(ZS0.b(c0488cf0)));
        String str2 = c0308Yx0.a;
        C1108mm0 c1108mm0 = this.d;
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String strValueOf2 = String.valueOf(str);
        a(c1108mm0.a(str2, c0308Yx0.b, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle).f(ExecutorC0857if0.t, new C1047lm0(c1108mm0)));
    }

    public final synchronized void d(boolean z) {
        this.g = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0155Nd2.e():boolean");
    }

    public final void f(long j2) {
        long jMin = Math.min(Math.max(30L, j2 + j2), i);
        this.f.schedule(new RunnableC0184Pd2(this, this.b, this.c, jMin), j2, TimeUnit.SECONDS);
        d(true);
    }
}
