package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface YJ1 extends Iterable {
    Object get(int i);

    @Override // java.lang.Iterable
    default Iterator iterator() {
        return new XJ1(this);
    }

    int size();
}
