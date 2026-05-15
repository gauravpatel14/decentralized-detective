package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: lV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1031lV2 implements Runnable {
    public final MO2 t;

    public RunnableC1031lV2(MO2 mo2) {
        this.t = mo2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final MO2 mo2 = this.t;
        while (true) {
            synchronized (mo2) {
                try {
                    if (mo2.t != 2) {
                        return;
                    }
                    if (mo2.w.isEmpty()) {
                        mo2.c();
                        return;
                    }
                    final AbstractC0999l13 abstractC0999l13 = (AbstractC0999l13) mo2.w.poll();
                    mo2.x.put(abstractC0999l13.a, abstractC0999l13);
                    mo2.y.b.schedule(new Runnable(mo2, abstractC0999l13) { // from class: sX2
                        public final MO2 t;
                        public final AbstractC0999l13 u;

                        {
                            this.t = mo2;
                            this.u = abstractC0999l13;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            MO2 mo22 = this.t;
                            int i = this.u.a;
                            synchronized (mo22) {
                                AbstractC0999l13 abstractC0999l132 = (AbstractC0999l13) mo22.x.get(i);
                                if (abstractC0999l132 != null) {
                                    StringBuilder sb = new StringBuilder(31);
                                    sb.append("Timing out request: ");
                                    sb.append(i);
                                    Log.w("MessengerIpcClient", sb.toString());
                                    mo22.x.remove(i);
                                    abstractC0999l132.b.a(new zzp("Timed out waiting for response"));
                                    mo22.c();
                                }
                            }
                        }
                    }, 30L, TimeUnit.SECONDS);
                    Context context = mo2.y.a;
                    Messenger messenger = mo2.u;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = abstractC0999l13.c;
                    messageObtain.arg1 = abstractC0999l13.a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", abstractC0999l13.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", abstractC0999l13.d);
                    messageObtain.setData(bundle);
                    try {
                        IZ2 iz2 = mo2.v;
                        Messenger messenger2 = iz2.a;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            zza zzaVar = iz2.b;
                            if (zzaVar == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = zzaVar.t;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e) {
                        mo2.a(e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
