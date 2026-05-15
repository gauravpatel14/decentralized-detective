package defpackage;

import J.N;
import java.util.Iterator;
import org.chromium.net.NetworkChangeNotifier;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TX0 implements hY0 {
    public final /* synthetic */ NetworkChangeNotifier a;

    public TX0(NetworkChangeNotifier networkChangeNotifier) {
        this.a = networkChangeNotifier;
    }

    @Override // defpackage.hY0
    public final void a(int i) {
        NetworkChangeNotifier networkChangeNotifier = this.a;
        networkChangeNotifier.d = i;
        networkChangeNotifier.d(i, networkChangeNotifier.getCurrentDefaultNetId());
    }

    @Override // defpackage.hY0
    public final void b(int i, long j) {
        NetworkChangeNotifier networkChangeNotifier = this.a;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_IJJO(12, i, ((Long) it.next()).longValue(), j, networkChangeNotifier);
        }
    }

    @Override // defpackage.hY0
    public final void c(int i) {
        this.a.c(i);
    }

    @Override // defpackage.hY0
    public final void d(int i) {
        this.a.b(i);
    }

    @Override // defpackage.hY0
    public final void e(long[] jArr) {
        NetworkChangeNotifier networkChangeNotifier = this.a;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_JOO(115, ((Long) it.next()).longValue(), networkChangeNotifier, jArr);
        }
    }

    @Override // defpackage.hY0
    public final void f(long j) {
        NetworkChangeNotifier networkChangeNotifier = this.a;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_JJO(13, ((Long) it.next()).longValue(), j, networkChangeNotifier);
        }
    }

    @Override // defpackage.hY0
    public final void g(long j) {
        NetworkChangeNotifier networkChangeNotifier = this.a;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_JJO(14, ((Long) it.next()).longValue(), j, networkChangeNotifier);
        }
    }
}
