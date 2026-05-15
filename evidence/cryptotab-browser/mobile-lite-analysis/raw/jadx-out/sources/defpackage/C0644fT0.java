package defpackage;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: renamed from: fT0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0644fT0 implements FileFilter {
    public HashSet a;
    public HashSet b;
    public HashSet c;
    public MimeTypeMap d;
    public boolean e;
    public boolean f;

    public final boolean a(Uri uri, String str) {
        if (uri != null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            Locale locale = Locale.US;
            String lowerCase = fileExtensionFromUrl.toLowerCase(locale);
            if (this.a.contains(lowerCase)) {
                return true;
            }
            if (str == null) {
                String mimeTypeFromExtension = this.d.getMimeTypeFromExtension(lowerCase);
                str = mimeTypeFromExtension != null ? mimeTypeFromExtension.toLowerCase(locale) : null;
            }
        }
        return str != null && (this.e || this.b.contains(str) || this.c.contains(str.split("/", 2)[0]));
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory() ? this.f : a(Uri.fromFile(file), null);
    }
}
