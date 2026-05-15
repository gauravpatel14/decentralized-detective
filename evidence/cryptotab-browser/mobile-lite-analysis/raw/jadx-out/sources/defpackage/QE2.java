package defpackage;

import com.google.android.gms.measurement.internal.zzau;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QE2 implements Iterator {
    public final Iterator t;

    public QE2(zzau zzauVar) {
        this.t = zzauVar.t.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.t.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
