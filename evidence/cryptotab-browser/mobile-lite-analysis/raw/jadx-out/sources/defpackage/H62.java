package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H62 {
    public final C0939k33 a = new C0939k33();

    public final void a(Exception exc) {
        this.a.o(exc);
    }

    public final void b(Object obj) {
        this.a.p(obj);
    }

    public final boolean c(Exception exc) {
        C0939k33 c0939k33 = this.a;
        c0939k33.getClass();
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (c0939k33.a) {
            try {
                if (c0939k33.c) {
                    return false;
                }
                c0939k33.c = true;
                c0939k33.f = exc;
                c0939k33.b.b(c0939k33);
                return true;
            } finally {
            }
        }
    }

    public final boolean d(Object obj) {
        C0939k33 c0939k33 = this.a;
        synchronized (c0939k33.a) {
            try {
                if (c0939k33.c) {
                    return false;
                }
                c0939k33.c = true;
                c0939k33.e = obj;
                c0939k33.b.b(c0939k33);
                return true;
            } finally {
            }
        }
    }
}
