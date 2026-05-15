package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.iid.zzaa;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: d33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0509d33 implements Runnable {
    public final ServiceConnectionC1305q23 t;

    public RunnableC0509d33(ServiceConnectionC1305q23 serviceConnectionC1305q23) {
        this.t = serviceConnectionC1305q23;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ServiceConnectionC1305q23 serviceConnectionC1305q23 = this.t;
        while (true) {
            synchronized (serviceConnectionC1305q23) {
                try {
                    if (serviceConnectionC1305q23.t != 2) {
                        return;
                    }
                    if (serviceConnectionC1305q23.w.isEmpty()) {
                        serviceConnectionC1305q23.c();
                        return;
                    }
                    final C0759hC2 c0759hC2 = (C0759hC2) serviceConnectionC1305q23.w.poll();
                    serviceConnectionC1305q23.x.put(c0759hC2.a, c0759hC2);
                    serviceConnectionC1305q23.y.b.schedule(new Runnable(serviceConnectionC1305q23, c0759hC2) { // from class: s33
                        public final ServiceConnectionC1305q23 t;
                        public final C0759hC2 u;

                        {
                            this.t = serviceConnectionC1305q23;
                            this.u = c0759hC2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            ServiceConnectionC1305q23 serviceConnectionC1305q232 = this.t;
                            int i = this.u.a;
                            synchronized (serviceConnectionC1305q232) {
                                C0759hC2 c0759hC22 = (C0759hC2) serviceConnectionC1305q232.x.get(i);
                                if (c0759hC22 != null) {
                                    StringBuilder sb = new StringBuilder(31);
                                    sb.append("Timing out request: ");
                                    sb.append(i);
                                    Log.w("MessengerIpcClient", sb.toString());
                                    serviceConnectionC1305q232.x.remove(i);
                                    c0759hC22.b.a(new zzaa(3, "Timed out waiting for response"));
                                    serviceConnectionC1305q232.c();
                                }
                            }
                        }
                    }, 30L, TimeUnit.SECONDS);
                    Context context = serviceConnectionC1305q23.y.a;
                    Messenger messenger = serviceConnectionC1305q23.u;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = c0759hC2.c;
                    messageObtain.arg1 = c0759hC2.a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", false);
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", c0759hC2.d);
                    messageObtain.setData(bundle);
                    try {
                        F33 f33 = serviceConnectionC1305q23.v;
                        Messenger messenger2 = f33.a;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            MessengerCompat messengerCompat = f33.b;
                            if (messengerCompat == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = messengerCompat.t;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e) {
                        serviceConnectionC1305q23.a(2, e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
