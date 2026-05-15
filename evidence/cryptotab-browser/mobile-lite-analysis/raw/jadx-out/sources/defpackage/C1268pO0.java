package defpackage;

import java.util.Comparator;

/* JADX INFO: renamed from: pO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1268pO0 implements Comparator {
    public static final C1268pO0 a = new C1268pO0();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((C0838iP0) obj).d.compareToIgnoreCase(((C0838iP0) obj2).d);
    }
}
