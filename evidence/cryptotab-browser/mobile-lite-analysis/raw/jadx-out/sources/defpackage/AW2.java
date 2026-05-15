package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AW2 implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    public volatile boolean t;
    public volatile C1781yO2 u;
    public final /* synthetic */ CW2 v;

    public AW2(CW2 cw2) {
        this.v = cw2;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.u);
                InterfaceC1086mO2 interfaceC1086mO2 = (InterfaceC1086mO2) this.u.getService();
                C0899jR2 c0899jR2 = this.v.a.j;
                C1391rR2.k(c0899jR2);
                c0899jR2.o(new RunnableC1682wW2(this, interfaceC1086mO2));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.u = null;
                this.t = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        WO2 wo2 = this.v.a.i;
        if (wo2 == null || !wo2.b) {
            wo2 = null;
        }
        if (wo2 != null) {
            wo2.i.b(connectionResult, "Service connection failed");
        }
        synchronized (this) {
            this.t = false;
            this.u = null;
        }
        C0899jR2 c0899jR2 = this.v.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC1793yW2(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        CW2 cw2 = this.v;
        WO2 wo2 = cw2.a.i;
        C1391rR2.k(wo2);
        wo2.m.a("Service connection suspended");
        C0899jR2 c0899jR2 = cw2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC1739xW2(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.t = false;
                WO2 wo2 = this.v.a.i;
                C1391rR2.k(wo2);
                wo2.f.a("Service connected with null binder");
                return;
            }
            InterfaceC1086mO2 c0837iO2 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    c0837iO2 = iInterfaceQueryLocalInterface instanceof InterfaceC1086mO2 ? (InterfaceC1086mO2) iInterfaceQueryLocalInterface : new C0837iO2(iBinder);
                    WO2 wo22 = this.v.a.i;
                    C1391rR2.k(wo22);
                    wo22.n.a("Bound to IMeasurementService interface");
                } else {
                    WO2 wo23 = this.v.a.i;
                    C1391rR2.k(wo23);
                    wo23.f.b(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                WO2 wo24 = this.v.a.i;
                C1391rR2.k(wo24);
                wo24.f.a("Service connect failed to get IMeasurementService");
            }
            if (c0837iO2 == null) {
                this.t = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    CW2 cw2 = this.v;
                    connectionTracker.unbindService(cw2.a.a, cw2.c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                C0899jR2 c0899jR2 = this.v.a.j;
                C1391rR2.k(c0899jR2);
                c0899jR2.o(new ZV2(this, c0837iO2));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        CW2 cw2 = this.v;
        WO2 wo2 = cw2.a.i;
        C1391rR2.k(wo2);
        wo2.m.a("Service disconnected");
        C0899jR2 c0899jR2 = cw2.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new RunnableC0419bW2(this, componentName));
    }
}
