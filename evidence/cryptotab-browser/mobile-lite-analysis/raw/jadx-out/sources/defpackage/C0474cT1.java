package defpackage;

import android.util.Property;
import androidx.appcompat.widget.SwitchCompat;

/* JADX INFO: renamed from: cT1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0474cT1 extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        return Float.valueOf(((SwitchCompat) obj).S);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        SwitchCompat switchCompat = (SwitchCompat) obj;
        switchCompat.S = ((Float) obj2).floatValue();
        switchCompat.invalidate();
    }
}
