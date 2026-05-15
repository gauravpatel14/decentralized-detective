package defpackage;

import android.media.AudioManager;

/* JADX INFO: renamed from: Fg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0066Fg {
    public final C0056Eg a;
    public final C0031Cg b;
    public final AudioManager c;

    public AbstractC0066Fg(AudioManager audioManager) {
        C0056Eg c0056Eg = new C0056Eg(this);
        this.a = c0056Eg;
        this.c = audioManager;
        this.b = new C0031Cg(c0056Eg);
    }

    public abstract void a();

    public abstract boolean[] b();

    public abstract void c();

    public abstract boolean d();

    public final void e() {
        int i;
        C0056Eg c0056Eg = this.a;
        synchronized (c0056Eg.a) {
            try {
                if (c0056Eg.b == -1) {
                    i = -1;
                } else {
                    boolean[] zArrB = c0056Eg.c.b();
                    i = c0056Eg.b;
                    if (i == -2 || !zArrB[i]) {
                        i = 1;
                        if (!zArrB[1]) {
                            i = 4;
                            if (!zArrB[4]) {
                                i = 3;
                                if (!zArrB[3]) {
                                    i = 0;
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        }
        if (i == -1) {
            return;
        }
        f(i);
    }

    public abstract void f(int i);

    public abstract void g(boolean z);

    public abstract void i(boolean z);

    public void h(int i, boolean z) {
    }
}
