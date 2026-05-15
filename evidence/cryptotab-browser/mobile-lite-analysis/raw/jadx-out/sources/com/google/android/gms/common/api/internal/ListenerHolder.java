package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class ListenerHolder {
    private final Executor zaa;
    private volatile Object zab;
    private volatile ListenerKey zac;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public final class ListenerKey {
        private final Object zaa;
        private final String zab;

        @KeepForSdk
        public ListenerKey(Object obj, String str) {
            this.zaa = obj;
            this.zab = str;
        }

        @KeepForSdk
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        @KeepForSdk
        public int hashCode() {
            return this.zab.hashCode() + (System.identityHashCode(this.zaa) * 31);
        }

        @KeepForSdk
        public String toIdString() {
            return this.zab + "@" + System.identityHashCode(this.zaa);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepForSdk
    public interface Notifier {
        @KeepForSdk
        void notifyListener(Object obj);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    @KeepForSdk
    public ListenerHolder(Looper looper, Object obj, String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = Preconditions.checkNotNull(obj, "Listener must not be null");
        this.zac = new ListenerKey(obj, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    @KeepForSdk
    public ListenerKey getListenerKey() {
        return this.zac;
    }

    @KeepForSdk
    public boolean hasListener() {
        return this.zab != null;
    }

    @KeepForSdk
    public void notifyListener(final Notifier notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                this.zaa.zaa(notifier);
            }
        });
    }

    public final void zaa(Notifier notifier) {
        Object obj = this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }

    @KeepForSdk
    public ListenerHolder(Executor executor, Object obj, String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = Preconditions.checkNotNull(obj, "Listener must not be null");
        this.zac = new ListenerKey(obj, Preconditions.checkNotEmpty(str));
    }
}
