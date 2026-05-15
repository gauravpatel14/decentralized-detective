package defpackage;

import com.google.android.gms.cast.ApplicationMetadata;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ky extends wy {
    public final /* synthetic */ Ly a;

    public Ky(Ly ly) {
        this.a = ly;
    }

    @Override // defpackage.wy
    public final void a(int i) {
        Iterator it = new HashSet(this.a.d).iterator();
        while (it.hasNext()) {
            ((wy) it.next()).a(i);
        }
    }

    @Override // defpackage.wy
    public final void b(int i) {
        Ly ly = this.a;
        Ly.j(ly);
        ly.b(i);
        Iterator it = new HashSet(ly.d).iterator();
        while (it.hasNext()) {
            ((wy) it.next()).b(i);
        }
    }

    @Override // defpackage.wy
    public final void c(ApplicationMetadata applicationMetadata) {
        Iterator it = new HashSet(this.a.d).iterator();
        while (it.hasNext()) {
            ((wy) it.next()).c(applicationMetadata);
        }
    }

    @Override // defpackage.wy
    public final void d() {
        Iterator it = new HashSet(this.a.d).iterator();
        while (it.hasNext()) {
            ((wy) it.next()).d();
        }
    }

    @Override // defpackage.wy
    public final void e(int i) {
        Iterator it = new HashSet(this.a.d).iterator();
        while (it.hasNext()) {
            ((wy) it.next()).e(i);
        }
    }

    @Override // defpackage.wy
    public final void f() {
        Iterator it = new HashSet(this.a.d).iterator();
        while (it.hasNext()) {
            ((wy) it.next()).f();
        }
    }
}
