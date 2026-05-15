package defpackage;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tO implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        return file.lastModified() == file2.lastModified() ? file.compareTo(file2) : file.lastModified() < file2.lastModified() ? 1 : -1;
    }
}
