package defpackage;

import android.view.ContentInfo;
import java.util.Objects;

/* JADX INFO: renamed from: co2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0501co2 {
    public static String[] a(C1038lb c1038lb) {
        return c1038lb.getReceiveContentMimeTypes();
    }

    public static vL b(C1038lb c1038lb, vL vLVar) {
        ContentInfo contentInfoG = vLVar.a.g();
        Objects.requireNonNull(contentInfoG);
        ContentInfo contentInfoPerformReceiveContent = c1038lb.performReceiveContent(contentInfoG);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoG ? vLVar : new vL(new rL(contentInfoPerformReceiveContent));
    }
}
