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
import com.google.android.gms.cloudmessaging.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MO2 implements ServiceConnection {
    public IZ2 v;
    public final /* synthetic */ C0836iN2 y;
    public int t = 0;
    public final Messenger u = new Messenger(new TM2(Looper.getMainLooper(), new Handler.Callback(this) { // from class: YT2
        public final MO2 t;

        {
            this.t = this;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            MO2 mo2 = this.t;
            mo2.getClass();
            int i = message.arg1;
            synchronized (mo2) {
                try {
                    AbstractC0999l13 abstractC0999l13 = (AbstractC0999l13) mo2.x.get(i);
                    if (abstractC0999l13 == null) {
                        StringBuilder sb = new StringBuilder(50);
                        sb.append("Received response for unknown request: ");
                        sb.append(i);
                        Log.w("MessengerIpcClient", sb.toString());
                        return true;
                    }
                    mo2.x.remove(i);
                    mo2.c();
                    Bundle data = message.getData();
                    if (!data.getBoolean("unsupported", false)) {
                        abstractC0999l13.a(data);
                        return true;
                    }
                    abstractC0999l13.b.a(new zzp("Not supported by GmsCore"));
                    return true;
                } finally {
                }
            }
        }
    }));
    public final ArrayDeque w = new ArrayDeque();
    public final SparseArray x = new SparseArray();

    public MO2(C0836iN2 c0836iN2) {
        this.y = c0836iN2;
    }

    public final synchronized void a(String str) {
        try {
            int i = this.t;
            if (i == 0) {
                throw new IllegalStateException();
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    this.t = 4;
                    return;
                } else {
                    if (i == 4) {
                        return;
                    }
                    int i2 = this.t;
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("Unknown state: ");
                    sb.append(i2);
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.t = 4;
            ConnectionTracker.getInstance().unbindService(this.y.a, this);
            zzp zzpVar = new zzp(str);
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                ((AbstractC0999l13) it.next()).b.a(zzpVar);
            }
            this.w.clear();
            for (int i3 = 0; i3 < this.x.size(); i3++) {
                ((AbstractC0999l13) this.x.valueAt(i3)).b.a(zzpVar);
            }
            this.x.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean b(AbstractC0999l13 abstractC0999l13) {
        int i = this.t;
        if (i == 0) {
            this.w.add(abstractC0999l13);
            Preconditions.checkState(this.t == 0);
            this.t = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (ConnectionTracker.getInstance().bindService(this.y.a, intent, this, 1)) {
                this.y.b.schedule(new Runnable(this) { // from class: wS2
                    public final MO2 t;

                    {
                        this.t = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MO2 mo2 = this.t;
                        synchronized (mo2) {
                            if (mo2.t == 1) {
                                mo2.a("Timed out while binding");
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a("Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.w.add(abstractC0999l13);
            return true;
        }
        if (i == 2) {
            this.w.add(abstractC0999l13);
            this.y.b.execute(new RunnableC1031lV2(this));
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
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        this.y.b.execute(new Runnable(this, iBinder) { // from class: qW2
            public final MO2 t;
            public final IBinder u;

            {
                this.t = this;
                this.u = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MO2 mo2 = this.t;
                IBinder iBinder2 = this.u;
                synchronized (mo2) {
                    if (iBinder2 == null) {
                        mo2.a("Null service connection");
                        return;
                    }
                    try {
                        mo2.v = new IZ2(iBinder2);
                        mo2.t = 2;
                        mo2.y.b.execute(new RunnableC1031lV2(mo2));
                    } catch (RemoteException e) {
                        mo2.a(e.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.y.b.execute(new Runnable(this) { // from class: vY2
            public final MO2 t;

            {
                this.t = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.t.a("Service disconnected");
            }
        });
    }
}
