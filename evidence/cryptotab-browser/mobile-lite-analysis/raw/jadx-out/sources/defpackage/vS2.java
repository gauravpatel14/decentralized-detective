package defpackage;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cast.framework.media.MediaNotificationService;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vS2 extends BroadcastReceiver {
    public final /* synthetic */ MediaNotificationService a;

    public vS2(MediaNotificationService mediaNotificationService) {
        this.a = mediaNotificationService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        PendingIntent activities;
        ComponentName componentName = (ComponentName) intent.getParcelableExtra("targetActivity");
        Intent intent2 = new Intent();
        intent2.setComponent(componentName);
        MediaNotificationService mediaNotificationService = this.a;
        C0025By c0025By = mediaNotificationService.u;
        c0025By.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            AX2 ax2 = (AX2) c0025By.b;
            Parcel parcelX0 = ax2.X0(12, ax2.W0());
            int i = QK2.a;
            z = parcelX0.readInt() != 0;
            parcelX0.recycle();
        } catch (RemoteException unused) {
            C0025By.h.getClass();
            z = false;
        }
        if (z) {
            intent2.setFlags(603979776);
            activities = PendingIntent.getActivity(context, 1, intent2, 134217728);
        } else {
            ArrayList arrayList = new ArrayList();
            int size = arrayList.size();
            try {
                for (Intent intentB = ZW0.b(mediaNotificationService, componentName); intentB != null; intentB = ZW0.b(mediaNotificationService, intentB.getComponent())) {
                    arrayList.add(size, intentB);
                }
                arrayList.add(intent2);
                if (arrayList.isEmpty()) {
                    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
                }
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                activities = PendingIntent.getActivities(mediaNotificationService, 1, intentArr, 134217728, null);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e);
            }
        }
        try {
            activities.send(context, 1, new Intent().setFlags(268435456));
        } catch (PendingIntent.CanceledException unused2) {
            MediaNotificationService.v.getClass();
        }
    }
}
