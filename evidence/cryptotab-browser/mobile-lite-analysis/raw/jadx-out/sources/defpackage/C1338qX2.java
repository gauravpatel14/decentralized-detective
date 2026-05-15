package defpackage;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: renamed from: qX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1338qX2 implements FileFilter {
    public static final /* synthetic */ C1338qX2 a = new C1338qX2();

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        int i = C0219Sa0.p;
        return file.getName().endsWith(".apk");
    }
}
