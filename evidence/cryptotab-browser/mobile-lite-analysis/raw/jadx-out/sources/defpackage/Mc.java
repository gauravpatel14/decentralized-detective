package defpackage;

import java.util.Comparator;
import org.chromium.base.LocaleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mc implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return LocaleUtils.b((String) obj).compareTo(LocaleUtils.b((String) obj2));
    }
}
