package org.chromium.base;

import defpackage.Ww;
import java.util.Optional;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface Callback {

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public abstract class Helper {
        public static void onBooleanResultFromNative(Callback callback, boolean z) {
            callback.a0(Boolean.valueOf(z));
        }

        public static void onIntResultFromNative(Callback callback, int i) {
            callback.a0(Integer.valueOf(i));
        }

        public static void onLongResultFromNative(Callback callback, long j) {
            callback.a0(Long.valueOf(j));
        }

        public static void onObjectResultFromNative(Callback callback, Object obj) {
            callback.a0(obj);
        }

        public static void onOptionalStringResultFromNative(Callback callback, boolean z, String str) {
            callback.a0(z ? Optional.of(str) : Optional.empty());
        }

        public static void onTimeResultFromNative(Callback callback, long j) {
            callback.a0(Long.valueOf(j));
        }

        public static void runRunnable(Runnable runnable) {
            runnable.run();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [Ww] */
    default Ww c0(final Object obj) {
        return new Runnable() { // from class: Ww
            @Override // java.lang.Runnable
            public final void run() {
                this.t.a0(obj);
            }
        };
    }

    /* JADX INFO: renamed from: onResult, reason: merged with bridge method [inline-methods] */
    void a0(Object obj);
}
