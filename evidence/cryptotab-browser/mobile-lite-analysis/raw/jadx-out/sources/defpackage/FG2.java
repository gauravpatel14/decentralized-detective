package defpackage;

import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FG2 implements InterfaceC0946kE2 {
    @Override // defpackage.InterfaceC0946kE2
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return RE2.c(classLoader, file, file2, z, new bF2(), "path", new AG2());
    }

    @Override // defpackage.InterfaceC0946kE2
    public final void b(ClassLoader classLoader, HashSet hashSet) {
        AbstractC1073mF2.c(classLoader, hashSet, new C0397bG2());
    }
}
