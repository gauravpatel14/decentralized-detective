package defpackage;

import android.content.ClipData;
import android.content.Intent;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import org.chromium.ui.dragdrop.DropDataAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface l30 {
    Intent a(String str);

    boolean b();

    DragAndDropPermissions c(DragEvent dragEvent);

    int d(DropDataAndroid dropDataAndroid);

    boolean e();

    ClipData f(DropDataAndroid dropDataAndroid);
}
