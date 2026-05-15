package org.chromium.ui.dragdrop;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import defpackage.AbstractC1499tM;
import defpackage.Gr1;
import defpackage.P30;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DropDataProviderImpl {
    public static final Uri n = Uri.parse("content://" + AbstractC1499tM.a.getPackageName() + ".DropDataProvider");
    public static final String[] o = {"_display_name", "_size"};
    public static final Object p = new Object();
    public byte[] b;
    public String c;
    public String d;
    public Uri e;
    public Handler f;
    public long g;
    public long h;
    public Uri i;
    public long j;
    public long k;
    public boolean l;
    public int a = 60000;
    public final P30 m = new P30();

    public static DropDataProviderImpl onCreate() {
        return new DropDataProviderImpl();
    }

    public final void a() {
        synchronized (p) {
            try {
                b();
                long j = this.g;
                if (j > 0) {
                    long j2 = this.h;
                    if (j2 > 0) {
                        Gr1.k(Math.max(0L, j2 - j), "Android.DragDrop.Image.OpenFileTime.LastAttempt");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        this.b = null;
        this.c = null;
        this.d = null;
        Uri uri = this.e;
        if (uri != null) {
            this.i = uri;
            this.j = SystemClock.elapsedRealtime();
            this.l = false;
        }
        this.e = null;
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f = null;
        }
    }

    public final String c(Uri uri) {
        synchronized (p) {
            if (uri != null) {
                try {
                    if (uri.equals(this.e)) {
                        return this.d;
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public final AssetFileDescriptor d(DropDataContentProvider dropDataContentProvider, Uri uri) {
        if (uri == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (p) {
            try {
                if (!uri.equals(this.e)) {
                    if (uri.equals(this.i)) {
                        long j = jElapsedRealtime - this.j;
                        Gr1.k(j, "Android.DragDrop.Image.OpenFileTime.AllExpired");
                        if (!this.l) {
                            Gr1.k(j, "Android.DragDrop.Image.OpenFileTime.FirstExpired");
                            this.l = true;
                        }
                    }
                    return null;
                }
                long j2 = 0;
                if (this.h == 0) {
                    long j3 = this.g;
                    if (j3 != 0) {
                        j2 = jElapsedRealtime - j3;
                    }
                    Gr1.k(j2, "Android.DragDrop.Image.OpenFileTime.FirstAttempt");
                }
                this.h = jElapsedRealtime;
                return new AssetFileDescriptor(dropDataContentProvider.openPipeHelper(uri, c(uri), null, this.b, this.m), 0L, r8.length);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
