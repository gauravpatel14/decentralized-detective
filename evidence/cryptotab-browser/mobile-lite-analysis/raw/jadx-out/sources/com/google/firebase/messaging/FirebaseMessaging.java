package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.messaging.FirebaseMessaging;
import defpackage.C0155Nd2;
import defpackage.C0488cf0;
import defpackage.C1108mm0;
import defpackage.C1745xf0;
import defpackage.InterfaceC0988kn1;
import defpackage.InterfaceC1390rR1;
import defpackage.U41;
import defpackage.Y62;
import defpackage.ZS0;
import defpackage.of0;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {
    public static TransportFactory c;
    public final C0488cf0 a;
    public final C1745xf0 b;

    public FirebaseMessaging(C0488cf0 c0488cf0, final FirebaseInstanceId firebaseInstanceId, InterfaceC0988kn1 interfaceC0988kn1, InterfaceC0988kn1 interfaceC0988kn12, of0 of0Var, TransportFactory transportFactory, InterfaceC1390rR1 interfaceC1390rR1) {
        try {
            int i = FirebaseInstanceIdReceiver.b;
            c = transportFactory;
            this.a = c0488cf0;
            this.b = new C1745xf0(this, interfaceC1390rR1);
            c0488cf0.a();
            new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init")).execute(new Runnable(this, firebaseInstanceId) { // from class: uf0
                public final FirebaseMessaging t;
                public final FirebaseInstanceId u;

                {
                    this.t = this;
                    this.u = firebaseInstanceId;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (this.t.b.b()) {
                        FirebaseInstanceId firebaseInstanceId2 = this.u;
                        FirebaseInstanceId.c(firebaseInstanceId2.b);
                        FP1 fp1G = firebaseInstanceId2.g(ZS0.b(firebaseInstanceId2.b), "*");
                        if (firebaseInstanceId2.i(fp1G)) {
                            synchronized (firebaseInstanceId2) {
                                if (!firebaseInstanceId2.g) {
                                    firebaseInstanceId2.h(0L);
                                }
                            }
                        }
                        if (fp1G == null) {
                            int i2 = FP1.e;
                        }
                    }
                }
            });
            final Context context = c0488cf0.a;
            final ZS0 zs0 = new ZS0(context);
            final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
            int i2 = C0155Nd2.j;
            final C1108mm0 c1108mm0 = new C1108mm0(c0488cf0, zs0, interfaceC0988kn1, interfaceC0988kn12, of0Var);
            Y62.c(scheduledThreadPoolExecutor, new Callable(context, scheduledThreadPoolExecutor, firebaseInstanceId, zs0, c1108mm0) { // from class: Md2
                public final Context a;
                public final ScheduledThreadPoolExecutor b;
                public final FirebaseInstanceId c;
                public final ZS0 d;
                public final C1108mm0 e;

                {
                    this.a = context;
                    this.b = scheduledThreadPoolExecutor;
                    this.c = firebaseInstanceId;
                    this.d = zs0;
                    this.e = c1108mm0;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C0126Ld2 c0126Ld2;
                    Context context2 = this.a;
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = this.b;
                    FirebaseInstanceId firebaseInstanceId2 = this.c;
                    ZS0 zs02 = this.d;
                    C1108mm0 c1108mm02 = this.e;
                    synchronized (C0126Ld2.class) {
                        try {
                            WeakReference weakReference = C0126Ld2.b;
                            c0126Ld2 = weakReference != null ? (C0126Ld2) weakReference.get() : null;
                            if (c0126Ld2 == null) {
                                SharedPreferences sharedPreferences = context2.getSharedPreferences("com.google.android.gms.appid", 0);
                                C0126Ld2 c0126Ld22 = new C0126Ld2();
                                synchronized (c0126Ld22) {
                                    c0126Ld22.a = xH1.a(sharedPreferences, scheduledThreadPoolExecutor2);
                                }
                                C0126Ld2.b = new WeakReference(c0126Ld22);
                                c0126Ld2 = c0126Ld22;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return new C0155Nd2(firebaseInstanceId2, zs02, c0126Ld2, c1108mm02, context2, scheduledThreadPoolExecutor2);
                }
            }).e(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-Trigger-Topics-Io")), new U41(this) { // from class: vf0
                public final FirebaseMessaging a;

                {
                    this.a = this;
                }

                @Override // defpackage.U41
                public final void a(Object obj) {
                    boolean z;
                    C0155Nd2 c0155Nd2 = (C0155Nd2) obj;
                    if (!this.a.b.b() || c0155Nd2.h.a() == null) {
                        return;
                    }
                    synchronized (c0155Nd2) {
                        z = c0155Nd2.g;
                    }
                    if (z) {
                        return;
                    }
                    c0155Nd2.f(0L);
                }
            });
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(C0488cf0 c0488cf0) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) c0488cf0.b(FirebaseMessaging.class);
        Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }
}
