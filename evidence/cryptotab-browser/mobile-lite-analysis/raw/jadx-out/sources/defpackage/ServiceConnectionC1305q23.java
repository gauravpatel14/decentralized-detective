package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.iid.zzaa;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: q23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1305q23 implements ServiceConnection {
    public F33 v;
    public final /* synthetic */ Q13 y;
    public int t = 0;
    public final Messenger u = new Messenger(new ZU2(Looper.getMainLooper(), new Handler.Callback(this) { // from class: E23
        public final ServiceConnectionC1305q23 t;

        {
            this.t = this;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            ServiceConnectionC1305q23 serviceConnectionC1305q23 = this.t;
            serviceConnectionC1305q23.getClass();
            int i = message.arg1;
            synchronized (serviceConnectionC1305q23) {
                try {
                    C0759hC2 c0759hC2 = (C0759hC2) serviceConnectionC1305q23.x.get(i);
                    if (c0759hC2 == null) {
                        StringBuilder sb = new StringBuilder(50);
                        sb.append("Received response for unknown request: ");
                        sb.append(i);
                        Log.w("MessengerIpcClient", sb.toString());
                        return true;
                    }
                    serviceConnectionC1305q23.x.remove(i);
                    serviceConnectionC1305q23.c();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        c0759hC2.b.a(new zzaa(4, "Not supported by GmsCore"));
                        return true;
                    }
                    Bundle bundle = data.getBundle("data");
                    if (bundle == null) {
                        bundle = Bundle.EMPTY;
                    }
                    c0759hC2.b.b(bundle);
                    return true;
                } finally {
                }
            }
        }
    }));
    public final ArrayDeque w = new ArrayDeque();
    public final SparseArray x = new SparseArray();

    public ServiceConnectionC1305q23(Q13 q13) {
        this.y = q13;
    }

    public final synchronized void a(int i, String str) {
        try {
            int i2 = this.t;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    this.t = 4;
                    return;
                } else {
                    if (i2 == 4) {
                        return;
                    }
                    int i3 = this.t;
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("Unknown state: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.t = 4;
            ConnectionTracker.getInstance().unbindService(this.y.a, this);
            zzaa zzaaVar = new zzaa(i, str);
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                ((C0759hC2) it.next()).b.a(zzaaVar);
            }
            this.w.clear();
            for (int i4 = 0; i4 < this.x.size(); i4++) {
                ((C0759hC2) this.x.valueAt(i4)).b.a(zzaaVar);
            }
            this.x.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean b(C0759hC2 c0759hC2) {
        int i = this.t;
        if (i == 0) {
            this.w.add(c0759hC2);
            Preconditions.checkState(this.t == 0);
            this.t = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (ConnectionTracker.getInstance().bindService(this.y.a, intent, this, 1)) {
                this.y.b.schedule(new Runnable(this) { // from class: S23
                    public final ServiceConnectionC1305q23 t;

                    {
                        this.t = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ServiceConnectionC1305q23 serviceConnectionC1305q23 = this.t;
                        synchronized (serviceConnectionC1305q23) {
                            if (serviceConnectionC1305q23.t == 1) {
                                serviceConnectionC1305q23.a(1, "Timed out while binding");
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.w.add(c0759hC2);
            return true;
        }
        if (i == 2) {
            this.w.add(c0759hC2);
            this.y.b.execute(new RunnableC0509d33(this));
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.t;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    public final synchronized void c() {
        if (this.t == 2 && this.w.isEmpty() && this.x.size() == 0) {
            this.t = 3;
            ConnectionTracker.getInstance().unbindService(this.y.a, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            a(0, "Null service connection");
            return;
        }
        try {
            this.v = new F33(iBinder);
            this.t = 2;
            this.y.b.execute(new RunnableC0509d33(this));
        } catch (RemoteException e) {
            a(0, e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        a(2, "Service disconnected");
    }
}
