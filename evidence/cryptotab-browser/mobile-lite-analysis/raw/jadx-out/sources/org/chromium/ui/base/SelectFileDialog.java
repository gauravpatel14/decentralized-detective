package org.chromium.ui.base;

import J.N;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC1103mg;
import defpackage.AbstractC1499tM;
import defpackage.C0064Fa2;
import defpackage.C1233oj2;
import defpackage.Gr1;
import defpackage.InterfaceC0932jv2;
import defpackage.LP1;
import defpackage.Lt0;
import defpackage.Zf1;
import defpackage.ag1;
import defpackage.eg1;
import defpackage.uD1;
import defpackage.v61;
import defpackage.vD1;
import defpackage.wD1;
import defpackage.xD1;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.chromium.ui.base.SelectFileDialog;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.permissions.PermissionCallback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SelectFileDialog implements InterfaceC0932jv2, eg1 {
    public static final long D = TimeUnit.HOURS.toMillis(1);
    public static final String[] E = {".apng", ".bmp", ".gif", ".jpeg", ".jpg", ".png", ".tif", ".tiff", ".xcf", ".webp"};
    public static final String[] F = {".asf", ".avhcd", ".avi", ".divx", ".flv", ".mov", ".mp4", ".mpeg", ".mpg", ".swf", ".wmv", ".webm", ".mkv"};
    public static ag1 G;
    public static Zf1 H;
    public boolean A;
    public boolean B;
    public boolean C;
    public long t;
    public ArrayList u;
    public boolean v;
    public boolean w;
    public Uri x;
    public WindowAndroid y;
    public boolean z;

    public static Intent b(SelectFileDialog selectFileDialog) {
        selectFileDialog.getClass();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(3);
        intent.putExtra("output", selectFileDialog.x);
        LP1 lp1C = LP1.c();
        try {
            intent.setClipData(ClipData.newUri(AbstractC1499tM.a.getContentResolver(), "images", selectFileDialog.x));
            lp1C.close();
            return intent;
        } catch (Throwable th) {
            try {
                lp1C.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static SelectFileDialog create(long j) {
        SelectFileDialog selectFileDialog = new SelectFileDialog();
        selectFileDialog.t = j;
        return selectFileDialog;
    }

    public static ArrayList f(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String mimeTypeFromExtension = (String) it.next();
            if (mimeTypeFromExtension.length() == 0) {
                mimeTypeFromExtension = "";
            } else {
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(mimeTypeFromExtension);
                if (fileExtensionFromUrl.length() > 0 && (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl)) == null) {
                    mimeTypeFromExtension = "application/octet-stream";
                }
            }
            if (!mimeTypeFromExtension.startsWith("image/") && (G == null || !mimeTypeFromExtension.startsWith("video/"))) {
                return null;
            }
            if (!arrayList2.contains(mimeTypeFromExtension)) {
                arrayList2.add(mimeTypeFromExtension);
            }
        }
        return arrayList2;
    }

    public static boolean h(Context context, Uri uri) {
        try {
            return i(context, Files.readSymbolicLink(Paths.get("/proc/self/fd/" + context.getContentResolver().openFileDescriptor(uri, "r").getFd(), new String[0])).toString());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean i(Context context, String str) {
        try {
            return new File(str).getCanonicalPath().startsWith(context.getDataDir().getCanonicalPath());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n() {
        ag1 ag1Var;
        return Build.VERSION.SDK_INT >= 33 && (ag1Var = G) != null && ag1Var.b();
    }

    public static boolean q(WindowAndroid windowAndroid, SelectFileDialog selectFileDialog, boolean z, ArrayList arrayList) {
        int pickImagesMaxLimit = Build.VERSION.SDK_INT >= 33 ? MediaStore.getPickImagesMaxLimit() : 50;
        Intent intent = new Intent("android.provider.action.PICK_IMAGES");
        if (z) {
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", pickImagesMaxLimit);
        }
        intent.putExtra("forceShowBrowse", true);
        String str = "*/*";
        if (n()) {
            if (arrayList.size() == 1) {
                str = (String) arrayList.get(0);
            } else {
                Iterator it = arrayList.iterator();
                boolean z2 = false;
                boolean z3 = false;
                while (it.hasNext()) {
                    String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                    if (lowerCase.startsWith("image")) {
                        z2 = true;
                    } else if (lowerCase.startsWith("video")) {
                        z3 = true;
                    }
                    if (z2 && z3) {
                        break;
                    }
                }
                if (!z2 || !z3) {
                    str = z3 ? "video/*" : z2 ? "image/*" : "";
                }
            }
            if (str.isEmpty()) {
                return false;
            }
            intent.setType(str);
        } else {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList.toArray(new String[0]));
        }
        if (!windowAndroid.u(intent, selectFileDialog, Integer.valueOf(AbstractC0275Wp1.opening_android_media_picker))) {
            return false;
        }
        Gr1.h(1, 4, "Android.MediaPickerShown");
        return true;
    }

    @Override // defpackage.InterfaceC0932jv2
    public final void a(Intent intent, int i) {
        Zf1 zf1 = H;
        if (zf1 != null) {
            zf1.a();
        }
        if (i != -1) {
            l();
            return;
        }
        if (intent == null || (intent.getData() == null && intent.getClipData() == null)) {
            String path = "file".equals(this.x.getScheme()) ? this.x.getPath() : this.x.toString();
            String schemeSpecificPart = this.x.getSchemeSpecificPart();
            this.y.getClass();
            if (i(AbstractC1499tM.a, schemeSpecificPart)) {
                l();
                return;
            }
            m(this.t, path, this.x.getLastPathSegment());
            WindowAndroid windowAndroid = this.y;
            Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", this.x);
            windowAndroid.getClass();
            AbstractC1499tM.a.sendBroadcast(intent2);
            return;
        }
        if (intent.getData() == null && intent.getClipData() != null) {
            ClipData clipData = intent.getClipData();
            int itemCount = clipData.getItemCount();
            if (itemCount == 0) {
                l();
                return;
            }
            Uri[] uriArr = new Uri[itemCount];
            for (int i2 = 0; i2 < itemCount; i2++) {
                uriArr[i2] = clipData.getItemAt(i2).getUri();
            }
            new wD1(this, AbstractC1499tM.a, true, uriArr).c(AbstractC1103mg.e);
            return;
        }
        if ("file".equals(intent.getData().getScheme())) {
            String path2 = intent.getData().getPath();
            if (!TextUtils.isEmpty(path2)) {
                new uD1(this, AbstractC1499tM.a, path2).c(AbstractC1103mg.e);
                return;
            }
        }
        if ("content".equals(intent.getScheme())) {
            new wD1(this, AbstractC1499tM.a, false, new Uri[]{intent.getData()}).c(AbstractC1103mg.e);
            return;
        }
        l();
        int i3 = AbstractC0275Wp1.opening_file_error;
        Lt0 lt0 = WindowAndroid.P;
        String string = AbstractC1499tM.a.getString(i3);
        if (string != null) {
            C0064Fa2.c(AbstractC1499tM.a, string, 0).e();
        }
    }

    public final boolean c(String str) {
        return g(str) == this.u.size();
    }

    public final boolean d(String str) {
        return this.u.isEmpty() || this.u.contains("*/*") || g(str) > 0;
    }

    public final boolean e() {
        return this.v && c("image");
    }

    public final int g(String str) {
        Iterator it = this.u.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((String) it.next()).startsWith(str)) {
                i++;
            }
        }
        return i;
    }

    public final void j() {
        boolean zHasPermission = this.y.hasPermission("android.permission.CAMERA");
        if (this.z && zHasPermission) {
            new vD1(this, Boolean.FALSE, this.y, this).c(AbstractC1103mg.e);
        } else {
            k(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.content.Intent r15) {
        /*
            Method dump skipped, instruction units count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.ui.base.SelectFileDialog.k(android.content.Intent):void");
    }

    public final void l() {
        long j = this.t;
        o(new String[0]);
        if (j != 0) {
            N._V_JO(282, j, this);
        }
    }

    public final void m(long j, String str, String str2) {
        o(new String[]{str});
        if (j != 0) {
            N._V_JOOO(56, j, this, str, str2);
        }
    }

    public final void nativeDestroyed() {
        this.t = 0L;
    }

    public final void o(String[] strArr) {
        if (f(this.u) != null) {
            Gr1.d(strArr.length, "Android.SelectFileDialogImgCount");
        }
        new xD1(this, AbstractC1499tM.a.getContentResolver(), strArr, this.C).c(AbstractC1103mg.e);
    }

    public final boolean p() {
        return (e() || f(this.u) == null || G == null || this.y.j().get() == null) ? false : true;
    }

    public final void r(Intent intent, Intent intent2, Intent intent3) {
        int i;
        String str;
        String str2;
        int i2;
        String str3 = "android.intent.action.CHOOSER";
        String str4 = "android.intent.category.OPENABLE";
        if (!C1233oj2.b.f("DeprecatedExternalPickerFunction")) {
            Intent intent4 = new Intent("android.intent.action.GET_CONTENT");
            if (this.w) {
                intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent4.setType("*/*");
            ArrayList arrayList = new ArrayList(this.u);
            if (arrayList.size() > 0) {
                if (d("image") || d("video")) {
                    arrayList.add("type/nonexistent");
                }
                intent4.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList.toArray(new String[0]));
            }
            ArrayList arrayList2 = new ArrayList();
            if (d("image") && intent != null) {
                arrayList2.add(intent);
            }
            if (d("video") && intent2 != null) {
                arrayList2.add(intent2);
            }
            if (d("audio") && intent3 != null) {
                arrayList2.add(intent3);
            }
            intent4.addCategory("android.intent.category.OPENABLE");
            Intent intent5 = new Intent("android.intent.action.CHOOSER");
            if (!arrayList2.isEmpty()) {
                intent5.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList2.toArray(new Intent[0]));
            }
            intent5.putExtra("android.intent.extra.INTENT", intent4);
            if (this.y.u(intent5, this, Integer.valueOf(AbstractC0275Wp1.low_memory_error))) {
                return;
            }
            l();
            return;
        }
        Intent intent6 = new Intent("android.intent.action.GET_CONTENT");
        if (this.w) {
            i = 1;
            intent6.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        } else {
            i = 1;
        }
        intent6.setType("*/*");
        ArrayList arrayList3 = new ArrayList();
        if (this.u.size() == i) {
            i2 = (this.u.contains("*/*") ? 1 : 0) ^ i;
            str = "android.intent.action.CHOOSER";
            str2 = "android.intent.category.OPENABLE";
        } else {
            Iterator it = this.u.iterator();
            String str5 = null;
            int i3 = 0;
            while (it.hasNext()) {
                Iterator it2 = it;
                String str6 = (String) it.next();
                int i4 = i3;
                int iIndexOf = str6.indexOf(47);
                str = str3;
                if (iIndexOf == -1) {
                    str2 = str4;
                } else {
                    str2 = str4;
                    String strSubstring = str6.substring(0, iIndexOf);
                    boolean zEquals = str6.substring(iIndexOf + 1).equals("*");
                    if (str5 == null) {
                        str5 = strSubstring;
                    } else if (!str5.equals(strSubstring)) {
                    }
                    i3 = zEquals ? 1 : i4;
                    it = it2;
                    str3 = str;
                    str4 = str2;
                }
                i2 = 0;
            }
            str = str3;
            str2 = str4;
            i2 = i3;
        }
        if (i2 != 0) {
            ArrayList arrayList4 = this.u;
            if (d("image")) {
                if (intent != null) {
                    arrayList3.add(intent);
                }
                arrayList4.add("type/nonexistent");
                intent6.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList4.toArray(new String[0]));
            } else if (d("video")) {
                if (intent2 != null) {
                    arrayList3.add(intent2);
                }
                arrayList4.add("type/nonexistent");
                intent6.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList4.toArray(new String[0]));
            } else if (d("audio")) {
                if (intent3 != null) {
                    arrayList3.add(intent3);
                }
                intent6.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList4.toArray(new String[0]));
            }
            intent6.addCategory(str2);
        }
        Bundle extras = intent6.getExtras();
        if (extras == null || extras.get("android.intent.extra.MIME_TYPES") == null) {
            if (intent != null) {
                arrayList3.add(intent);
            }
            if (intent2 != null) {
                arrayList3.add(intent2);
            }
            if (intent3 != null) {
                arrayList3.add(intent3);
            }
        }
        Intent intent7 = new Intent(str);
        if (!arrayList3.isEmpty()) {
            intent7.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList3.toArray(new Intent[0]));
        }
        intent7.putExtra("android.intent.extra.INTENT", intent6);
        if (this.y.u(intent7, this, Integer.valueOf(AbstractC0275Wp1.low_memory_error))) {
            return;
        }
        l();
    }

    public void selectFile(String[] strArr, boolean z, boolean z2, WindowAndroid windowAndroid) {
        ag1 ag1Var;
        ag1 ag1Var2;
        this.u = new ArrayList(Arrays.asList(strArr));
        this.v = z;
        this.w = z2;
        this.y = windowAndroid;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        windowAndroid.getClass();
        this.z = v61.a(intent, 0);
        WindowAndroid windowAndroid2 = this.y;
        Intent intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
        windowAndroid2.getClass();
        this.A = v61.a(intent2, 0);
        WindowAndroid windowAndroid3 = this.y;
        Intent intent3 = new Intent("android.provider.MediaStore.RECORD_SOUND");
        windowAndroid3.getClass();
        this.B = v61.a(intent3, 0);
        ArrayList arrayList = new ArrayList();
        final boolean zP = p();
        if (zP) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                if ((i < 33 || (ag1Var2 = G) == null || !ag1Var2.e()) && !n() && (i < 33 || (ag1Var = G) == null || !ag1Var.a())) {
                    if (!windowAndroid.hasPermission("android.permission.READ_MEDIA_IMAGES") && d("image")) {
                        arrayList.add("android.permission.READ_MEDIA_IMAGES");
                    }
                    if (!windowAndroid.hasPermission("android.permission.READ_MEDIA_VIDEO") && d("video")) {
                        arrayList.add("android.permission.READ_MEDIA_VIDEO");
                    }
                }
            } else if (!windowAndroid.hasPermission("android.permission.READ_EXTERNAL_STORAGE")) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        } else {
            if (((this.z && d("image")) || (this.A && d("video"))) && !windowAndroid.hasPermission("android.permission.CAMERA")) {
                arrayList.add("android.permission.CAMERA");
            }
            if (this.B && d("audio") && !windowAndroid.hasPermission("android.permission.RECORD_AUDIO")) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
        }
        if (arrayList.isEmpty()) {
            j();
        } else {
            final String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            windowAndroid.t(strArr2, new PermissionCallback() { // from class: rD1
                @Override // org.chromium.ui.permissions.PermissionCallback
                public final void b(int[] iArr, String[] strArr3) {
                    String[] strArr4 = SelectFileDialog.E;
                    SelectFileDialog selectFileDialog = this.a;
                    selectFileDialog.getClass();
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (iArr[i2] == -1) {
                            if (selectFileDialog.v) {
                                selectFileDialog.l();
                                return;
                            }
                            boolean z3 = zP;
                            if (z3) {
                                int length = strArr3.length;
                                String[] strArr5 = strArr2;
                                if (length != strArr5.length) {
                                    throw new RuntimeException(String.format("Permissions arrays misaligned: %d != %d", Integer.valueOf(strArr3.length), Integer.valueOf(strArr5.length)));
                                }
                                if (!strArr3[i2].equals(strArr5[i2])) {
                                    throw new RuntimeException("Permissions arrays don't match: " + strArr3[i2] + " != " + strArr5[i2]);
                                }
                            }
                            if (z3 && (strArr3[i2].equals("android.permission.READ_EXTERNAL_STORAGE") || strArr3[i2].equals("android.permission.READ_MEDIA_IMAGES") || strArr3[i2].equals("android.permission.READ_MEDIA_VIDEO"))) {
                                int i3 = AbstractC0275Wp1.permission_denied_error;
                                Lt0 lt0 = WindowAndroid.P;
                                String string = AbstractC1499tM.a.getString(i3);
                                if (string != null) {
                                    C0064Fa2.c(AbstractC1499tM.a, string, 0).e();
                                }
                                selectFileDialog.l();
                                return;
                            }
                        }
                    }
                    selectFileDialog.j();
                }
            });
        }
    }
}
