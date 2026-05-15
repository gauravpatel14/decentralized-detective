package defpackage;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class E10 extends AbstractC1103mg {
    public final F10 h;
    public final /* synthetic */ J10 i;

    public E10(J10 j10, F10 f10) {
        this.i = j10;
        this.h = f10;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        ArrayList arrayList = new ArrayList();
        this.h.getClass();
        File fileB = J10.b();
        if (fileB == null) {
            arrayList.add(new NZ(null, 0L, 0L, 2));
        } else {
            String absolutePath = fileB.getAbsolutePath();
            long usableSpace = fileB.getUsableSpace();
            long totalSpace = fileB.getTotalSpace();
            boolean z = false;
            arrayList.add(new NZ(absolutePath, usableSpace, totalSpace, 0));
            J10 j10 = this.i;
            j10.getClass();
            Gr1.h(0, 3, "MobileDownload.Location.DirectoryType");
            j10.e = Environment.getExternalStorageDirectory().getAbsolutePath();
            I10 i10A = F10.a();
            ArrayList<File> arrayList2 = Build.VERSION.SDK_INT > 29 ? i10A.a : i10A.b;
            if (!arrayList2.isEmpty()) {
                for (File file : arrayList2) {
                    if (file != null) {
                        arrayList.add(new NZ(file.getAbsolutePath(), file.getUsableSpace(), file.getTotalSpace(), 1));
                        z = true;
                    }
                }
                if (z) {
                    Gr1.h(1, 3, "MobileDownload.Location.DirectoryType");
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        J10 j10 = this.i;
        j10.d = (ArrayList) obj;
        j10.a = true;
        j10.b = false;
        ArrayList arrayList = j10.f;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).a0(j10.d);
        }
        arrayList.clear();
        j10.c = null;
    }
}
