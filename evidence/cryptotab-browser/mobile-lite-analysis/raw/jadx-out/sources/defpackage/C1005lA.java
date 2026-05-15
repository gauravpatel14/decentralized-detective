package defpackage;

import android.util.Log;
import java.io.IOException;
import org.chromium.base.process_launcher.FileDescriptorInfo;

/* JADX INFO: renamed from: lA, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1005lA implements InterfaceC0558eA {
    public final /* synthetic */ C1128nA a;

    @Override // defpackage.InterfaceC0558eA
    public void a(C0619fA c0619fA) {
        C1128nA c1128nA = this.a;
        if ((c1128nA.g == null ? 0 : c1128nA.g.n) != 0) {
            c1128nA.a.e(c1128nA.g);
        }
    }

    public void c() {
        C1128nA c1128nA = this.a;
        int i = c1128nA.g.n;
        int i2 = AbstractC1872zv.a;
        c1128nA.a.d(c1128nA.g);
        try {
            for (FileDescriptorInfo fileDescriptorInfo : c1128nA.c) {
                fileDescriptorInfo.u.close();
            }
        } catch (IOException e) {
            Log.w("cr_ChildProcLauncher", "Failed to close FD.", e);
        }
    }

    @Override // defpackage.InterfaceC0558eA
    public void b() {
    }
}
