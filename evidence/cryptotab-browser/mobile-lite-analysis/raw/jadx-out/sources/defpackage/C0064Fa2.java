package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.chromium.base.SysUtils;

/* JADX INFO: renamed from: Fa2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0064Fa2 {
    public static int e;
    public final Toast a;
    public final FrameLayout b;
    public int c;
    public CharSequence d;

    public C0064Fa2(Context context, TextView textView) {
        if (SysUtils.isLowEndDevice()) {
            this.b = new FrameLayout(new C0040Da2(context));
        }
        if (C1748xj2.a == null) {
            C1748xj2.a = new C1748xj2();
        }
        C1748xj2.a.getClass();
        Toast toast = new Toast(context);
        this.a = toast;
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            if (textView != null) {
                frameLayout.addView(textView, -2, -2);
                toast.setView(frameLayout);
            } else {
                toast.setView(null);
            }
        } else {
            toast.setView(textView);
        }
        toast.setGravity(toast.getGravity(), toast.getXOffset(), toast.getYOffset() + e);
    }

    public static C0064Fa2 b(Context context, int i, int i2) {
        C0054Ea2 c0054Ea2 = new C0054Ea2(context);
        c0054Ea2.b = context.getResources().getText(i);
        c0054Ea2.f = i2;
        return c0054Ea2.a();
    }

    public static C0064Fa2 c(Context context, CharSequence charSequence, int i) {
        C0054Ea2 c0054Ea2 = new C0054Ea2(context);
        c0054Ea2.b = charSequence;
        c0054Ea2.f = i;
        return c0054Ea2.a();
    }

    public static boolean f(Context context, View view, CharSequence charSequence) {
        C0054Ea2 c0054Ea2 = new C0054Ea2(context);
        c0054Ea2.c = view;
        c0054Ea2.b = charSequence;
        if (charSequence == null) {
            return false;
        }
        c0054Ea2.a().e();
        return true;
    }

    public final void a() {
        if (C0154Na2.d == null) {
            C0154Na2.d = new C0154Na2();
        }
        C0154Na2 c0154Na2 = C0154Na2.d;
        C0064Fa2 c0064Fa2 = c0154Na2.c;
        C0064Fa2 c0064Fa22 = null;
        if (this == c0064Fa2) {
            c0064Fa2.a.cancel();
            c0154Na2.c = null;
            c0154Na2.b.a();
            return;
        }
        PriorityQueue priorityQueue = c0154Na2.a;
        Iterator it = priorityQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0064Fa2 c0064Fa23 = (C0064Fa2) it.next();
            if (TextUtils.equals(c0064Fa23.d, this.d)) {
                c0064Fa22 = c0064Fa23;
                break;
            }
        }
        if (c0064Fa22 != null) {
            priorityQueue.remove(c0064Fa22);
        }
    }

    public final void d(int i, int i2, int i3) {
        this.a.setGravity(i, i2, i3);
    }

    public final void e() {
        if (C0154Na2.d == null) {
            C0154Na2.d = new C0154Na2();
        }
        C0154Na2 c0154Na2 = C0154Na2.d;
        C0064Fa2 c0064Fa2 = c0154Na2.c;
        if (c0064Fa2 == null || !(c0064Fa2 == this || TextUtils.equals(c0064Fa2.d, this.d))) {
            PriorityQueue<C0064Fa2> priorityQueue = c0154Na2.a;
            for (C0064Fa2 c0064Fa22 : priorityQueue) {
                if (c0064Fa22 == this || TextUtils.equals(c0064Fa22.d, this.d)) {
                    return;
                }
            }
            priorityQueue.add(this);
            if (c0154Na2.c == null) {
                c0154Na2.a();
            }
        }
    }
}
