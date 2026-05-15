package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class ListenerHolders {
    private final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static ListenerHolder createListenerHolder(Object obj, Looper looper, String str) {
        Preconditions.checkNotNull(obj, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder(looper, obj, str);
    }

    @KeepForSdk
    public static ListenerHolder.ListenerKey createListenerKey(Object obj, String str) {
        Preconditions.checkNotNull(obj, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey(obj, str);
    }

    public final ListenerHolder zaa(Object obj, Looper looper, String str) {
        Set set = this.zaa;
        ListenerHolder listenerHolderCreateListenerHolder = createListenerHolder(obj, looper, "NO_TYPE");
        set.add(listenerHolderCreateListenerHolder);
        return listenerHolderCreateListenerHolder;
    }

    public final void zab() {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).clear();
        }
        this.zaa.clear();
    }

    @KeepForSdk
    public static ListenerHolder createListenerHolder(Object obj, Executor executor, String str) {
        Preconditions.checkNotNull(obj, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder(executor, obj, str);
    }
}
