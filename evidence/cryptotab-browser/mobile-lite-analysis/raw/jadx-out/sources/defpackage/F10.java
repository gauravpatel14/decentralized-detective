package defpackage;

import android.os.Build;
import java.io.File;
import java.util.ArrayList;
import org.chromium.base.PathUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class F10 {
    public static I10 a() {
        ArrayList arrayList = new ArrayList();
        String[] allPrivateDownloadsDirectories = PathUtils.getAllPrivateDownloadsDirectories();
        for (int i = 1; i < allPrivateDownloadsDirectories.length; i++) {
            arrayList.add(new File(allPrivateDownloadsDirectories[i]));
        }
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT <= 29) {
            return new I10(null, arrayList);
        }
        for (String str : PathUtils.getExternalDownloadVolumesNames()) {
            arrayList2.add(new File(str));
        }
        return new I10(arrayList2, arrayList);
    }
}
