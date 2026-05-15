package defpackage;

import android.os.Handler;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class GC0 {
    public static GC0 u = new GC0();
    public final M21 t = new M21();

    public void a(FC0 fc0) {
        M21 m21 = this.t;
        if (m21.isEmpty()) {
            e();
        }
        m21.e(fc0);
    }

    public int b(View view) {
        return EC0.a(view);
    }

    public void c(View view) {
        EC0.b(view);
    }

    public boolean d(View view) {
        return EC0.c(view);
    }

    public void f(FC0 fc0) {
        M21 m21 = this.t;
        m21.g(fc0);
        if (m21.isEmpty()) {
            h();
        }
    }

    public void g(View view) {
        new DC0(view, new AtomicInteger(), new Handler()).run();
    }

    public void e() {
    }

    public void h() {
    }
}
