package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface d51 extends RR1 {
    default void f(Callback callback) {
        if (o()) {
            callback.a0(get());
        } else {
            p(callback);
        }
    }

    Object p(Callback callback);
}
