package defpackage;

import java.util.function.Supplier;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface RR1 extends Supplier {
    default boolean o() {
        return get() != null;
    }
}
