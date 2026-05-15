package defpackage;

import android.content.res.Resources;
import java.util.HashMap;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: Mm1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0145Mm1 {
    public final HashMap a;
    public HashMap b;

    public C0145Mm1(AbstractC0197Qm1... abstractC0197Qm1Arr) {
        this.a = PropertyModel.b(abstractC0197Qm1Arr);
    }

    public final PropertyModel a() {
        return new PropertyModel(this.a, this.b);
    }

    public final void b(C0223Sm1 c0223Sm1, float f) {
        int i = AbstractC1872zv.a;
        C0159Nm1 c0159Nm1 = new C0159Nm1();
        c0159Nm1.a = f;
        this.a.put(c0223Sm1, c0159Nm1);
    }

    public final void c(C0223Sm1 c0223Sm1, long j) {
        int i = AbstractC1872zv.a;
        C0186Pm1 c0186Pm1 = new C0186Pm1();
        c0186Pm1.a = j;
        this.a.put(c0223Sm1, c0186Pm1);
    }

    public final void d(C0223Sm1 c0223Sm1, Resources resources, int i) {
        if (i != 0) {
            e(c0223Sm1, resources.getString(i));
        }
    }

    public final void e(C0223Sm1 c0223Sm1, Object obj) {
        int i = AbstractC1872zv.a;
        C0209Rm1 c0209Rm1 = new C0209Rm1();
        c0209Rm1.a = obj;
        this.a.put(c0223Sm1, c0209Rm1);
    }

    public final void f(C0223Sm1 c0223Sm1, boolean z) {
        int i = AbstractC1872zv.a;
        C0130Lm1 c0130Lm1 = new C0130Lm1();
        c0130Lm1.a = z;
        this.a.put(c0223Sm1, c0130Lm1);
    }

    public final void g(C0236Tm1 c0236Tm1, int i) {
        int i2 = AbstractC1872zv.a;
        C0172Om1 c0172Om1 = new C0172Om1();
        c0172Om1.a = i;
        this.a.put(c0236Tm1, c0172Om1);
    }
}
