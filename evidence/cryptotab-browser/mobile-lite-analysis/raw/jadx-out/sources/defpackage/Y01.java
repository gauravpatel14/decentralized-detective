package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Y01 implements Handler.Callback, ServiceConnection {
    public final Context t;
    public final Handler u;
    public final HashMap v = new HashMap();
    public HashSet w = new HashSet();

    public Y01(Context context) {
        this.t = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.u = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(X01 x01) {
        boolean z;
        ArrayDeque arrayDeque;
        if (x01.d.isEmpty()) {
            return;
        }
        boolean z2 = x01.b;
        ComponentName componentName = x01.a;
        if (z2) {
            z = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.t;
            boolean zBindService = context.bindService(component, this, 33);
            x01.b = zBindService;
            if (zBindService) {
                x01.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z = x01.b;
        }
        if (!z || x01.c == null) {
            b(x01);
            return;
        }
        while (true) {
            arrayDeque = x01.d;
            V01 v01 = (V01) arrayDeque.peek();
            if (v01 == null) {
                break;
            }
            try {
                v01.a(x01.c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
            } catch (RemoteException e) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        b(x01);
    }

    public final void b(X01 x01) {
        Handler handler = this.u;
        ComponentName componentName = x01.a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i = x01.e + 1;
        x01.e = i;
        if (i <= 6) {
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), (1 << r3) * 1000);
            return;
        }
        StringBuilder sb = new StringBuilder("Giving up on delivering ");
        ArrayDeque arrayDeque = x01.d;
        sb.append(arrayDeque.size());
        sb.append(" tasks to ");
        sb.append(componentName);
        sb.append(" after ");
        sb.append(x01.e);
        sb.append(" retries");
        Log.w("NotifManCompat", sb.toString());
        arrayDeque.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i = message.what;
        Xr0 xr0 = null;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    X01 x01 = (X01) this.v.get((ComponentName) message.obj);
                    if (x01 != null) {
                        a(x01);
                    }
                    return true;
                }
                X01 x012 = (X01) this.v.get((ComponentName) message.obj);
                if (x012 != null) {
                    if (x012.b) {
                        this.t.unbindService(this);
                        x012.b = false;
                    }
                    x012.c = null;
                }
                return true;
            }
            W01 w01 = (W01) message.obj;
            ComponentName componentName = w01.a;
            IBinder iBinder = w01.b;
            X01 x013 = (X01) this.v.get(componentName);
            if (x013 != null) {
                int i2 = Wr0.t;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(Xr0.f);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Xr0)) {
                        Vr0 vr0 = new Vr0();
                        vr0.t = iBinder;
                        xr0 = vr0;
                    } else {
                        xr0 = (Xr0) iInterfaceQueryLocalInterface;
                    }
                }
                x013.c = xr0;
                x013.e = 0;
                a(x013);
            }
            return true;
        }
        V01 v01 = (V01) message.obj;
        String string = Settings.Secure.getString(this.t.getContentResolver(), "enabled_notification_listeners");
        synchronized (Z01.c) {
            if (string != null) {
                try {
                    if (!string.equals(Z01.d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet2 = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet2.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        Z01.e = hashSet2;
                        Z01.d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hashSet = Z01.e;
        }
        if (!hashSet.equals(this.w)) {
            this.w = hashSet;
            List<ResolveInfo> listQueryIntentServices = this.t.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet3 = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName2 = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName2 + ", not adding listener record.");
                    } else {
                        hashSet3.add(componentName2);
                    }
                }
            }
            for (ComponentName componentName3 : hashSet3) {
                if (!this.v.containsKey(componentName3)) {
                    this.v.put(componentName3, new X01(componentName3));
                }
            }
            Iterator it = this.v.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet3.contains(entry.getKey())) {
                    X01 x014 = (X01) entry.getValue();
                    if (x014.b) {
                        this.t.unbindService(this);
                        x014.b = false;
                    }
                    x014.c = null;
                    it.remove();
                }
            }
        }
        for (X01 x015 : this.v.values()) {
            x015.d.add(v01);
            a(x015);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.u.obtainMessage(1, new W01(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.u.obtainMessage(2, componentName).sendToTarget();
    }
}
